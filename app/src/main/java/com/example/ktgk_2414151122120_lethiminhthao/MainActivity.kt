package com.example.ktgk_2414151122120_lethiminhthao

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        Toast.makeText(
            this,
            "Chức năng xem chi tiết sẽ thực hiện ở Câu 2",
            Toast.LENGTH_SHORT
        ).show()
    }
}