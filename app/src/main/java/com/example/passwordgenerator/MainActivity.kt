package com.example.passwordgenerator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.passwordgenerator.controller.MainActivityController
import com.example.passwordgenerator.controller.RandomPasswordGenerator
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonClick()
        checkBoxClick()
        passwordLengthMask()
    }

    private fun buttonClick() {
        buttonGeneratePassword.setOnClickListener {
            val randomPasswordGenerator = RandomPasswordGenerator()
            randomPasswordGenerator.generate(editTextPasswordLength, checkBoxUppercase, checkBoxLowercase, checkBoxNumbers, checkBoxSymbols)
        }
    }

    private fun checkBoxClick() {
        val mainActivityController = MainActivityController()
        checkBoxLowercase.setOnClickListener {
            mainActivityController.enableOrDisableGenerateButton(
                buttonGeneratePassword,
                checkBoxUppercase,
                checkBoxLowercase,
                checkBoxSymbols,
                checkBoxNumbers
            )
        }
        checkBoxUppercase.setOnClickListener {
            mainActivityController.enableOrDisableGenerateButton(
                buttonGeneratePassword,
                checkBoxUppercase,
                checkBoxLowercase,
                checkBoxSymbols,
                checkBoxNumbers
            )
        }
        checkBoxNumbers.setOnClickListener {
            mainActivityController.enableOrDisableGenerateButton(
                buttonGeneratePassword,
                checkBoxUppercase,
                checkBoxLowercase,
                checkBoxSymbols,
                checkBoxNumbers
            )
        }
        checkBoxSymbols.setOnClickListener {
            mainActivityController.enableOrDisableGenerateButton(
                buttonGeneratePassword,
                checkBoxUppercase,
                checkBoxLowercase,
                checkBoxSymbols,
                checkBoxNumbers
            )
        }
    }

    private fun passwordLengthMask() {
        val simpleMaskFormatter = SimpleMaskFormatter("NN")
        val maskTextWatcher = MaskTextWatcher(editTextPasswordLength, simpleMaskFormatter)
        editTextPasswordLength.addTextChangedListener(maskTextWatcher)
    }
}