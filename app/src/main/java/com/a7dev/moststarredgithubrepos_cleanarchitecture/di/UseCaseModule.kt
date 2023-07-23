package com.a7dev.moststarredgithubrepos_cleanarchitecture.di

import com.a7dev.domain.repo.Repo
import com.a7dev.domain.usecase.GetMostStarredRepos
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(repo: Repo) : GetMostStarredRepos {
        return GetMostStarredRepos(repo)
    }
}