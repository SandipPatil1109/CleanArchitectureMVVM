package com.example.cleanarchitecturemvvm.data.network

import com.example.cleanarchitecturemvvm.data.models.CommentsItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/comments")
    suspend fun getCommentsData(): Response<List<CommentsItem>>
}