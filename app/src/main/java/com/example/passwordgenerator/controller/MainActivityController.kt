package com.example.passwordgenerator.controller

import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivityController {

    companion object {
        const val PASSWORD_LENGTH_INVALID = "password_length_invalid"
    }

    private fun isValidPasswordLength(editText: EditText): Boolean {
        val number: Int = editText.text.toString().toInt()
        return number <= 30 && number != 0
    }

    fun generateRandomPassword(): String {
        val randomPasswordGenerator = RandomPasswordGenerator()
        return "test"
        //return randomPasswordGenerator.generate()
    }

    fun enableOrDisableGenerateButton(
        button: Button,
        checkBox1: CheckBox,
        checkBox2: CheckBox,
        checkBox3: CheckBox,
        checkBox4: CheckBox
    ) {
        button.isEnabled =
            checkBox1.isChecked || checkBox2.isChecked || checkBox3.isChecked || checkBox4.isChecked
    }
}