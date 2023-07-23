package com.a7dev.domain.repo

import com.a7dev.domain.entity.ReposModel

interface Repo {
    fun getMostStarredRepositoriesFromGithubApi(): ReposModel
}