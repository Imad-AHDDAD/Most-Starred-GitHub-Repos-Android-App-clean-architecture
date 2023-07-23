package com.a7dev.domain.usecase
import com.a7dev.domain.repo.Repo

class GetMostStarredRepos(private val repo: Repo) {
    suspend operator fun invoke() = repo.getMostStarredRepositoriesFromGithubApi()
}