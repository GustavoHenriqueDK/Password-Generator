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
        checkBoxUpperCase: CheckBox,
        checkBoxLowerCase: CheckBox,
        checkBoxNumbersCase: CheckBox,
        checkBoxSymbols: CheckBox
    ): String {
        var allCharacters = ""
        val lengthOfInputString: Int = editText.text.toString().toInt()
        var generatedString = ""
        var characterCounter = 0

        if (useUpperCase(checkBoxUpperCase.isChecked)) {
            allCharacters += upperCaseCharacters
        }
        if (useLowerCase(checkBoxLowerCase.isChecked)) {
            allCharacters += lowerCaseCharacters
        }
        if (useNumbers(checkBoxNumbersCase.isChecked)) {
            allCharacters += numbersCaseCharacters
        }
        if (useSymbols(checkBoxSymbols.isChecked)) {
            allCharacters += symbolsCaseCharacters
        }
        val random = Random()
        while (characterCounter != lengthOfInputString) {
            val charactersQuantity = allCharacters.length
            generatedString += allCharacters[random.nextInt(charactersQuantity)].toString()
            characterCounter += 1
        }
        Log.e("testing", generatedString)
        return "a"
    }
}