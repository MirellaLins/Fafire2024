package com.example.retrofit.UI.cursoScreen

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.retrofit.R
import com.example.retrofit.models.Curso

class CursoViewHolder(val view: View) : ViewHolder(view) {

    fun config(curso: Curso, onDelete: (id: Int) -> Unit, onEdit: () -> Unit) {
        val tvNomeCurso = view.findViewById<TextView>(R.id.tvNomeCurso)
        tvNomeCurso.text = curso.name

        val btDelete = view.findViewById<ImageButton>(R.id.ibDelete)
        btDelete.setOnClickListener {
            onDelete(curso.id)
        }

        val btEdit = view.findViewById<ImageButton>(R.id.ibEdit)
        btEdit.setOnClickListener {
            onEdit()
        }
    }

//    companion object {
//        fun criarInstanciaCursoHolder(context: Context, parent: ViewGroup): CursoViewHolder {
//            val view = LayoutInflater.from(context).inflate(R.layout.curso_item_layout, parent, false)
//            return CursoViewHolder(view)
//        }
//    }
}