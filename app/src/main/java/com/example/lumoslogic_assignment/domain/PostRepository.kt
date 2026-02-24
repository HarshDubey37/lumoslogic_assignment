package com.example.lumoslogic_assignment.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(): Flow<PagingData<Post>>
    suspend fun getPostById(id: Int): Post?
}