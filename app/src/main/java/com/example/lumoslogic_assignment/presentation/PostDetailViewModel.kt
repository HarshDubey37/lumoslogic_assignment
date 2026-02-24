package com.example.lumoslogic_assignment.presentation

import androidx.lifecycle.ViewModel
import com.example.lumoslogic_assignment.domain.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    suspend fun getPost(id: Int) =
        repository.getPostById(id)
}