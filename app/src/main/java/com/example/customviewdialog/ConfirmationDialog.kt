package com.example.customviewdialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.customviewdialog.databinding.ConfirmationDialogBinding

class ConfirmationDialog(
    private val context: Context,
    private val title: String,
    private val message: String,
    private val onConfirmation: () -> Unit) {

    fun show() {
        // inflate and binding the layout
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.confirmation_dialog, null)
        val binding = ConfirmationDialogBinding.bind(dialogView)

        // set the title and message of the dialog
        binding.title.text = title
        binding.message.text = message

        // Create an AlertDialog with the inflated custom layout
        val alertDialog = AlertDialog.Builder(context)
            .setView(binding.root)
            .create()

        // set positive custom view button
        binding.yesBtn.setOnClickListener {
            onConfirmation.invoke()
            alertDialog.dismiss()
        }

        // set negative custom view button
        binding.noBtn.setOnClickListener {
            alertDialog.dismiss()
        }

        // display the dialog
        alertDialog.show()
    }
}



