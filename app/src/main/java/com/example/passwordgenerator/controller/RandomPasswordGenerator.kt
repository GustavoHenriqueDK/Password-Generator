package com.example.passwordgenerator.controller

import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import java.util.*

class RandomPasswordGenerator {

    private val upperCaseCharacters: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val lowerCaseCharacters: String = "abcdefghijklmnopqrstuvwxyz"
    private val numbersCaseCharacters: String = "0123456789"
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
        editText: EditText,
        checkBoxUppercase: CheckBox,
        checkBoxLowercase: CheckBox,
        checkBoxNumberscase: CheckBox,
        checkBoxsymbols: CheckBox
    ): String {
        var allCharacters = ""
        val lengthOfInputString: Int = editText.text.toString().toInt()
        var generatedString = ""
        var characterCounter = 0

        if (useUpperCase(checkBoxUppercase.isChecked)) {
            allCharacters += upperCaseCharacters
        }
        if (useLowerCase(checkBoxLowercase.isChecked)) {
            allCharacters += lowerCaseCharacters
        }
        if (useNumbers(checkBoxNumberscase.isChecked)) {
            allCharacters += numbersCaseCharacters
        }
        if (useSymbols(checkBoxsymbols.isChecked)) {
            allCharacters += symbolsCaseCharacters
        }
        val random = Random()
        val charactersQuantity = allCharacters.length
        while (characterCounter != lengthOfInputString) {
            generatedString += allCharacters[random.nextInt(charactersQuantity)].toString()
            characterCounter += 1
        }
        return generatedString
    }
}