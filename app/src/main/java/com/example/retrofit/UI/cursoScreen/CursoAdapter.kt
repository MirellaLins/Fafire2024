package com.example.retrofit.UI.cursoScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.models.Curso

class CursoAdapter(
    var dados: List<Curso> = emptyList(),
    val onDelete: (id: Int) -> Unit,
    val onEdit: () -> Unit
) : RecyclerView.Adapter<CursoViewHolder>() {

    fun AdicionarDados(curso: List<Curso>) {
        dados = curso
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.curso_item_layout, parent, false)
        return CursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = dados[position]
        holder.config(curso, onDelete, onEdit)
    }

    override fun getItemCount(): Int {
        return dados.size
    }
}