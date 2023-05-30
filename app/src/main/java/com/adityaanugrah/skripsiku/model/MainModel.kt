package com.adityaanugrah.skripsiku.model

data class MainModel (
    val result: ArrayList<Result>) {
    data class Result(
        val alamat: String,
        val created_at: String,
        val deskripsi: String,
        val fasilitas: String,
        val gambar: String,
        val id: Int,
        val jamBuka: String,
        val jamTutup: String,
        val kategori: String,
        val namaWisata: String,
        val updated_at: String,
        val koordinat: String
    )

}