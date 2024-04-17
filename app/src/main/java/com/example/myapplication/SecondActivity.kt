package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        val countDownText: TextView = findViewById(R.id.countDownText)
        val editText: EditText = findViewById(R.id.editText)

        // Створюємо об'єкт CountDownTimer і задаємо час в мілісекундах
        val countDownTimer = object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Викликається при кожному тіку таймера
                val secondsRemaining = millisUntilFinished / 1000
                countDownText.text = secondsRemaining.toString()
            }

            override fun onFinish() {
                // Викликається після завершення таймера
                countDownText.text = "В тумбочкє!"
            }
        }

        // Запускаємо таймер
        countDownTimer.start()

        // Додаємо слухача для editText
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Не потрібно виконувати жодних дій перед зміною тексту
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Не потрібно виконувати жодних дій під час зміни тексту
            }

            override fun afterTextChanged(s: Editable?) {
                // Перевіряємо, чи текст у editText рівний "calc"
                if (s.toString() == "calc") {
                    // Якщо так, то запускаємо активіті Calc
                    val intent = Intent(this@SecondActivity, Calc::class.java)
                    startActivity(intent)
                }
            }
        })
    }
}
