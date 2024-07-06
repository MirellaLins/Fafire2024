package com.example.retrofit.UI

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.ConfigurationCompat
import com.example.retrofit.R
import com.example.retrofit.models.Curso
import com.example.retrofit.models.Task
import com.example.retrofit.repository.CursoRepository
import com.example.retrofit.repository.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitConfig.servicoLocal.getTasks().enqueue(object : Callback<List<Task>>{
            override fun onResponse(p0: Call<List<Task>>, p1: Response<List<Task>>) {
                Log.i(">>>", " Sucesso ")
            }

            override fun onFailure(p0: Call<List<Task>>, p1: Throwable) {
                Log.e(">>>", " Error ")
            }
        })

    }
}