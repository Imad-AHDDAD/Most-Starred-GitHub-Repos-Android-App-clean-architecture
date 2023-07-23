package com.a7dev.domain.usecase
import com.a7dev.domain.repo.Repo

class GetMostStarredRepos(private val repo: Repo) {
    suspend operator fun invoke(q: String?, sort: String?, order: String?, page: Int?) = repo.getMostStarredRepositoriesFromGithubApi(q, sort, order, page)
}