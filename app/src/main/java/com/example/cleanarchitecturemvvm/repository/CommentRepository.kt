package com.example.cleanarchitecturemvvm.repository

import com.example.cleanarchitecturemvvm.data.models.CommentsItem
import com.example.cleanarchitecturemvvm.data.network.ApiService
import utils.ApiResponse
import utils.safeCall
import javax.inject.Inject

class CommentRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCommentData():ApiResponse<List<CommentsItem>>{
       return safeCall { apiService.getCommentsData() }
    }
}