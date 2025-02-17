package com.example.cleanarchitecturemvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturemvvm.data.models.CommentsItem
import com.example.cleanarchitecturemvvm.repository.CommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import utils.ApiResponse
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(val repository: CommentRepository) : ViewModel() {

    val _commentLiveData = MutableLiveData<ApiResponse<List<CommentsItem>>>()
    val commentLiveData = _commentLiveData


    fun getCommentData() {
        viewModelScope.launch {
            _commentLiveData.value = ApiResponse.Loading
            _commentLiveData.value = repository.getCommentData()

        }
    }


}