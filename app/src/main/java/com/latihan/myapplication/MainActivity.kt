package com.latihan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.ed_lebar)
        edtHeight = findViewById(R.id.ed_tinggi)
        edtLength = findViewById(R.id.ed_panjang)
        btnCalculate = findViewById(R.id.btn_hitung)
        tvResult = findViewById(R.id.tv_hasil)

        btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(v: View) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyField = false
        if (inputHeight.isEmpty()){
                isEmptyField = true
                edtHeight.error = "tinggi tidak boleh kosong"
            }
        if (inputLength.isEmpty()){
                isEmptyField = true
                edtLength.error = "panjang tidak boleh kosong"
            }
        if (inputWidth.isEmpty()){
                isEmptyField = true
                edtWidth.error = "lebar tidak boleh kosong"
            }

        if(!isEmptyField){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
        }
    }
}