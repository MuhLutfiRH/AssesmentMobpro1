package org.d3if3092.asesmenmobpro2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.d3if3092.assesment2.model.Peminjaman
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3092.asesmenmobpro2.database.PeminjamanDao

class MainViewModel (dao: PeminjamanDao): ViewModel() {

    val data: StateFlow<List<Peminjaman>> = dao.getPeminjaman().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(0L),
        initialValue = emptyList()
    )

}