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

        // 1. Kiểm tra tên khoản chi không được để trống hoặc chỉ chứa khoảng trắng
        if (tenKhoanChi.isEmpty()) {
            binding.edtTenKhoanChi120.error = "Vui lòng nhập tên khoản chi"
            binding.edtTenKhoanChi120.requestFocus()
            return
        }

        // 2. Kiểm tra ô số tiền không được để trống
        if (soTienStr.isEmpty()) {
            binding.edtSoTien120.error = "Vui lòng nhập số tiền"
            binding.edtSoTien120.requestFocus()
            return
        }

        // 3. Kiểm tra định dạng số tiền phải hợp lệ và lớn hơn 0
        val soTienDouble = soTienStr.toDoubleOrNull()
        if (soTienDouble == null || soTienDouble <= 0) {
            binding.edtSoTien120.error = "Số tiền phải lớn hơn 0"
            binding.edtSoTien120.requestFocus()
            return
        }

        // 4. Khởi tạo đối tượng sau khi đã validate an toàn tuyệt đối
        val khoanChi_120 = KhoanChi_120(
            tenKhoanChi_120 = tenKhoanChi,
            soTien_120 = soTienDouble,
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

        // 1. Kiểm tra tên khoản chi
        if (tenKhoanChi.isEmpty()) {
            binding.edtTenKhoanChi120.error = "Vui lòng nhập tên khoản chi"
            binding.edtTenKhoanChi120.requestFocus()
            return
        }

        // 2. Kiểm tra ô số tiền
        if (soTienStr.isEmpty()) {
            binding.edtSoTien120.error = "Vui lòng nhập số tiền"
            binding.edtSoTien120.requestFocus()
            return
        }

        // 3. Kiểm tra số tiền hợp lệ (> 0)
        val soTienDouble = soTienStr.toDoubleOrNull()
        if (soTienDouble == null || soTienDouble <= 0) {
            binding.edtSoTien120.error = "Số tiền phải lớn hơn 0"
            binding.edtSoTien120.requestFocus()
            return
        }

        // 4. Khởi tạo đối tượng an toàn
        val khoanChi_120 = KhoanChi_120(
            tenKhoanChi_120 = tenKhoanChi,
            soTien_120 = soTienDouble,
            ghiChu_120 = ghiChu
        )

        // 5. Chuyển màn hình qua Intent
        val intent = Intent(
            this,
            ChiTietChiTieuActivity::class.java
        )

        intent.putExtra("tenKhoanChi_120", tenKhoanChi)
        intent.putExtra("soTien_120", soTienStr)
        intent.putExtra("ghiChu_120", ghiChu)

        startActivity(intent)
    }
}