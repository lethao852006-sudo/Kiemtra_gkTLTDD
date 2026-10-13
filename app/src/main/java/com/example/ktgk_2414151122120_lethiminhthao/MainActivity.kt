package com.example.ktgk_2414151122120_lethiminhthao

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.example.ktgk_2414151122120_lethiminhthao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnThemKhoanChi120.setOnClickListener {
            xuLyThemKhoanChi120()
        }

        binding.btnXemChiTiet120.setOnClickListener {
            xuLyXemChiTiet120()
        }
    }

    private fun xuLyThemKhoanChi120() {

        val tenKhoanChi = binding.edtTenKhoanChi120.text.toString().trim()
        val soTien = binding.edtSoTien120.text.toString().trim()
        val ghiChu = binding.edtGhiChu120.text.toString().trim()
        val khoanChi_120 = KhoanChi_120(
            tenKhoanChi_120 = tenKhoanChi,
            soTien_120 = soTien.toDouble(),
            ghiChu_120 = ghiChu
        )

        if (tenKhoanChi.isEmpty()) {
            binding.edtTenKhoanChi120.error = "Vui lòng nhập tên khoản chi"
            binding.edtTenKhoanChi120.requestFocus()
            return
        }

        if (soTien.isEmpty()) {
            binding.edtSoTien120.error = "Vui lòng nhập số tiền"
            binding.edtSoTien120.requestFocus()
            return
        }

        val soTienDouble = soTien.toDoubleOrNull()

        if (soTienDouble == null || soTienDouble <= 0) {
            binding.edtSoTien120.error = "Số tiền phải lớn hơn 0"
            binding.edtSoTien120.requestFocus()
            return
        }

        Toast.makeText(
            this,
            "Đã thêm khoản chi: $tenKhoanChi",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun xuLyXemChiTiet120() {

        val tenKhoanChi = binding.edtTenKhoanChi120.text.toString().trim()
        val soTien = binding.edtSoTien120.text.toString().trim()
        val ghiChu = binding.edtGhiChu120.text.toString().trim()
        val khoanChi_120 = KhoanChi_120(
            tenKhoanChi_120 = tenKhoanChi,
            soTien_120 = soTien.toDouble(),
            ghiChu_120 = ghiChu
        )

        if (tenKhoanChi.isEmpty()) {
            binding.edtTenKhoanChi120.error =
                "Vui lòng nhập tên khoản chi"
            binding.edtTenKhoanChi120.requestFocus()
            return
        }

        if (soTien.isEmpty()) {
            binding.edtSoTien120.error =
                "Vui lòng nhập số tiền"
            binding.edtSoTien120.requestFocus()
            return
        }

        val soTienDouble = soTien.toDoubleOrNull()

        if (soTienDouble == null || soTienDouble <= 0) {
            binding.edtSoTien120.error =
                "Số tiền phải lớn hơn 0"
            binding.edtSoTien120.requestFocus()
            return
        }

        val intent = Intent(
            this,
            ChiTietChiTieuActivity::class.java
        )

        intent.putExtra("tenKhoanChi_120", tenKhoanChi)
        intent.putExtra("soTien_120", soTien)
        intent.putExtra("ghiChu_120", ghiChu)

        startActivity(intent)

    }
}