package com.example.retrofit.UI

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.R
import com.example.retrofit.UI.cursoScreen.CursoActivity

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