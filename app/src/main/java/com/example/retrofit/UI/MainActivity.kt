package com.example.retrofit.UI

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.ConfigurationCompat
import com.example.retrofit.R
import com.example.retrofit.models.Curso
import com.example.retrofit.repository.CursoRepository
import com.example.retrofit.repository.RetrofitConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = CursoRepository(RetrofitConfig.servico)

//        repository.criarCurso(
//            curso = curso,
//            onCall = {
//                Log.i(">>>", "Sucesso!")
//            },
//            onError = {
//                Log.e(">>>", "Erro!")
//            }
//        )

//        repository.buscarCursoPorId(
//            idCurso = 4,
//            onCall = { curso ->
//                Log.i(">>>", curso?.name ?: "")
//            },
//            onError = { mensagem ->
//                Log.e(">>>", mensagem)
//            }
//        )


        val curso = Curso(6, "Backend")
        repository.alterarCurso(
            idCurso = 6,
            curso = curso,
            onCall = { rep ->
                Log.i(">>>", rep?.name ?: "")
            },
            onError = { mensagem ->
                Log.e(">>>", mensagem)
            }
        )

    }
}