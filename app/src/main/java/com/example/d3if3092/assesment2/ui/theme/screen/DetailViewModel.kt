package org.d3if3092.asesmenmobpro2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.d3if3092.assesment2.model.Peminjaman
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3092.asesmenmobpro2.database.PeminjamanDao

class DetailViewModel(private val dao: PeminjamanDao) : ViewModel() {

    fun insert(nama: String, nim: String, nohp: String, judulbarang: String, status: String, tanggalpinjam: String, tanggalkembali: String){
        val peminjaman = Peminjaman(
            nama = nama,
            nim = nim,
            nohp = nohp,
            judulbarang = judulbarang,
            status = status,
            tanggalpinjam = tanggalpinjam,
            tanggalkembali = tanggalkembali
        )

        viewModelScope.launch(Dispatchers.IO){
            dao.insert(peminjaman)
        }
    }

    suspend fun getPeminjaman(id: Long): Peminjaman?{
        return dao.getPeminjamanById(id)
    }


    fun update(id: Long, nama: String, nim: String, nohp: String, judulbarang: String, status: String, tanggalpinjam: String, tanggalkembali: String){
        val peminjaman = Peminjaman(
            id = id,
            nama = nama,
            nim = nim,
            nohp = nohp,
            judulbarang = judulbarang,
            status = status,
            tanggalpinjam = tanggalpinjam,
            tanggalkembali = tanggalkembali
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(peminjaman)
        }
    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}