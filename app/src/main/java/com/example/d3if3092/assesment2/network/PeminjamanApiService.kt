package com.example.d3if3092.assesment2.network

import com.example.d3if3092.assesment2.model.OpStatus
import com.example.d3if3092.assesment2.model.Peminjaman
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

private const val BASE_URL = "https://lutfiruhallah.my.id/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PeminjamanApiService {
    @GET("json.php")
    suspend fun getPeminjaman(
        @Query("auth") userId: String
    ): List<Peminjaman>

    @Multipart
    @POST("json.php")
    suspend fun postPeminjaman(
        @Part("auth") userId: String,
        @Part("nama") nama: RequestBody,
        @Part("barang") barang: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus

    @DELETE("json.php")
    suspend fun deletePeminjaman(
        @Query("auth") userId: String,
        @Query("id") id: String
    ): OpStatus
}

object PeminjamanApi {
    val service: PeminjamanApiService by lazy {
        retrofit.create(PeminjamanApiService::class.java)
    }
    fun getPeminjamanUrl(image: String): String {
        return "$BASE_URL$image"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }