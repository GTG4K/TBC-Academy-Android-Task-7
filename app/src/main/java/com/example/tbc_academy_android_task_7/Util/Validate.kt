package com.example.tbc_academy_android_task_7.Util

class Validate() {
    val numericRegex = Regex("\\d+")

    fun valueFilled(input: String): Boolean {
        return input.trim().isNotEmpty()
    }

    fun isNumeric(input: String): Boolean {
        return input.matches(numericRegex)
    }
}