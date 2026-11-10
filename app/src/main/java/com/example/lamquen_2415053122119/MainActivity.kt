package com.example.lamquen_2415053122119

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Tránh giao diện bị che bởi thanh trạng thái và thanh điều hướng.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
        val edtTen = findViewById<EditText>(R.id.edtTen)
        val edtSoLuong = findViewById<EditText>(R.id.edtSoLuong)
        val btnKiemTra = findViewById<Button>(R.id.btnKiemTra)
        val btnXoa = findViewById<Button>(R.id.btnXoa)
        val tvKetQua = findViewById<TextView>(R.id.tvKetQua)

        btnKiemTra.setOnClickListener {
            // Xóa lỗi và kết quả cũ trước mỗi lần kiểm tra.
            edtTen.error = null
            edtSoLuong.error = null
            tvKetQua.text = ""

            val ten = Try20Logic.tenHopLe(edtTen.text.toString())
            val soLuong = Try20Logic.docSoLuong(
                edtSoLuong.text.toString()
            )

            if (ten == null) {
                edtTen.error = "Vui lòng nhập tên"
            }

            if (soLuong == null) {
                edtSoLuong.error = "Số lượng phải là số nguyên từ 1 đến 9"
            }

            if (ten != null && soLuong != null) {
                tvKetQua.text = Try20Logic.loiChao(ten, soLuong)
            } else if (ten == null) {
                edtTen.requestFocus()
            } else {
                edtSoLuong.requestFocus()
            }
        }

        btnXoa.setOnClickListener {
            edtTen.text.clear()
            edtSoLuong.text.clear()

            edtTen.error = null
            edtSoLuong.error = null
            tvKetQua.text = ""

            edtTen.requestFocus()
        }
    }
}