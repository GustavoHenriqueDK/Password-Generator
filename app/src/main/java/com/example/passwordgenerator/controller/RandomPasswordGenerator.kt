package com.example.passwordgenerator.controller

import android.util.Log
import android.widget.CheckBox

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
        checkBoxUpperCase: CheckBox,
        checkBoxLowerCase: CheckBox,
        checkBoxNumbersCase: CheckBox,
        checkBoxSymbols: CheckBox
    ): String {
        val charactersList = ArrayList<String>()
        var allCharacters = ""

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
        charactersList.add(allCharacters)
        Log.e("testing all characters", charactersList[0])
        return "a"
    }
}