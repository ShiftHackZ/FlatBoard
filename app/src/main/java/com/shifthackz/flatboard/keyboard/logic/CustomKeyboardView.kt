package com.shifthackz.flatboard.keyboard.logic

import android.content.Context
import android.graphics.Color
import android.text.InputType
import android.util.AttributeSet
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import com.shifthackz.flatboard.keyboard.expandable.ExpandableState
import com.shifthackz.flatboard.keyboard.expandable.ExpandableStateListener
import com.shifthackz.flatboard.keyboard.expandable.ExpandableView
import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.logic.controllers.DefaultKeyboardController
import com.shifthackz.flatboard.keyboard.logic.controllers.KeyboardController
import com.shifthackz.flatboard.keyboard.logic.controllers.NumberDecimalKeyboardController
import com.shifthackz.flatboard.keyboard.logic.layouts.KeyboardLayout
import com.shifthackz.flatboard.keyboard.logic.layouts.NumberDecimalKeyboardLayout
import com.shifthackz.flatboard.keyboard.logic.layouts.NumberKeyboardLayout
import com.shifthackz.flatboard.keyboard.logic.layouts.QwertyKeyboardLayout
import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.utilities.ComponentUtils
import java.util.*

class CustomKeyboardView(context: Context, attr: AttributeSet): ExpandableView(context, attr) {
    private var fieldInFocus: EditText? = null
    private val keyboards = HashMap<EditText, KeyboardLayout?>()
    private val keyboardListener: KeyboardListener

    init {
        setBackgroundColor(Color.WHITE)

        keyboardListener = object: KeyboardListener {
            override fun onNumericChanged(numeric: BaseNumeric) { }

            override fun onFontChanged(font: BaseFont) { }

            override fun characterClicked(c: String) {
                // don't need to do anything here
            }

            override fun specialKeyClicked(key: KeyboardController.SpecialKey) {
                if (key === KeyboardController.SpecialKey.DONE) {
                    translateLayout()
                } else if (key === KeyboardController.SpecialKey.NEXT) {
                    fieldInFocus?.focusSearch(View.FOCUS_DOWN)?.let {
                        it.requestFocus()
                        checkLocationOnScreen()
                        return
                    }
                }
            }
        }

        // register listener with parent (listen for state changes)
        registerListener(object: ExpandableStateListener {
            override fun onStateChange(state: ExpandableState) {
                if (state === ExpandableState.EXPANDED) {
                    checkLocationOnScreen()
                }
            }
        })

        // empty onClickListener prevents user from
        // accidentally clicking views under the keyboard
        setOnClickListener({})
        isSoundEffectsEnabled = false
    }

    fun registerEditText(type: KeyboardType, field: EditText) {
        if (!field.isEnabled) {
            return  // disabled fields do not have input connections
        }

        field.setRawInputType(InputType.TYPE_CLASS_TEXT)
        field.setTextIsSelectable(true)
        field.showSoftInputOnFocus = false
        field.isSoundEffectsEnabled = false
        field.isLongClickable = false

        val inputConnection = field.onCreateInputConnection(EditorInfo())
        keyboards[field] = createKeyboardLayout(type, inputConnection)
        keyboards[field]?.registerListener(keyboardListener)

        field.onFocusChangeListener = OnFocusChangeListener { _: View, hasFocus: Boolean ->
            if (hasFocus) {
                ComponentUtils.hideSystemKeyboard(context, field)

                // if we can find a view below this field, we want to replace the
                // done button with the next button in the attached keyboard
                field.focusSearch(View.FOCUS_DOWN)?.run {
                    if (this is EditText) keyboards[field]?.hasNextFocus = true
                }
                fieldInFocus = field

                renderKeyboard()
                if (!isExpanded) {
                    translateLayout()
                }
            } else if (!hasFocus && isExpanded) {
                for (editText in keyboards.keys) {
                    if (editText.hasFocus()) {
                        return@OnFocusChangeListener
                    }
                }
                translateLayout()
            }
        }

        field.setOnClickListener {
            if (!isExpanded) {
                translateLayout()
            }
        }
    }

    fun updateFont(font: BaseFont, field: EditText) {
        keyboards[field]?.updateFont(font)
    }

    fun updateNumeric(numeric: BaseNumeric, field: EditText) {
        keyboards[field]?.updateNumeric(numeric)
    }

//    fun autoRegisterEditTexts(rootView: ViewGroup) {
//        //registerEditTextsRecursive(rootView)
//    }

//    private fun registerEditTextsRecursive(view: View) {
//        if (view is ViewGroup) {
//            for (i in 0 until view.childCount) {
//                registerEditTextsRecursive(view.getChildAt(i))
//            }
//        } else {
//            if (view is CustomTextField) {
//                registerEditText(view.keyboardType, view)
//            } else if (view is EditText) {
//                when (view.inputType) {
//                    InputType.TYPE_CLASS_NUMBER -> {
//                        registerEditText(CustomKeyboardView.KeyboardType.NUMBER, view)
//                    }
//                    InputType.TYPE_NUMBER_FLAG_DECIMAL -> {
//                        registerEditText(CustomKeyboardView.KeyboardType.NUMBER_DECIMAL, view)
//                    }
//                    else -> {
//                        registerEditText(CustomKeyboardView.KeyboardType.QWERTY, view)
//                    }
//                }
//            }
//        }
//    }

    fun unregisterEditText(field: EditText?) {
        keyboards.remove(field)
    }

    fun clearEditTextCache() {
        keyboards.clear()
    }

    private fun renderKeyboard() {
        removeAllViews()
        val keyboard: KeyboardLayout? = keyboards[fieldInFocus]
        keyboard?.let {
            it.orientation = LinearLayout.VERTICAL
            it.createKeyboard(measuredWidth.toFloat())
            addView(keyboard)
        }
    }

    private fun createKeyboardLayout(type: KeyboardType, ic: InputConnection): KeyboardLayout? {
        when(type) {
            KeyboardType.NUMBER -> {
                return NumberKeyboardLayout(context, createKeyboardController(type, ic))
            }
            KeyboardType.NUMBER_DECIMAL -> {
                return NumberDecimalKeyboardLayout(context, createKeyboardController(type, ic))
            }
            KeyboardType.QWERTY -> {
                return QwertyKeyboardLayout(context, createKeyboardController(type, ic))
            }
            else -> return null
        }
    }

    private fun createKeyboardController(type: KeyboardType, ic: InputConnection): KeyboardController? {
        return when(type) {
            KeyboardType.NUMBER_DECIMAL -> NumberDecimalKeyboardController(ic)
            else -> DefaultKeyboardController(ic)
        }
    }

    override fun configureSelf() {
        renderKeyboard()
        checkLocationOnScreen()
    }

    /**
     * Check if fieldInFocus has a parent that is a ScrollView.
     * Ensure that ScrollView is enabled.
     * Check if the fieldInFocus is below the KeyboardLayout (measured on the screen).
     * If it is, find the deltaY between the top of the KeyboardLayout and the top of the
     * fieldInFocus, add 20dp (for padding), and scroll to the deltaY.
     * This will ensure the keyboard doesn't cover the field (if conditions above are met).
     */
    private fun checkLocationOnScreen() {
        fieldInFocus?.run {
            var fieldParent = this.parent
            while (fieldParent !== null) {
                if (fieldParent is ScrollView) {
                    if (!fieldParent.isSmoothScrollingEnabled) {
                        break
                    }

                    val fieldLocation = IntArray(2)
                    this.getLocationOnScreen(fieldLocation)

                    val keyboardLocation = IntArray(2)
                    this@CustomKeyboardView.getLocationOnScreen(keyboardLocation)

                    val fieldY = fieldLocation[1]
                    val keyboardY = keyboardLocation[1]

                    if (fieldY > keyboardY) {
                        val deltaY = (fieldY - keyboardY)
                        val scrollTo = (fieldParent.scrollY + deltaY + this.measuredHeight + 10.toDp)
                        fieldParent.smoothScrollTo(0, scrollTo)
                    }
                    break
                }
                fieldParent = fieldParent.parent
            }
        }
    }

    enum class KeyboardType {
        NUMBER,
        NUMBER_DECIMAL,
        QWERTY
    }
}
