package com.example.retrofit.service

import com.example.retrofit.models.Curso
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CursosService {

    @GET("courses")
    fun getCursos() : Call<List<Curso>>

    @POST("courses")
    fun postCursos(@Body curso: Curso) : Call<Any>

    @GET("courses/{id}")
    fun getCursoPorId(@Path("id") cursoId: Int) : Call<Curso>

    @PUT("courses/{id}")
    fun putCurso(@Path("id") cursoId: Int, @Body curso: Curso) : Call<Curso>

}