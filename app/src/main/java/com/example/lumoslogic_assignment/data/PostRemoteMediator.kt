package com.example.lumoslogic_assignment.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.lumoslogic_assignment.producttoEntity
import com.example.lumoslogic_assignment.toEntity

@OptIn(ExperimentalPagingApi::class)
class PostRemoteMediator(
    private val api: PostApi,
    private val db: AppDatabase
) : RemoteMediator<Int, PostEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PostEntity>
    ): MediatorResult {

        val page = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.APPEND -> (state.pages.size + 1)
            LoadType.PREPEND -> return MediatorResult.Success(true)
        }

        return try {
//            val response = api.getPosts(page, state.config.pageSize)
            val response = api.getProsducts(page, state.config.pageSize)

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.postDao().clearAll()
                }
                db.postDao().insertAll(response.products.map { it.producttoEntity() })
            }

            MediatorResult.Success(endOfPaginationReached = response.products.isEmpty())

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}