package com.example.lumoslogic_assignment.di

import com.example.lumoslogic_assignment.data.PostApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

annotation class HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

//    @Provides
//    fun provideApi(): PostApi =
//        Retrofit.Builder()
//            .baseUrl("https://jsonplaceholder.typicode.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(PostApi::class.java)


    @Provides
    fun providedata(): PostApi =
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
}