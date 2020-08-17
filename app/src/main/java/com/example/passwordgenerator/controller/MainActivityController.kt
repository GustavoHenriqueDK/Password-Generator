package com.example.passwordgenerator.controller

import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class MainActivityController {

    companion object {
        const val PASSWORD_LENGTH_INVALID = "password_length_invalid"
    }

    private fun isValidPasswordLength(editText: EditText): Boolean {
        val number: Int = editText.text.toString().toInt()
        return number <= 30 && number != 0
    }

    fun generateRandomPassword(editText: EditText, textInputLayout: TextInputLayout, checkBoxUppercase: CheckBox, checkBoxLowercase: CheckBox, checkBoxNumber: CheckBox, checkBoxSymbol: CheckBox): String {
        val randomPasswordGenerator = RandomPasswordGenerator()
        return if (!isValidPasswordLength(editText)) {
            textInputLayout.error = "Quantidade de caracteres inválida"
            PASSWORD_LENGTH_INVALID
        } else {
            textInputLayout.error = null
            randomPasswordGenerator.generate(editText, checkBoxUppercase, checkBoxLowercase, checkBoxNumber, checkBoxSymbol)
        }
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