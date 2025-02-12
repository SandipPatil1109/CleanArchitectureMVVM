package com.example.cleanarchitecturemvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturemvvm.data.models.CommentsItem
import com.example.cleanarchitecturemvvm.repository.CommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(val repository: CommentRepository) : ViewModel() {

    val _commentLiveData = MutableLiveData<List<CommentsItem>>()
    val commentLiveData = _commentLiveData


    fun getCommentData() {
        viewModelScope.launch {
            val commentData = repository.getCommentData()
            if (commentData.isNullOrEmpty() || commentData.equals("")) {
                _commentLiveData.value = emptyList<CommentsItem>()
            } else {
                _commentLiveData.value = commentData
            }
        }
    }


}