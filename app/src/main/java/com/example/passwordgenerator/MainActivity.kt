package com.example.passwordgenerator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.passwordgenerator.controller.MainActivityController
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordLengthMask()
        test()
    }

    private fun passwordLengthMask() {
        val simpleMaskFormatter = SimpleMaskFormatter("NN")
        val maskTextWatcher = MaskTextWatcher(editTextPasswordLength, simpleMaskFormatter)
        editTextPasswordLength.addTextChangedListener(maskTextWatcher)
    }

    private fun test() {
        buttonGeneratePassword.setOnClickListener {
            val mainActivityController = MainActivityController()
            if (mainActivityController.generateRandomPassword(
                    editTextPasswordLength,
                    checkBoxUppercase,
                    checkBoxLowercase,
                    checkBoxNumbers,
                    checkBoxSymbols
                ) == MainActivityController.PASSWORD_LENGTH_INVALID
            ) {
                textInputLayoutPasswordLength.error = "Quantidade de caracteres inválida"
            } else {
                textInputLayoutPasswordLength.error = null
                Log.e("testing", mainActivityController.generateRandomPassword(
                    editTextPasswordLength,
                    checkBoxUppercase,
                    checkBoxLowercase,
                    checkBoxNumbers,
                    checkBoxSymbols
                ))
            }
        }
    }
}