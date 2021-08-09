package com.latihan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_panjang: EditText = findViewById(R.id.ed_panjang)
        val ed_lebar: EditText = findViewById(R.id.ed_lebar)
        val ed_tinggi: EditText = findViewById(R.id.ed_tinggi)
        val btn_hitung: Button = findViewById(R.id.btn_hitung)
        val tv_hasil: TextView = findViewById(R.id.tv_hasil)



        btn_hitung.setOnClickListener {
            val panjang = ed_panjang.text.toString()
            val lebar = ed_lebar.text.toString()
            val tinggi = ed_tinggi.text.toString()

            val volume = panjang.toInt() + lebar.toInt() + tinggi.toInt()
            tv_hasil.text = volume.toString()
        }
    }
}