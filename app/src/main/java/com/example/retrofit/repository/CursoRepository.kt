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

    fun buscarCursoPorId(
        idCurso: Int,
        onCall: (curso: Curso?) -> Unit,
        onError: (mensagem: String) -> Unit){

        servico.getCursoPorId(idCurso).enqueue(object : Callback<Curso> {
            override fun onResponse(p0: Call<Curso>, response: Response<Curso>) {
                if (response.isSuccessful) {
                    val curso = response.body()
                    onCall(curso)
                } else {
                    if (response.code() == 404)
                        onError("Dado não exite na base")
                    else
                        onError(response.message())
                }
            }

            override fun onFailure(p0: Call<Curso>, p1: Throwable) {
                val mensagem = p1.message
                if (mensagem != null)
                    onError(mensagem)
            }
        })

    }

    fun alterarCurso(
        idCurso: Int,
        curso: Curso,
        onCall: (curso: Curso?) -> Unit,
        onError: (mensagem: String) -> Unit
    ){
        servico.putCurso(idCurso, curso).enqueue(object : Callback<Curso> {
            override fun onResponse(p0: Call<Curso>, p1: Response<Curso>) {
                onCall(p1.body())
            }

            override fun onFailure(p0: Call<Curso>, p1: Throwable) {
                onError(p1.message ?: "")
            }
        })
    }

    fun apagarCurso(
        idCurso: Int,
        onCall: () -> Unit,
        onError: (mensagem: String) -> Unit
    ){
        servico.deleteCurso(idCurso).enqueue(object : Callback<Any> {
            override fun onResponse(p0: Call<Any>, p1: Response<Any>) {
                onCall()
            }

            override fun onFailure(p0: Call<Any>, p1: Throwable) {
                onError(p1.message ?: " Erro")
            }
        })
    }
}