package com.example.lumoslogic_assignment.data

import com.example.lumoslogic_assignment.data.PostDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {

    @GET("posts")
    suspend fun getPosts(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): List<PostDto>

    @GET("products")
    suspend fun getProsducts(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): ProductResponse
}