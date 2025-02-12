package com.example.cleanarchitecturemvvm.data.network

import com.example.cleanarchitecturemvvm.data.models.CommentsItem
import retrofit2.http.GET

interface ApiService {


    //this is second commit

    //stash changes
    @GET("/comments")
    suspend fun getCommentsData():List<CommentsItem>
}