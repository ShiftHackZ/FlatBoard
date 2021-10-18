package com.shifthackz.flatboard.keyboard.logic.layouts

import android.content.Context
import android.content.res.Resources
import android.os.Handler
import android.util.TypedValue
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.shifthackz.flatboard.R
import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.logic.KeyboardListener
import com.shifthackz.flatboard.keyboard.logic.controllers.KeyboardController
import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

abstract class KeyboardLayout(context: Context, private val controller: KeyboardController?,
                              var hasNextFocus: Boolean = false) : LinearLayout(context) {

    private var screenWidth = 0.0f
    internal var textSize = 20.0f

    private val Int.toDp: Int
        get() = (this / Resources.getSystem().displayMetrics.density).toInt()

    init {
        layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun createKeyboard(screenWidth: Float = this.screenWidth) {
        removeAllViews()
        this.screenWidth = screenWidth

        val keyboardWrapper = createWrapperLayout()
        for (row in createRows()) {
            keyboardWrapper.addView(row)
        }
        addView(keyboardWrapper)
    }

    fun updateFont(font: BaseFont) {
        controller?.onFontChanged(font)
    }

    fun updateNumeric(numeric: BaseNumeric) {
        controller?.onNumericChanged(numeric)
    }

    private fun createWrapperLayout(): LinearLayout {
        val wrapper = LinearLayout(context)
        val lp = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        )
        lp.topMargin = 15.toDp
        lp.bottomMargin = 15.toDp
        wrapper.layoutParams = lp
        wrapper.orientation = VERTICAL
        return wrapper
    }

    private fun createButton(text: String, widthAsPctOfScreen: Float): Button {
        val button = Button(context)
        val value = TypedValue()
        button.layoutParams = LayoutParams(
                (screenWidth * widthAsPctOfScreen).toInt(),
                LayoutParams.WRAP_CONTENT
        ).apply { setMargins(10.toDp,10.toDp,10.toDp,10.toDp) }
        button.background = ContextCompat.getDrawable(button.context, R.drawable.button_selector)
        button.context.theme.resolveAttribute(android.R.attr.selectableItemBackground, value, true)
        button.isAllCaps = false
        button.textSize = textSize
        button.text = text
        return button
    }

    internal fun createButton(text: String, widthAsPctOfScreen: Float, c: String): Button {
        val button = createButton(text, widthAsPctOfScreen)
//        PushDownAnim.setPushDownAnimTo(button)
//                .setScale(PushDownAnim.MODE_STATIC_DP, 2.89f)
//                .setOnClickListener { controller?.onKeyStroke(c) }
        button.setOnClickListener {
            controller?.onKeyStroke(c)
        }
        return button
    }

    internal fun createButton(text: String, widthAsPctOfScreen: Float,
                              key: KeyboardController.SpecialKey): Button {
        val button = createButton(text, widthAsPctOfScreen)
        button.setOnClickListener { controller?.onKeyStroke(key) }
        checkIfNeedHandleBackspace(button, key)
        return button
    }

    internal fun createSpacer(widthAsPctOfScreen: Float): View {
        val view = View(context)
        view.layoutParams = LayoutParams(
                (screenWidth * widthAsPctOfScreen).toInt(), 0
        )
        view.isEnabled = false
        view.visibility = View.INVISIBLE
        return view
    }

    internal fun createRow(buttons: List<View>): LinearLayout {
        val row = LinearLayout(context)
        row.layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        )
        orientation = HORIZONTAL
        row.gravity = Gravity.CENTER

        for (button in buttons) {
            row.addView(button)
        }
        return row
    }

    internal fun registerListener(listener: KeyboardListener) {
        controller?.registerListener(listener)
    }

    internal abstract fun createRows(): List<LinearLayout>

    private fun checkIfNeedHandleBackspace(button: Button, key: KeyboardController.SpecialKey) {
        when (key) {
            KeyboardController.SpecialKey.BACKSPACE -> {
                button.setOnTouchListener { v, event ->
                    Handler().postDelayed({ controller?.onKeyStroke(key) }, 500L)
                    return@setOnTouchListener true
                }
            }
        }
    }
}
