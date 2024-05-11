package com.example.d3if3092.assesment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="peminjaman")
data class Peminjaman(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val nim: String,
    val nohp: String,
    val judulbarang: String,
    val status: String,
    val tanggalpinjam: String,
    val tanggalkembali: String
)
