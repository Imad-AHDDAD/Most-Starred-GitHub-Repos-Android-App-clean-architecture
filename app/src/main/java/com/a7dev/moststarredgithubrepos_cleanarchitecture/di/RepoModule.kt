package com.a7dev.moststarredgithubrepos_cleanarchitecture.di

import com.a7dev.data.remote.ApiService
import com.a7dev.data.repo.RepoImpl
import com.a7dev.domain.repo.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService) : Repo{
        return RepoImpl(apiService)
    }
}