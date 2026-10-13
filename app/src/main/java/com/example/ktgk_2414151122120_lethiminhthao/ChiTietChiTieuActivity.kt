package com.example.ktgk_2414151122120_lethiminhthao

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2414151122120_lethiminhthao.databinding.ActivityChiTietChiTieuBinding

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChiTietChiTieuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nhanDuLieu120()

        binding.btnQuayLai120.setOnClickListener {
            finish()
        }
    }

    private fun nhanDuLieu120() {

        val tenKhoanChi = intent.getStringExtra("tenKhoanChi_120")
        val soTien = intent.getStringExtra("soTien_120")
        val ghiChu = intent.getStringExtra("ghiChu_120")

        if (tenKhoanChi.isNullOrBlank()) {
            Toast.makeText(
                this,
                "Tên khoản chi không hợp lệ",
                Toast.LENGTH_SHORT
            ).show()

            finish()
            return
        }

        if (soTien.isNullOrBlank()) {
            Toast.makeText(
                this,
                "Số tiền không hợp lệ",
                Toast.LENGTH_SHORT
            ).show()

            finish()
            return
        }

        binding.tvTenKhoanChi120.text =
            "Tên khoản chi: $tenKhoanChi"

        binding.tvSoTien120.text =
            "Số tiền: $soTien"

        binding.tvGhiChu120.text =
            "Ghi chú: ${ghiChu.orEmpty()}"
    }
}