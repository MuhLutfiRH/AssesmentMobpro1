package com.example.d3if3092.assesment2.navigation

import com.example.d3if3092.assesment2.ui.theme.screen.KEY_ID_PEMINJAMANBARANG

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FromBaru: Screen("detailScreen")
    data object FromUbah: Screen("detailScreen/{$KEY_ID_PEMINJAMANBARANG}"){
        fun withId(id: Long) = "detailScreen/$id"
    }
}