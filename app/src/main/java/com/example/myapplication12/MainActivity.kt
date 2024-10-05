package com.example.myapplication12

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editTextInput: EditText
    private lateinit var buttonProcess: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextInput = findViewById(R.id.editTextInput)
        buttonProcess = findViewById(R.id.buttonProcess)
        textViewResult = findViewById(R.id.textViewResult)

        buttonProcess.setOnClickListener {
            val input = editTextInput.text.toString()
            val (modifiedString, lowercaseCount) = processString(input)
            textViewResult.text = "Результат: \"$modifiedString\"\nКоличество маленьких латинских букв: $lowercaseCount"
        }
    }

    private fun processString(input: String): Pair<String, Int> {
        // Заменяем цифры на пробелы
        val modifiedString = input.replace(Regex("\\d"), " ")

        // Подсчитываем количество маленьких латинских букв
        val lowercaseCount = input.count { it.isLowerCase() && it.isLetter() }

        return Pair(modifiedString, lowercaseCount)
    }
}