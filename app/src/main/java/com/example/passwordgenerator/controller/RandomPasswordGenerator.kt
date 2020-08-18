package com.example.passwordgenerator.controller

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.passwordgenerator.R
import java.util.*

class RandomPasswordGenerator(
    private val context: Context
) {

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

    private fun isWeakPassword(password: String): Boolean {
        return password.equals(lowerCaseCharacters)
    }

    private fun isAveragePassword(password: String): Boolean {
        return password.contains(lowerCaseCharacters + upperCaseCharacters)
    }

    private fun isStrengthPassword(password: String): Boolean {
        return password.contains(
            lowerCaseCharacters + upperCaseCharacters + symbolsCaseCharacters + numbersCaseCharacters
        )
    }

    fun setTextViewAccordingPasswordStrength(textView: TextView, password: String) {
        val myPassword = lowerCaseCharacters
        if (isWeakPassword(myPassword)) {
            Log.e("weak", "a")
            textView.text = "Weak"
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
        }
        if (isAveragePassword(myPassword)) {
            Log.e("average", "a")
            textView.text = "Average"
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorYellow))
        }
        if (isStrengthPassword(myPassword)) {
            Log.e("strenght", "a")
            textView.text = "Strength"
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorGreen))
        } else {
            textView.text = "WTF?!"
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
        }
    }
}