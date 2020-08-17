package com.example.passwordgenerator.controller

import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import java.util.*

class MainActivityController {

    companion object {
        const val PASSWORD_LENGTH_INVALID = "password_length_invalid"
    }

    private fun isValidPasswordLength(editText: EditText): Boolean {
        val number: Int = editText.text.toString().toInt()
        return number <= 30 && number != 0
    }

    fun generateRandomPassword(
        editText: EditText,
        checkBoxUpperCase: CheckBox,
        checkBoxLowerCase: CheckBox,
        checkBoxNumbers: CheckBox,
        checkBoxSymbols: CheckBox
    ): String {
        return if (isValidPasswordLength(editText)) {
            generateRandomPasswordAccordingSettings(editText, checkBoxUpperCase, checkBoxLowerCase, checkBoxNumbers, checkBoxSymbols)
        } else {
            PASSWORD_LENGTH_INVALID
        }
    }

    private fun generateRandomPasswordAccordingSettings(editText: EditText,
                                                        checkBoxUpperCase: CheckBox,
                                                        checkBoxLowerCase: CheckBox,
                                                        checkBoxNumbers: CheckBox,
                                                        checkBoxSymbols: CheckBox): String {
        val random = Random()
        return random.nextInt(10).toString()
    }
}