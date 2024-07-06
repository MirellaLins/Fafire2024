package com.example.retrofit.service

import com.example.retrofit.models.Task
import retrofit2.Call
import retrofit2.http.GET

interface ToDoService {

    @GET("tasks")
    fun getTasks(): Call<List<Task>>

}