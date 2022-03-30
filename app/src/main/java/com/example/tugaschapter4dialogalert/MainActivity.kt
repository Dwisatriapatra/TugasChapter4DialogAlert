package com.example.tugaschapter4dialogalert

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaschapter4dialogalert.databinding.ActivityMainBinding
import com.example.tugaschapter4dialogalert.databinding.CustomLayoutDialogAlertBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //action for button hitung (custom layout)
        binding.buttonHitungCustomLayout.setOnClickListener {
            //set custom dialog
            val customDialog :CustomLayoutDialogAlertBinding = CustomLayoutDialogAlertBinding.inflate(layoutInflater)
            val dialog = AlertDialog.Builder(this)
                .setView(customDialog.root)
                .create()
            val jumlahBarang = binding.inputanJumlahBarang.text.toString().toInt()
            val hargaBarang = binding.inputanHargaBarang.text.toString().toInt()
            customDialog.customDialogTotalBelanja.text = "Total belanja = ${jumlahBarang * hargaBarang}"
            //action for buttin bayar in custom dialog
            customDialog.customDialogButtonBayar.setOnClickListener {
                val jumlah = binding.inputanJumlahBarang.text.toString().toInt()
                val harga = binding.inputanHargaBarang.text.toString().toInt()
                val totalBelanja = jumlah * harga
                val namaBarang = binding.inputanNamaBarang.text.toString()
                val uangBayar = customDialog.customDialogInputanUangBayar.text.toString().toInt()
                val kembalian = uangBayar - totalBelanja
                binding.finalResult.text = "Nama barang : $namaBarang\n" +
                        "Jumlah barang: $jumlah\n" +
                        "Harga per barang:Rp. $harga\n" +
                        "Total:Rp. $totalBelanja\n" +
                        "Uang bayar:Rp. $uangBayar\n" +
                        "Kembalian:Rp. $kembalian"
                dialog.dismiss()
            }
            dialog.show()
        }
        //action for button hitung (dialog fragment)
        binding.buttonHitungDialogFragment.setOnClickListener {
            AlertDialogFragment().show(supportFragmentManager, "abc")
        }
    }
}