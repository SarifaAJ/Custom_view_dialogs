package com.example.customviewdialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.customviewdialog.databinding.InformationDialogBinding

class InformationDialog(
    private val context: Context,
    private val title: String,
    private val message: String,
    private val onOkPressed: () -> Unit) {

    fun show() {
        // inflate and binding the layout
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.information_dialog, null)
        val binding = InformationDialogBinding.bind(dialogView)

        // set the title and message of the dialog
        binding.title.text = title
        binding.message.text = message


        // Create an AlertDialog with the inflated custom layout
        val alertDialog = AlertDialog.Builder(context)
            .setView(binding.root)
            .create()


        // set positive custom view button
        binding.okBtn.setOnClickListener {
            onOkPressed.invoke()
            alertDialog.dismiss()
        }

        // display the dialog
        alertDialog.show()
    }
}
