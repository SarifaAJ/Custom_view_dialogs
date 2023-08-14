package com.example.customviewdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customviewdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // binding
    private lateinit var binding : ActivityMainBinding
    // image
    private var isImageChanged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // loading dialog
        val loadingDialog = LoadingDialog(this)

        // start button
        binding.startBtn.setOnClickListener {

            // confirmation dialog
            val confirmTitle = getString(R.string.title)
            val confirmText = getString(R.string.hello)

            val confirmationDialog = ConfirmationDialog(this, confirmTitle, confirmText) {
                // loading dialog
                loadingDialog.show()

                // Simulate some background work
                binding.root.postDelayed({
                    loadingDialog.dismiss()
                    showInformationDialog()
                }, 2000)
            }
            confirmationDialog.show()
        }
    }

    // information dialog
    private fun showInformationDialog() {
        val infoTitle = getString(R.string.title_2)
        val infoText = getString(R.string.greeting)

        val informationDialog = InformationDialog(this, infoTitle, infoText) {
            toggleImage()
        }
        informationDialog.show()
    }

    // Toggle image function
    private fun toggleImage() {
        isImageChanged = !isImageChanged
        if (isImageChanged) {
            binding.image.setImageResource(R.drawable.greeting) // Set your new image resource here
        } else {
            binding.image.setImageResource(R.drawable.hello) // Set the original image resource here
        }
    }
}