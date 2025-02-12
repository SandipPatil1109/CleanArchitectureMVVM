package com.example.cleanarchitecturemvvm.repository

import com.example.cleanarchitecturemvvm.data.models.CommentsItem
import com.example.cleanarchitecturemvvm.data.network.ApiService
import javax.inject.Inject

class CommentRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCommentData():List<CommentsItem>{
        val commentsData =apiService.getCommentsData()
            return commentsData
    }
}