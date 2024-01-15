package com.example.learnkotlinatkhoapham

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var etNumber1: EditText
    lateinit var etNumber2: EditText
    lateinit var tvResult: TextView
    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnProduct: Button
    lateinit var btnDivision: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ qua xml
        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        tvResult = findViewById(R.id.tvResult)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnProduct = findViewById(R.id.btnProduct)
        btnDivision = findViewById(R.id.btnDivision)

        // Khởi tạo hiển thị kết quả lúc đầu
        tvResult.text = "0"

        // Tính tổng 2 số
        btnAdd.setOnClickListener {
            cal(
                etNumber1.text.toString(),
                etNumber2.text.toString(),
                "+"
            )
        }

        // Tính trừ 2 số
        btnSub.setOnClickListener {
            cal(
                etNumber1.text.toString(),
                etNumber2.text.toString(),
                "-"
            )
        }

        // Tính nhân 2 số
        btnProduct.setOnClickListener {
            cal(
                etNumber1.text.toString(),
                etNumber2.text.toString(),
                "x"
            )
        }

        // Tính chia 2 số
        btnDivision.setOnClickListener {
            cal(
                etNumber1.text.toString(),
                etNumber2.text.toString(),
                ":"
            )
        }
    }

    // Xử lý + - x :
    fun cal(number1: String, number2: String, operator: String) {

        // Xử lý lỗi cho các số nhập vào
        if (number1.trim().equals("") || number2.trim().equals("")) {
            Toast.makeText(this, "Vui lòng nhập số vào", Toast.LENGTH_SHORT).show()
            return
        }

        // Xử lý lỗi số nhập vào không phải là số nguyên
        if (number1.trim().toIntOrNull() == null || number2.trim().toIntOrNull() == null) {
            Toast.makeText(this, "Vui lòng nhập số nguyên", Toast.LENGTH_SHORT).show()
            return
        }

        var result = 0

        when (operator) {
            "+" -> result = number1.toInt() + number2.toInt()
            "-" -> result = number1.toInt() - number2.toInt()
            "x" -> result = number1.toInt() * number2.toInt()
            ":" -> result = number1.toInt() / number2.toInt()
        }

        tvResult.text = result.toString()
    }
}