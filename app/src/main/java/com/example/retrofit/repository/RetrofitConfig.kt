package com.example.retrofit.repository

import com.example.retrofit.service.CursosService
import com.example.retrofit.service.ToDoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.15.12:9090/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val servicoLocal = retrofit.create(ToDoService::class.java)

//    val servico = retrofit.create(CursosService::class.java)
}

//https://professor-allocation.onrender.com/