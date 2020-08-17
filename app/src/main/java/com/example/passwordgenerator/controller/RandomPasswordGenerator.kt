package com.example.passwordgenerator.controller

import android.widget.CheckBox

class RandomPasswordGenerator {

    private val upperCaseCharacters: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val lowerCaseCharacters: String = "abcdefghijklmnopqrstuvwxyz"
    private val numbersCaseCharacters: String = "1234567890"
    private val symbolsCaseCharacters: String = "!@#$%&*"

    fun useUpperCase(use: Boolean): Boolean {
        return use
    }

    fun useLowerCase(use: Boolean): Boolean {
        return use
    }

    fun useNumbers(use: Boolean): Boolean {
        return use
    }

    fun useSymbols(use: Boolean): Boolean {
        return use
    }

    fun generate(
        checkBoxUpperCase: CheckBox,
        checkBoxLowerCase: CheckBox,
        checkBoxNumbersCase: CheckBox,
        checkBoxSymbols: CheckBox
    ): String {
        val charactersList = ArrayList<String>()

        if (useUpperCase(checkBoxUpperCase.isChecked)) {
            charactersList.add(upperCaseCharacters)
        }
        if (useLowerCase(checkBoxLowerCase.isChecked)) {
            charactersList.add(lowerCaseCharacters)
        }
        if (useNumbers(checkBoxNumbersCase.isChecked)) {
            charactersList.add(numbersCaseCharacters)
        }
        if (useSymbols(checkBoxSymbols.isChecked)) {
            charactersList.add(symbolsCaseCharacters)
        }
        return "a"
    }
}