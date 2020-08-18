package com.example.passwordgenerator.controller

import android.graphics.Color
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.example.passwordgenerator.R
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

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

    private fun isWeakPassword(password: String): Boolean {
        val patternOnlyLetter = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = patternOnlyLetter.matcher(upperCaseCharacters + lowerCaseCharacters)
        return matcher.find()
    }

    private fun isAveragePassword(password: String): Boolean {
        val patternOnlyLetter = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE)
        val matcher: Matcher =
            patternOnlyLetter.matcher(upperCaseCharacters + lowerCaseCharacters + numbersCaseCharacters)
        return matcher.find()
    }

    private fun isStrengthPassword(password: String): Boolean {
        val patternOnlyLetter = Pattern.compile("[^a-z0-9!@#$%¨&*]", Pattern.CASE_INSENSITIVE)
        val matcher: Matcher =
            patternOnlyLetter.matcher(upperCaseCharacters + lowerCaseCharacters + numbersCaseCharacters + symbolsCaseCharacters)
        return matcher.find()
    }

    fun setTextViewAccordingPasswordStrength(textView: TextView, password: String) {
        if (isWeakPassword(password)) {
            textView.setText(R.string.weak_password)
            textView.setTextColor(Color.parseColor(R.color.colorRed.toString()))
        }
        if (isAveragePassword(password)) {
            textView.setText(R.string.average_password)
            textView.setTextColor(Color.parseColor(R.color.colorYellow.toString()))
        }
        if (isStrengthPassword(password)) {
            textView.setText(R.string.strength_password)
            textView.setTextColor(Color.parseColor(R.color.colorGreen.toString()))
        }
    }

}