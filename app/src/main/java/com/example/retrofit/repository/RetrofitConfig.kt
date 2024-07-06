package com.example.retrofit.repository

import com.example.retrofit.service.CursosService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://professor-allocation.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val servico = retrofit.create(CursosService::class.java)
}