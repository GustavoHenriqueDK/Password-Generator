package com.example.passwordgenerator

import android.annotation.SuppressLint
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.passwordgenerator.controller.MainActivityController
import com.example.passwordgenerator.controller.RandomPasswordGenerator
import com.example.passwordgenerator.view.dialog.DialogCustomGeneratedPassword
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_dialog_generated_password.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonClick()
        checkBoxClick()
        passwordLengthMask()
    }

    @SuppressLint("ShowToast")
    private fun buttonClick() {
        buttonGeneratePassword.setOnClickListener {
            val mainActivityController = MainActivityController(this)
            val generatedPassword = mainActivityController.generateRandomPassword(
                editTextPasswordLength,
                textInputLayoutPasswordLength,
                checkBoxUppercase,
                checkBoxLowercase,
                checkBoxNumbers,
                checkBoxSymbols
            )
            if (generatedPassword != (MainActivityController.PASSWORD_LENGTH_INVALID)) {
                val dialogCustomGeneratedPassword =
                    DialogCustomGeneratedPassword(this, generatedPassword)

                setTextAndColorTextView(dialogCustomGeneratedPassword.getTextView(), generatedPassword)

                dialogCustomGeneratedPassword.setOnClickListenerInImageView(object :
                    DialogCustomGeneratedPassword.OnClickListener {
                    override fun onClick() {
                        copyToClipboard(generatedPassword)
                        Toast.makeText(applicationContext, R.string.text_copied, Toast.LENGTH_LONG)
                            .show()
                    }
                })
                dialogCustomGeneratedPassword.showDialog()
            }
        }
    }

    private fun setTextAndColorTextView(textView: TextView, password: String) {
        val randomPasswordGenerator = RandomPasswordGenerator(this)
        randomPasswordGenerator.setTextViewAccordingPasswordStrength(textView, password)
    }

    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        @Deprecated("Any other way to do that?")
        clipboard.text = text
    }

    private fun checkBoxClick() {
        val mainActivityController = MainActivityController(this)
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