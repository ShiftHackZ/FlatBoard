package com.shifthackz.flatboard.keyboard.logic.layouts

import android.content.Context
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.shifthackz.flatboard.R
import com.shifthackz.flatboard.keyboard.font.alphabet.EnglishAlphabet
import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.logic.KeyboardListener
import com.shifthackz.flatboard.keyboard.logic.controllers.KeyboardController
import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.numeric.default.DefaultNumeric
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class QwertyKeyboardLayout(context: Context, controller: KeyboardController?) :
        KeyboardLayout(context, controller) {

    constructor(context: Context): this(context, null)

    private var capsState: CapsState = CapsState.CAPS_DISABLED
    private var symbolsState: SymbolState = SymbolState.SYMBOLS_DISABLED
    private var font: BaseFont = EnglishAlphabet
    private var numeric: BaseNumeric = DefaultNumeric
    private val columnWidth = 0.09f

    private enum class CapsState {
        CAPS_DISABLED,
        CAPS_ENABLED,
        CAPS_LOCK_ENABLED
    }

    private enum class SymbolState {
        SYMBOLS_DISABLED,
        SYMBOL_ONE_DISPLAYED,
        SYMBOL_TWO_DISPLAYED,
    }

    init {
        controller?.registerListener(object: KeyboardListener {
            override fun onNumericChanged(numeric: BaseNumeric) {
                this@QwertyKeyboardLayout.numeric = numeric
                createKeyboard()
            }

            override fun onFontChanged(font: BaseFont) {
                this@QwertyKeyboardLayout.font = font
                createKeyboard()
            }

            override fun characterClicked(c: String) {
                if (capsState === CapsState.CAPS_ENABLED) {
                    capsState = CapsState.CAPS_DISABLED
                    createKeyboard()
                }
            }

            override fun specialKeyClicked(key: KeyboardController.SpecialKey) {
                when(key) {
                    KeyboardController.SpecialKey.CAPS -> {
                        capsState = when(capsState) {
                            CapsState.CAPS_DISABLED -> {
                                CapsState.CAPS_ENABLED
                            }
                            CapsState.CAPS_ENABLED -> {
                                CapsState.CAPS_LOCK_ENABLED
                            }
                            CapsState.CAPS_LOCK_ENABLED -> {
                                CapsState.CAPS_DISABLED
                            }
                        }
                        createKeyboard()
                    }
                    KeyboardController.SpecialKey.SYMBOL -> {
                        symbolsState = when(symbolsState) {
                            SymbolState.SYMBOLS_DISABLED -> {
                                SymbolState.SYMBOL_ONE_DISPLAYED
                            }
                            SymbolState.SYMBOL_ONE_DISPLAYED -> {
                                SymbolState.SYMBOL_TWO_DISPLAYED
                            }
                            SymbolState.SYMBOL_TWO_DISPLAYED -> {
                                SymbolState.SYMBOL_ONE_DISPLAYED
                            }
                        }
                        createKeyboard()
                    }
                    KeyboardController.SpecialKey.ALPHA -> {
                        symbolsState = SymbolState.SYMBOLS_DISABLED
                        createKeyboard()
                    }
                    else -> return
                }
            }
        })
    }

    override fun createRows(): List<LinearLayout> {
        if (symbolsState !== SymbolState.SYMBOLS_DISABLED) {
            return when(symbolsState) {
                SymbolState.SYMBOL_ONE_DISPLAYED -> {
                    createSymbolsOneRows()
                }
                SymbolState.SYMBOL_TWO_DISPLAYED -> {
                    createSymbolsTwoRows()
                }
                else -> {
                    ArrayList()
                }
            }
        } else {
            return when(capsState) {
                CapsState.CAPS_DISABLED -> {
                    createLowerCaseRows()
                }
                CapsState.CAPS_ENABLED -> {
                    createUpperCaseRows()
                }
                CapsState.CAPS_LOCK_ENABLED -> {
                    createUpperCaseRows()
                }
            }
        }
    }

    private fun createLowerCaseRows(): List<LinearLayout> {
        val rowTwo = ArrayList<View>()
        rowTwo.add(createButton(font.q.first, columnWidth,font.q.first))
        rowTwo.add(createButton(font.w.first, columnWidth,font.w.first))
        rowTwo.add(createButton(font.e.first, columnWidth,font.e.first))
        rowTwo.add(createButton(font.r.first, columnWidth,font.r.first))
        rowTwo.add(createButton(font.t.first, columnWidth,font.t.first))
        rowTwo.add(createButton(font.y.first, columnWidth,font.y.first))
        rowTwo.add(createButton(font.u.first, columnWidth,font.u.first))
        rowTwo.add(createButton(font.i.first, columnWidth,font.i.first))
        rowTwo.add(createButton(font.o.first, columnWidth,font.o.first))
        rowTwo.add(createButton(font.p.first, columnWidth,font.p.first))

        val rowThree = ArrayList<View>()
        rowThree.add(createSpacer((columnWidth * 0.3f)))
        rowThree.add(createButton(font.a.first, columnWidth,font.a.first))
        rowThree.add(createButton(font.s.first, columnWidth,font.s.first))
        rowThree.add(createButton(font.d.first, columnWidth,font.d.first))
        rowThree.add(createButton(font.f.first, columnWidth,font.f.first))
        rowThree.add(createButton(font.g.first, columnWidth,font.g.first))
        rowThree.add(createButton(font.h.first, columnWidth,font.h.first))
        rowThree.add(createButton(font.j.first, columnWidth,font.j.first))
        rowThree.add(createButton(font.k.first, columnWidth,font.k.first))
        rowThree.add(createButton(font.l.first, columnWidth,font.l.first))

        val rowFour = ArrayList<View>()
        rowFour.add(createCapsButton())
        rowFour.add(createButton(font.z.first, columnWidth,font.z.first))
        rowFour.add(createButton(font.x.first, columnWidth,font.x.first))
        rowFour.add(createButton(font.c.first, columnWidth,font.c.first))
        rowFour.add(createButton(font.v.first, columnWidth,font.v.first))
        rowFour.add(createButton(font.b.first, columnWidth,font.b.first))
        rowFour.add(createButton(font.n.first, columnWidth,font.n.first))
        rowFour.add(createButton(font.m.first, columnWidth,font.m.first))
        val bcksp = createButton("⌫", columnWidth * 1.5f, KeyboardController.SpecialKey.BACKSPACE)
        rowFour.add(bcksp)

        val rowFive = ArrayList<View>()
        rowFive.add(createButton("", columnWidth * 8.3f," "))
        rowFive.add(createButton("⇦", columnWidth, KeyboardController.SpecialKey.BACK))
        rowFive.add(createButton("⇨", columnWidth, KeyboardController.SpecialKey.FORWARD))

        val rows = ArrayList<LinearLayout>()
        rows.add(createNumbersRow())
        rows.add(createRow(rowTwo))
        rows.add(createRow(rowThree))
        rows.add(createRow(rowFour))
        rows.add(createRow(rowFive))

        return rows
    }

    private fun createUpperCaseRows(): List<LinearLayout> {
        val rowTwo = ArrayList<View>()
        rowTwo.add(createButton(font.q.second, columnWidth,font.q.second))
        rowTwo.add(createButton(font.w.second, columnWidth,font.w.second))
        rowTwo.add(createButton(font.e.second, columnWidth,font.e.second))
        rowTwo.add(createButton(font.r.second, columnWidth,font.r.second))
        rowTwo.add(createButton(font.t.second, columnWidth,font.t.second))
        rowTwo.add(createButton(font.y.second, columnWidth,font.y.second))
        rowTwo.add(createButton(font.u.second, columnWidth,font.u.second))
        rowTwo.add(createButton(font.i.second, columnWidth,font.i.second))
        rowTwo.add(createButton(font.o.second, columnWidth,font.o.second))
        rowTwo.add(createButton(font.p.second, columnWidth,font.p.second))

        val rowThree = ArrayList<View>()
        rowThree.add(createSpacer((columnWidth * 0.3f)))
        rowThree.add(createButton(font.a.second, columnWidth,font.a.second))
        rowThree.add(createButton(font.s.second, columnWidth,font.s.second))
        rowThree.add(createButton(font.d.second, columnWidth,font.d.second))
        rowThree.add(createButton(font.f.second, columnWidth,font.f.second))
        rowThree.add(createButton(font.g.second, columnWidth,font.g.second))
        rowThree.add(createButton(font.h.second, columnWidth,font.h.second))
        rowThree.add(createButton(font.j.second, columnWidth,font.j.second))
        rowThree.add(createButton(font.k.second, columnWidth,font.k.second))
        rowThree.add(createButton(font.l.second, columnWidth,font.l.second))

        val rowFour = ArrayList<View>()
        rowFour.add(createCapsButton())
        rowFour.add(createButton(font.z.second, columnWidth,font.z.second))
        rowFour.add(createButton(font.x.second, columnWidth,font.x.second))
        rowFour.add(createButton(font.c.second, columnWidth,font.c.second))
        rowFour.add(createButton(font.v.second, columnWidth,font.v.second))
        rowFour.add(createButton(font.b.second, columnWidth,font.b.second))
        rowFour.add(createButton(font.n.second, columnWidth,font.n.second))
        rowFour.add(createButton(font.m.second, columnWidth,font.m.second))
        rowFour.add(createButton("⌫", columnWidth * 1.5f, KeyboardController.SpecialKey.BACKSPACE))

        val rowFive = ArrayList<View>()
        rowFive.add(createButton("", columnWidth * 8.3f," "))
        rowFive.add(createButton("⇦", columnWidth, KeyboardController.SpecialKey.BACK))
        rowFive.add(createButton("⇨", columnWidth, KeyboardController.SpecialKey.FORWARD))

        val rows = ArrayList<LinearLayout>()
        rows.add(createNumbersRow())
        rows.add(createRow(rowTwo))
        rows.add(createRow(rowThree))
        rows.add(createRow(rowFour))
        rows.add(createRow(rowFive))

        return rows
    }

    private fun createSymbolsOneRows(): List<LinearLayout> {
        val rowTwo = ArrayList<View>()
        rowTwo.add(createButton("+", columnWidth,"+"))
        rowTwo.add(createButton("×", columnWidth,"×"))
        rowTwo.add(createButton("÷", columnWidth,"÷"))
        rowTwo.add(createButton("=", columnWidth,"="))
        rowTwo.add(createButton("%", columnWidth,"%"))
        rowTwo.add(createButton("_", columnWidth,"_"))
        rowTwo.add(createButton("€", columnWidth,"€"))
        rowTwo.add(createButton("£", columnWidth,"£"))
        rowTwo.add(createButton("¥", columnWidth,"¥"))
        rowTwo.add(createButton("₩", columnWidth,"₩"))
        rowTwo.add(createButton("⌫", columnWidth, KeyboardController.SpecialKey.BACKSPACE))

        val rowThree = ArrayList<View>()
        rowThree.add(createSpacer((columnWidth * 0.5f)))
        rowThree.add(createButton("@", columnWidth,"@"))
        rowThree.add(createButton("#", columnWidth,"#"))
        rowThree.add(createButton("$", columnWidth,"$"))
        rowThree.add(createButton("/", columnWidth,"/"))
        rowThree.add(createButton("^", columnWidth,"^"))
        rowThree.add(createButton("&", columnWidth,"&"))
        rowThree.add(createButton("*", columnWidth,"*"))
        rowThree.add(createButton("(", columnWidth,"("))
        rowThree.add(createButton(")", columnWidth,")"))
        if (hasNextFocus) {
            rowThree.add(createButton(
                    "Next", (columnWidth * 1.5f), KeyboardController.SpecialKey.NEXT))
        } else {
            rowThree.add(createButton(
                    "Done", (columnWidth * 1.5f), KeyboardController.SpecialKey.DONE))
        }

        val rowFour = ArrayList<View>()

        rowFour.add(createCapsButton())
        rowFour.add(createButton("-", columnWidth,"-"))
        rowFour.add(createButton("'", columnWidth,"\'"))
        rowFour.add(createButton("\"", columnWidth,"\""))
        rowFour.add(createButton(":", columnWidth,":"))
        rowFour.add(createButton(";", columnWidth,";"))
        rowFour.add(createButton("!", columnWidth,"!"))
        rowFour.add(createButton("?", columnWidth,"?"))
        rowFour.add(createButton(",", columnWidth,","))
        rowFour.add(createButton(".", columnWidth,"."))
        rowFour.add(createSpacer(columnWidth))

        val rowFive = ArrayList<View>()
        rowFive.add(createButton(
                "Sym (1/2)", (columnWidth * 2.0f), KeyboardController.SpecialKey.SYMBOL))
        rowFive.add(createButton("", columnWidth * 7.0f,""))
        rowFive.add(createButton("⇦", columnWidth, KeyboardController.SpecialKey.BACK))
        rowFive.add(createButton("⇨", columnWidth, KeyboardController.SpecialKey.FORWARD))

        val rows = ArrayList<LinearLayout>()
        rows.add(createNumbersRow())
        rows.add(createRow(rowTwo))
        rows.add(createRow(rowThree))
        rows.add(createRow(rowFour))
        rows.add(createRow(rowFive))

        return rows
    }

    private fun createSymbolsTwoRows(): List<LinearLayout> {
        val rowTwo = ArrayList<View>()
        rowTwo.add(createButton("`", columnWidth,"`"))
        rowTwo.add(createButton("~", columnWidth,"~"))
        rowTwo.add(createButton("\\", columnWidth,"\\"))
        rowTwo.add(createButton("|", columnWidth,"|"))
        rowTwo.add(createButton("<", columnWidth,"<"))
        rowTwo.add(createButton(">", columnWidth,">"))
        rowTwo.add(createButton("{", columnWidth,"{"))
        rowTwo.add(createButton("}", columnWidth,"}"))
        rowTwo.add(createButton("[", columnWidth,"["))
        rowTwo.add(createButton("]", columnWidth,"]"))
        rowTwo.add(createButton("⌫", columnWidth, KeyboardController.SpecialKey.BACKSPACE))

        val rowThree = ArrayList<View>()
        rowThree.add(createSpacer((columnWidth * 0.5f)))
        rowThree.add(createButton("▪", columnWidth,"▪"))
        rowThree.add(createButton("○", columnWidth,"○"))
        rowThree.add(createButton("●", columnWidth,"●"))
        rowThree.add(createButton("□", columnWidth,"□"))
        rowThree.add(createButton("■", columnWidth,"■"))
        rowThree.add(createButton("♤", columnWidth,"♤"))
        rowThree.add(createButton("♡", columnWidth,"♡"))
        rowThree.add(createButton("◇", columnWidth,"◇"))
        rowThree.add(createButton("♧", columnWidth,"♧"))
        if (hasNextFocus) {
            rowThree.add(createButton(
                    "Next", (columnWidth * 1.5f), KeyboardController.SpecialKey.NEXT))
        } else {
            rowThree.add(createButton(
                    "Done", (columnWidth * 1.5f), KeyboardController.SpecialKey.DONE))
        }

        val rowFour = ArrayList<View>()

        rowFour.add(createCapsButton())
        rowFour.add(createButton("☆", columnWidth,"☆"))
        rowFour.add(createButton("⊙", columnWidth,"⊙"))
        rowFour.add(createButton("⦿", columnWidth,"⦿"))
        rowFour.add(createButton("⍉", columnWidth,"⍉"))
        rowFour.add(createButton("⊛", columnWidth,"⊛"))
        rowFour.add(createButton("⟪", columnWidth,"⟪"))
        rowFour.add(createButton("⟫", columnWidth,"⟫"))
        rowFour.add(createButton("¡", columnWidth,"¡"))
        rowFour.add(createButton("¿", columnWidth,"¿"))
        rowFour.add(createSpacer(columnWidth))

        val rowFive = ArrayList<View>()
        rowFive.add(createButton(
                "Sym (2/2)", (columnWidth * 2.0f), KeyboardController.SpecialKey.SYMBOL))
        rowFive.add(createButton("", columnWidth * 7.0f,""))
        rowFive.add(createButton("⇦", columnWidth, KeyboardController.SpecialKey.BACK))
        rowFive.add(createButton("⇨", columnWidth, KeyboardController.SpecialKey.FORWARD))

        val rows = ArrayList<LinearLayout>()
        rows.add(createNumbersRow())
        rows.add(createRow(rowTwo))
        rows.add(createRow(rowThree))
        rows.add(createRow(rowFour))
        rows.add(createRow(rowFive))

        return rows
    }

    private fun createNumbersRow(): LinearLayout {
        val row = ArrayList<View>()
        row.add(createButton(numeric.one, columnWidth,numeric.one))
        row.add(createButton(numeric.two, columnWidth,numeric.two))
        row.add(createButton(numeric.three, columnWidth,numeric.three))
        row.add(createButton(numeric.four, columnWidth,numeric.four))
        row.add(createButton(numeric.five, columnWidth,numeric.five))
        row.add(createButton(numeric.six, columnWidth,numeric.six))
        row.add(createButton(numeric.seven, columnWidth,numeric.seven))
        row.add(createButton(numeric.eight, columnWidth,numeric.eight))
        row.add(createButton(numeric.nine, columnWidth,numeric.nine))
        row.add(createButton(numeric.zero, columnWidth,numeric.zero))
        return createRow(row)
    }

    private fun createCapsButton(): Button {
        val alphaText = "ABC"
        return when(symbolsState) {
            SymbolState.SYMBOLS_DISABLED -> {
                when(capsState) {
                    CapsState.CAPS_DISABLED -> {
                        createButton("⇧", columnWidth * 1.5f, KeyboardController.SpecialKey.CAPS)
                    }
                    CapsState.CAPS_ENABLED -> {
                        createButton("⬆", columnWidth * 1.5f, KeyboardController.SpecialKey.CAPS)
                    }
                    CapsState.CAPS_LOCK_ENABLED -> {
                        val button = createButton(
                                "⇧", columnWidth * 1.5f, KeyboardController.SpecialKey.CAPS)
                        button.background = button.context.getDrawable(R.drawable.button_selected_background)
                        return button
                    }
                }
            }
            SymbolState.SYMBOL_ONE_DISPLAYED -> {
                createButton(alphaText, columnWidth, KeyboardController.SpecialKey.ALPHA)
            }
            SymbolState.SYMBOL_TWO_DISPLAYED -> {
                createButton(alphaText, columnWidth, KeyboardController.SpecialKey.ALPHA)
            }
        }
    }
}