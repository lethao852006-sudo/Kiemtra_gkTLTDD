package com.example.ktgk_2414151122120_lethiminhthao

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2414151122120_lethiminhthao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Lưu đối tượng khoản chi hiện tại
    private var khoanChi_120: KhoanChi_120? = null

    // Nhận kết quả từ màn hình Chỉnh sửa khoản chi
    private val chinhSuaLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {

                val data = result.data ?: return@registerForActivityResult

                val tenKhoanChi =
                    data.getStringExtra(ChinhSuaChiTieuActivity.KEY_TEN_KHOAN_CHI)
                        ?: ""

                val soTien =
                    data.getStringExtra(ChinhSuaChiTieuActivity.KEY_SO_TIEN)
                        ?: ""

                val ghiChu =
                    data.getStringExtra(ChinhSuaChiTieuActivity.KEY_GHI_CHU)
                        ?: ""

                val soTienDouble = soTien.toDoubleOrNull()

                if (soTienDouble == null) {
                    Toast.makeText(
                        this,
                        "Số tiền không hợp lệ",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@registerForActivityResult
                }

                // Tạo lại đối tượng KhoanChi_120
                khoanChi_120 = KhoanChi_120(
                    tenKhoanChi_120 = tenKhoanChi,
                    soTien_120 = soTienDouble,
                    ghiChu_120 = ghiChu
                )

                hienThiKhoanChi()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        xuLySuKien()
    }

    private fun xuLySuKien() {

        // Xem chi tiết khoản chi
        binding.btnXemChiTiet.setOnClickListener {

            val tenKhoanChi =
                binding.edtTenKhoanChi.text.toString().trim()

            val soTien =
                binding.edtSoTien.text.toString().trim()

            val ghiChu =
                binding.edtGhiChu.text.toString().trim()

            // Kiểm tra tên khoản chi
            if (tenKhoanChi.isEmpty()) {
                binding.edtTenKhoanChi.error =
                    "Vui lòng nhập tên khoản chi"
                binding.edtTenKhoanChi.requestFocus()
                return@setOnClickListener
            }

            // Kiểm tra số tiền
            val soTienDouble = soTien.toDoubleOrNull()

            if (soTienDouble == null) {
                binding.edtSoTien.error =
                    "Vui lòng nhập số tiền hợp lệ"
                binding.edtSoTien.requestFocus()
                return@setOnClickListener
            }

            // Tạo đối tượng KhoanChi_120
            khoanChi_120 = KhoanChi_120(
                tenKhoanChi_120 = tenKhoanChi,
                soTien_120 = soTienDouble,
                ghiChu_120 = ghiChu
            )

            // Chuyển sang màn hình ChiTietChiTieuActivity
            val intent = Intent(
                this,
                ChiTietChiTieuActivity::class.java
            ).apply {

                putExtra(
                    "tenKhoanChi_120",
                    khoanChi_120?.tenKhoanChi_120
                )

                putExtra(
                    "soTien_120",
                    khoanChi_120?.soTien_120.toString()
                )

                putExtra(
                    "ghiChu_120",
                    khoanChi_120?.ghiChu_120
                )
            }

            startActivity(intent)
        }

        // Chỉnh sửa khoản chi
        binding.btnChinhSua.setOnClickListener {

            val tenKhoanChi =
                binding.edtTenKhoanChi.text.toString().trim()

            val soTien =
                binding.edtSoTien.text.toString().trim()

            val ghiChu =
                binding.edtGhiChu.text.toString().trim()

            if (tenKhoanChi.isEmpty()) {
                binding.edtTenKhoanChi.error =
                    "Vui lòng nhập tên khoản chi"
                binding.edtTenKhoanChi.requestFocus()
                return@setOnClickListener
            }

            if (soTien.isEmpty()) {
                binding.edtSoTien.error =
                    "Vui lòng nhập số tiền"
                binding.edtSoTien.requestFocus()
                return@setOnClickListener
            }

            // Chuyển dữ liệu hiện tại sang màn hình chỉnh sửa
            val intent = Intent(
                this,
                ChinhSuaChiTieuActivity::class.java
            ).apply {

                putExtra(
                    ChinhSuaChiTieuActivity.KEY_TEN_KHOAN_CHI,
                    tenKhoanChi
                )

                putExtra(
                    ChinhSuaChiTieuActivity.KEY_SO_TIEN,
                    soTien
                )

                putExtra(
                    ChinhSuaChiTieuActivity.KEY_GHI_CHU,
                    ghiChu
                )
            }

            chinhSuaLauncher.launch(intent)
        }
    }

    private fun hienThiKhoanChi() {

        val khoanChi = khoanChi_120 ?: return

        binding.edtTenKhoanChi.setText(
            khoanChi.tenKhoanChi_120
        )

        binding.edtSoTien.setText(
            khoanChi.soTien_120.toString()
        )

        binding.edtGhiChu.setText(
            khoanChi.ghiChu_120
        )
    }
}