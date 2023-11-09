package com.example.tbc_academy_android_task_7

import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import com.example.tbc_academy_android_task_7.Util.Validate
import com.example.tbc_academy_android_task_7.Util.ViewGenerator
import com.example.tbc_academy_android_task_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val input = binding.etField
        val cbIsNumeric = binding.cbIsNuberic
        val tvFieldError = binding.tvFieldError
        val fieldsContainer = binding.fieldsContainer

        val validate = Validate()
        val viewGenerator = ViewGenerator(this)
        var validationPassed = true;

        binding.btnAddItem.setOnClickListener {
            validationPassed = true

            if (!validate.valueFilled(input.text.toString())) {
                validationPassed = false
                tvFieldError.text = getString(R.string.error_no_value)
                input.background = ContextCompat.getDrawable(this, R.drawable.border_flamingo)
            }

            if (cbIsNumeric.isChecked) {
                if (!validate.isNumeric(input.text.toString())) {
                    validationPassed = false
                    tvFieldError.text = getString(R.string.error_only_numbers)
                    input.background = ContextCompat.getDrawable(this, R.drawable.border_flamingo)
                }
            } else {
                if (validate.isNumeric(input.text.toString())) {
                    validationPassed = false
                    tvFieldError.text = getString(R.string.error_only_characters)
                    input.background = ContextCompat.getDrawable(this, R.drawable.border_flamingo)
                }
            }

            if (validationPassed) {
                val textView =
                    if (!cbIsNumeric.isChecked) viewGenerator.generateTextView(input.text.toString()) else viewGenerator.generateNumberView(
                        input.text.toString()
                    )

                fieldsContainer.addView(textView)

                tvFieldError.text = ""
                input.background = ContextCompat.getDrawable(this, R.drawable.et_light)
            }
        }
    }
}