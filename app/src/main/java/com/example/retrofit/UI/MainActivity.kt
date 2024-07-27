package com.example.retrofit.UI

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
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

        val menuCurso = findViewById<Button>(R.id.btCurso)
        menuCurso.setOnClickListener {
            val intent = Intent(this, CursoActivity::class.java)
            startActivity(intent)
        }

    }
}