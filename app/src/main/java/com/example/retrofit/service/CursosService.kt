package com.example.retrofit.service

import com.example.retrofit.models.Curso
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CursosService {

    @GET("courses")
    fun getCursos() : Call<List<Curso>>

    @POST("courses")
    fun postCursos(@Body curso: Curso) : Call<Any>

}