package com.example.retrofit.repository

import com.example.retrofit.models.Curso
import com.example.retrofit.service.CursosService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CursoRepository(private val servico: CursosService) {

    fun criarCurso(curso: Curso, onCall: () -> Unit, onError: () -> Unit) {
        servico.postCursos(curso).enqueue(object : Callback<Any> {
            override fun onResponse(p0: Call<Any>, p1: Response<Any>) {
                onCall()
            }

            override fun onFailure(p0: Call<Any>, p1: Throwable) {
                onError()
            }
        })
    }

    fun buscarCursos(onCall: (curso: List<Curso>?) -> Unit, onError: () -> Unit) {
        servico.getCursos().enqueue(object : Callback<List<Curso>> {
            override fun onResponse(p0: Call<List<Curso>>, response: Response<List<Curso>>) {
                val curso = response.body()
                onCall(curso)
            }

            override fun onFailure(p0: Call<List<Curso>>, p1: Throwable) {
                onError()
            }
        })
    }
}