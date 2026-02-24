package com.example.lumoslogic_assignment.di

import com.example.lumoslogic_assignment.data.PostRepositoryImpl
import com.example.lumoslogic_assignment.domain.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(
        impl: PostRepositoryImpl
    ): PostRepository
}