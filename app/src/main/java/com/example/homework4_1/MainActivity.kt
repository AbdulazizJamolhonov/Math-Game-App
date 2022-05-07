package com.example.homework4_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var num1 = 0
    private var num2 = 0
    private var action = 0
    private var answer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questions()

        et_answer.addTextChangedListener {
            if (it.toString().length == answer.toString().length) {
                if (it.toString().toInt() == answer) {
                        Toast.makeText(this, "Javob to'g'ri \uD83D\uDC4D", Toast.LENGTH_SHORT)
                            .show()
                    et_answer.text.clear()
                    questions()
                    }
                } else {
                        Toast.makeText(this, "Noto'g'ri !!!", Toast.LENGTH_SHORT).show()
                        et_answer.text.clear()
                        questions()
                    }
                }
            }

    @SuppressLint("SetTextI18n")
    private fun questions() {
        num1 = Random().nextInt(25)
        num2 = Random().nextInt(25)
        action = Random().nextInt(4)

        when (action) {
            0 -> {
                tv_question.text = "$num1 + $num2"
                answer = num1 + num2
            }
            1 -> {
                if (num1 > num2) {
                    tv_question.text = "$num1 - $num2"
                    answer = num1 - num2
                } else {
                    questions()
                }
            }
            2 -> {
                tv_question.text = "$num1 * $num2"
                answer = num1 * num2
            }
            3 -> {
                if (num1 % num2 == 0 && num2 != 0) {
                    tv_question.text = "$num1 / $num2"
                    answer = num1 / num2
                } else {
                    questions()
                }
            }
        }
    }
}