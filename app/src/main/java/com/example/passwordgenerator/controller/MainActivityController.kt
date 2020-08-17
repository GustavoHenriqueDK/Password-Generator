package com.example.passwordgenerator.controller

import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import kotlin.random.Random

class MainActivityController {

    companion object {
        const val PASSWORD_LENGTH_INVALID = "password_length_invalid"
    }

    private fun isValidPasswordLength(editText: EditText): Boolean {
        val number: Int = editText.text.toString().toInt()
        return number < 30 && number != 0
    }
}