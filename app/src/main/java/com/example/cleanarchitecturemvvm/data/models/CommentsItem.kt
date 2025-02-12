package com.example.cleanarchitecturemvvm.data.models

import androidx.versionedparcelable.ParcelField

data class CommentsItem(
    val body: String,
    val email: String,
    val id: Int=0,
    val name: String,
    val postId: Int
)