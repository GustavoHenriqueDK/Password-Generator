package com.example.passwordgenerator.view.dialog

import android.app.Activity
import android.widget.ImageView
import android.widget.TextView
import com.example.passwordgenerator.R
import kotlinx.android.synthetic.main.alert_dialog_generated_password.view.*


class DialogCustomGeneratedPassword(
    private val activity: Activity,
    private val generatedPassword: String
) {

    private var onClickListener: OnClickListener? = null

    fun setOnClickListenerInImageView(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    private var alertDialogView =
        activity.layoutInflater.inflate(R.layout.alert_dialog_generated_password, null).apply {
            textViewGeneratedPassword.text = generatedPassword
            imageViewCopy.setOnClickListener {
                if (onClickListener != null) {
                    onClickListener?.onClick()
                }
            }
        }

    private val builder = androidx.appcompat.app.AlertDialog.Builder(activity).apply {
        setView(alertDialogView)
    }

    private val textViewGeneratedPassword: TextView =
        alertDialogView.findViewById(R.id.textViewGeneratedPassword)

    private val textViewPasswordStrength: TextView =
        alertDialogView.findViewById(R.id.textViewPasswordStrength)

    private val imageViewCopy: ImageView = alertDialogView.findViewById(R.id.imageViewCopy)

    private var currentDialog: androidx.appcompat.app.AlertDialog? = null

    private var onDialogClickListener: OnClickListener? = null

    fun showDialog() {
        if (currentDialog == null) currentDialog = builder.create()
        currentDialog?.show()
    }

    public interface OnClickListener {
        fun onClick()
    }

}