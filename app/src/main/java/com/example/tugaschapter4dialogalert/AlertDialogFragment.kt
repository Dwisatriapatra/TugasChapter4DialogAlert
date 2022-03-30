package com.example.tugaschapter4dialogalert

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.tugaschapter4dialogalert.databinding.FragmentAlertDialogBinding

class AlertDialogFragment : DialogFragment(R.layout.fragment_alert_dialog) {

    private lateinit var binding : FragmentAlertDialogBinding
    @SuppressLint("CutPasteId", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlertDialogBinding.bind(view)

        val jumlahBarang = activity?.findViewById<EditText>(R.id.inputan_jumlah_barang)!!.text.toString().toInt()
        val hargaBarang = activity?.findViewById<EditText>(R.id.inputan_harga_barang)!!.text.toString().toInt()
        binding.fragmentDialogTotalBelanja.text = "Total belanja: ${jumlahBarang * hargaBarang}"

        binding.fragmentDialogButtonBayar.setOnClickListener {
            val jumlah = activity?.findViewById<EditText>(R.id.inputan_jumlah_barang)!!.text.toString().toInt()
            val harga = activity?.findViewById<EditText>(R.id.inputan_harga_barang)!!.text.toString().toInt()
            val totalBelanja = jumlah * harga
            val namaBarang = activity?.findViewById<EditText>(R.id.inputan_nama_barang)!!.text.toString()
            val uangBayar = binding.fragmentDialogInputanUangBayar.text.toString().toInt()
            val kembalian = uangBayar - totalBelanja
            activity?.findViewById<TextView>(R.id.final_result)!!.text = "Nama barang : $namaBarang\n" +
                    "Jumlah barang: $jumlah\n" +
                    "Harga per barang:Rp. $harga\n" +
                    "Total:Rp. $totalBelanja\n" +
                    "Uang bayar:Rp. $uangBayar\n" +
                    "Kembalian:Rp. $kembalian"
            dismiss()
        }
    }
}