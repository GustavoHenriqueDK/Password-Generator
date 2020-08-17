package com.example.passwordgenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordLengthMask()
    }

    private fun passwordLengthMask() {
        val simpleMaskFormatter = SimpleMaskFormatter("NN")
        val maskTextWatcher = MaskTextWatcher(editTextPasswordLength, simpleMaskFormatter)
        editTextPasswordLength.addTextChangedListener(maskTextWatcher)
    }
}