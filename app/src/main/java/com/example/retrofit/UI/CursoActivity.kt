package com.example.retrofit.UI

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.retrofit.R
import com.example.retrofit.models.Curso
import com.example.retrofit.repository.CursoRepository
import com.example.retrofit.repository.RetrofitConfig

class CursoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_curso)

        val edtIdCurso = findViewById<EditText>(R.id.etIdCurso)
        val tvNomeCurso = findViewById<TextView>(R.id.tvNomeCurso)

        val repository = CursoRepository(RetrofitConfig.servico)

        buscarCurso(edtIdCurso, repository, tvNomeCurso)

        val edtNomeCurso = findViewById<EditText>(R.id.etNomeCurso)
        val btSalvar = findViewById<Button>(R.id.btSalvar)

        btSalvar.setOnClickListener {
            val nome = edtNomeCurso.text.toString()

            if (nome.isNotEmpty())
                criarCursos(repository, nome)
        }

        val btApagar = findViewById<Button>(R.id.btApagar)
        btApagar.setOnClickListener {
            val cursoId = edtIdCurso.text.toString()
            if (cursoId.isNotEmpty())
                repository.apagarCurso(
                    idCurso = cursoId.toInt(),
                    onCall = {
                        Log.i(">>>>", "Curso foi apagado")
                    },
                    onError = {
                        Log.e(">>>>", "Erro")
                    }
                )
        }
    }

    private fun criarCursos(repository: CursoRepository, nome: String) {
        val curso = Curso(0, nome)

        repository.criarCurso(
            curso = curso,
            onCall = {
                Log.i(">>>>", "Curso criado")
            },
            onError = {
                Log.e(">>>>", "Erro na request")
            }
        )
    }

    private fun buscarCurso(
        edtIdCurso: EditText,
        repository: CursoRepository,
        tvNomeCurso: TextView
    ) {
        edtIdCurso.addTextChangedListener { text ->
            // Executa a request
            Log.i(">>>>", "Texto digitado ${text}")

            val idCurso = text.toString()

            if (idCurso.isNotEmpty()) {
                repository.buscarCursoPorId(
                    idCurso = idCurso.toInt(),
                    onCall = { curso ->
                        Log.i(">>>>", "Curso: ${curso?.name}")
                        tvNomeCurso.text = curso?.name ?: "Não tem valor para o ID solicitado"
                    },
                    onError = { msg ->
                        Log.e(">>>>", "Deu erro!")
                        tvNomeCurso.text = msg
                    }
                )
            } else {
                tvNomeCurso.text = ""
            }
        }
    }
}