package com.a7dev.data.remote
import com.a7dev.domain.entity.ReposModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("repositories")
    suspend fun getMostStarredRepos(
        @Query("q") q: String?,
        @Query("sort") sort: String?,
        @Query("order") order: String?,
        @Query("page") page: Int?
    ): ReposModel
}