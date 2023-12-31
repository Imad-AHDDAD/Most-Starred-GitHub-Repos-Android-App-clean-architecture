package com.a7dev.domain.repo

import com.a7dev.domain.entity.ReposModel

interface Repo {
    suspend fun getMostStarredRepositoriesFromGithubApi(q: String?, sort: String?, order: String?, page: Int?): ReposModel
}