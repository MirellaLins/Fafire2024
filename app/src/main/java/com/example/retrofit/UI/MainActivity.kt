package com.example.retrofit.UI

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.R
import com.example.retrofit.models.Curso
import com.example.retrofit.repository.CursoRepository
import com.example.retrofit.repository.RetrofitConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val curso = Curso(0, "Teste 2")

        val repository = CursoRepository(RetrofitConfig.servico)

        repository.criarCurso(
            curso = curso,
            onCall = {
                Log.i(">>>", "Sucesso!")
            },
            onError = {
                Log.e(">>>", "Erro!")
            }
        )

    }
}