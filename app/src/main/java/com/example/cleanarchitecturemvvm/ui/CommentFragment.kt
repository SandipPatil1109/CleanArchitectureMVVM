package com.example.cleanarchitecturemvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.cleanarchitecturemvvm.R
import com.example.cleanarchitecturemvvm.databinding.FragmentCommentBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import utils.ApiResponse

@AndroidEntryPoint
class CommentFragment : Fragment() {

    private val commentsViewModel: CommentsViewModel by viewModels()
    private var _binding: FragmentCommentBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnComment.setOnClickListener {
            commentsViewModel.getCommentData()
        }

        commentsViewModel.commentLiveData.observe(viewLifecycleOwner, { Response ->

            when(Response){
               is ApiResponse.Success ->{binding.textShowData.text = Response.data.toString()}
               is ApiResponse.Failure -> {binding.textShowData.text = Response.message.toString()}
               is ApiResponse.Loading -> {binding.textShowData.text = resources.getString(R.string.txtLoading)}
            }
        })

    }
}