package com.example.retrofit.UI.cursoScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.repository.CursoRepository
import com.example.retrofit.repository.RetrofitConfig

class CursoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CursoAdapter
    private lateinit var repository: CursoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_curso)

        repository = CursoRepository(RetrofitConfig.servico)
        recyclerView = findViewById<RecyclerView>(R.id.rvListaCursos)
        adapter = CursoAdapter(
            onDelete = { id ->
                executarRequestDelete(id)
            },
            onEdit = {}
        )

        recyclerView.adapter = adapter

        val cursos = repository.buscarCursos() // Requisição em mock

        adapter.AdicionarDados(cursos)
    }

    private fun executarRequestDelete(id: Int) {
        repository.apagarCurso(idCurso = id, onCall = {}, onError = {})
    }
}