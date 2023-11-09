package com.example.tbc_academy_android_task_7.Util

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.tbc_academy_android_task_7.R

class ViewGenerator(val context: Context) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun generateTextView(input: String): TextView {
        val textView = TextView(context)
        textView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            (50 * context.resources.displayMetrics.density).toInt()
        )

        val drawable = ContextCompat.getDrawable(context, R.drawable.et_drawable_pen)
        val poppins: Typeface = context.resources.getFont(R.font.poppins)
        val horizontalPaddingInPixels = (15 * context.resources.displayMetrics.density).toInt()
        val drawablePaddingInPixels = (15 * context.resources.displayMetrics.density).toInt()

        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null)
        textView.compoundDrawablePadding = drawablePaddingInPixels
        textView.background = ContextCompat.getDrawable(context, R.drawable.border_flamingo)
        textView.gravity = android.view.Gravity.CENTER_VERTICAL
        textView.setTextColor(ContextCompat.getColor(context, R.color.flamingo))
        textView.setPadding(horizontalPaddingInPixels, 0, horizontalPaddingInPixels, 0)
        textView.typeface = poppins
        textView.textSize = 18f

        val generatedText = "$input : Text"
        textView.text = generatedText

        return textView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun generateNumberView(input: String): TextView {
        val textView = TextView(context)
        textView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            (50 * context.resources.displayMetrics.density).toInt()
        )

        val drawable = ContextCompat.getDrawable(context, R.drawable.et_drawable_pen_purple)
        val poppins: Typeface = context.resources.getFont(R.font.poppins)
        val horizontalPaddingInPixels = (15 * context.resources.displayMetrics.density).toInt()
        val drawablePaddingInPixels = (15 * context.resources.displayMetrics.density).toInt()

        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null)
        textView.compoundDrawablePadding = drawablePaddingInPixels
        textView.background = ContextCompat.getDrawable(context, R.drawable.border_purple)
        textView.gravity = android.view.Gravity.CENTER_VERTICAL
        textView.setTextColor(ContextCompat.getColor(context, R.color.purple))
        textView.setPadding(horizontalPaddingInPixels, 0, horizontalPaddingInPixels, 0)
        textView.typeface = poppins
        textView.textSize = 18f

        val generatedText = "$input : Number"
        textView.text = generatedText

        return textView
    }
}