package com.example.ktgk_2414151122120_lethiminhthao

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2414151122120_lethiminhthao.databinding.ActivityChinhSuaChiTieuBinding

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChinhSuaChiTieuBinding

    companion object {
        const val KEY_TEN_KHOAN_CHI = "KEY_TEN_KHOAN_CHI"
        const val KEY_SO_TIEN = "KEY_SO_TIEN"
        const val KEY_GHI_CHU = "KEY_GHI_CHU"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChinhSuaChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hienThiDuLieuBanDau()
        xuLySuKien()
    }

    private fun hienThiDuLieuBanDau() {
        val tenKhoanChi = intent.getStringExtra(KEY_TEN_KHOAN_CHI) ?: ""
        val soTien = intent.getStringExtra(KEY_SO_TIEN) ?: ""
        val ghiChu = intent.getStringExtra(KEY_GHI_CHU) ?: ""

        binding.edtTenKhoanChi.setText(tenKhoanChi)
        binding.edtSoTien.setText(soTien)
        binding.edtGhiChu.setText(ghiChu)
    }

    private fun xuLySuKien() {

        binding.btnLuu.setOnClickListener {

            val tenKhoanChi = binding.edtTenKhoanChi.text.toString().trim()
            val soTien = binding.edtSoTien.text.toString().trim()
            val ghiChu = binding.edtGhiChu.text.toString().trim()

            val ketQua = Intent().apply {
                putExtra(KEY_TEN_KHOAN_CHI, tenKhoanChi)
                putExtra(KEY_SO_TIEN, soTien)
                putExtra(KEY_GHI_CHU, ghiChu)
            }

            setResult(RESULT_OK, ketQua)
            finish()
        }

        binding.btnHuy.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}