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
        val soTienStr = binding.edtSoTien120.text.toString().trim()
        val ghiChu = binding.edtGhiChu120.text.toString().trim()

        // 1. Lấy giá trị loại chi từ ô nhập tương ứng (đảm bảo bạn đã đặt id này trong activity_main.xml)
        val loaiChi = binding.edtLoaiChi120.text.toString().trim()

        if (tenKhoanChi.isEmpty()) {
            binding.edtTenKhoanChi120.error = "Vui lòng nhập tên khoản chi"
            binding.edtTenKhoanChi120.requestFocus()
            return
        }

        // Kiểm tra loại chi không được để trống theo yêu cầu bổ sung 1
        if (loaiChi.isEmpty()) {
            binding.edtLoaiChi120.error = "Vui lòng nhập loại chi tiêu"
            binding.edtLoaiChi120.requestFocus()
            return
        }

        if (soTienStr.isEmpty()) {
            binding.edtSoTien120.error = "Vui lòng nhập số tiền"
            binding.edtSoTien120.requestFocus()
            return
        }

        val soTienDouble = soTienStr.toDoubleOrNull()
        if (soTienDouble == null || soTienDouble <= 0) {
            binding.edtSoTien120.error = "Số tiền phải lớn hơn 0"
            binding.edtSoTien120.requestFocus()
            return
        }

        // Lúc này biến loaiChi đã tồn tại, dòng gán bên dưới sẽ hết báo lỗi đỏ
        val khoanChi_120 = KhoanChi_120(
            tenKhoanChi_120 = tenKhoanChi,
            soTien_120 = soTienDouble,
            loaiChi_120 = loaiChi,
            ghiChu_120 = ghiChu
        )

        Toast.makeText(
            this,
            "Đã thêm khoản chi: $tenKhoanChi",
            Toast.LENGTH_SHORT
        ).show()
    }
    private fun xuLyXemChiTiet120() {
        val tenKhoanChi = binding.edtTenKhoanChi120.text.toString().trim()
        val soTienStr = binding.edtSoTien120.text.toString().trim()
        val ghiChu = binding.edtGhiChu120.text.toString().trim()
        val loaiChi = binding.edtLoaiChi120.text.toString().trim() // <-- Lấy loại chi

        if (tenKhoanChi.isEmpty()) {
            binding.edtTenKhoanChi120.error = "Vui lòng nhập tên khoản chi"
            binding.edtTenKhoanChi120.requestFocus()
            return
        }

        if (loaiChi.isEmpty()) {
            binding.edtLoaiChi120.error = "Vui lòng nhập loại chi tiêu"
            binding.edtLoaiChi120.requestFocus()
            return
        }

        val soTienDouble = soTienStr.toDoubleOrNull()
        if (soTienDouble == null || soTienDouble <= 0) {
            binding.edtSoTien120.error = "Số tiền phải lớn hơn 0"
            binding.edtSoTien120.requestFocus()
            return
        }

        // Truyền dữ liệu qua Intent sang màn hình chi tiết
        val intent = Intent(this, ChiTietChiTieuActivity::class.java).apply {
            putExtra("tenKhoanChi_120", tenKhoanChi)
            putExtra("soTien_120", soTienStr)
            putExtra("ghiChu_120", ghiChu)
            putExtra("loaiChi_120", loaiChi) // <-- Đính kèm loại chi
        }

        startActivity(intent)
    }
}