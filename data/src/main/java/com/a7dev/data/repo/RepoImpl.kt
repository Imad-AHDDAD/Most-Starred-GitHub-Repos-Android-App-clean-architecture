package com.a7dev.data.repo
import com.a7dev.data.remote.ApiService
import com.a7dev.domain.entity.ReposModel
import com.a7dev.domain.repo.Repo

class RepoImpl(private val apiService: ApiService) : Repo {
    override suspend fun getMostStarredRepositoriesFromGithubApi(
        q: String?,
        sort: String?,
        order: String?,
        page: Int?
    ): ReposModel = apiService.getMostStarredRepos(q, sort, order, page)

}