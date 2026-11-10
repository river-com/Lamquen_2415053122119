package com.example.lamquen_2415053122119

object Try20Logic {

    fun tenHopLe(raw: String): String? {
        val ten = raw.trim()
        return if (ten.isNotEmpty()) ten else null
    }

    fun docSoLuong(raw: String): Int? {
        val soLuong = raw.trim().toIntOrNull() ?: return null
        return if (soLuong in 1..9) soLuong else null
    }

    fun loiChao(ten: String, soLuong: Int): String {
        return "Xin chào $ten, số lượng: $soLuong"
    }
}