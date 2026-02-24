package com.example.lumoslogic_assignment.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.lumoslogic_assignment.domain.Post
import com.example.lumoslogic_assignment.domain.PostRepository
import com.example.lumoslogic_assignment.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PostRepositoryImpl @Inject constructor(
    private val api: PostApi,
    private val db: AppDatabase
) : PostRepository {

    override fun getPosts(): Flow<PagingData<Post>> {
        val pagingSourceFactory = { db.postDao().pagingSource() }

        return Pager(
            config = PagingConfig(pageSize = 25),
            remoteMediator = PostRemoteMediator(api, db),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData ->
            pagingData.map { it.toDomain() }
        }
    }

    override suspend fun getPostById(id: Int): Post? {
        return db.postDao().getPostById(id)?.toDomain()
    }
}