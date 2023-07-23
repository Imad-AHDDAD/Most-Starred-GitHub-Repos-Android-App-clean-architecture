package com.a7dev.data.remote
import com.a7dev.domain.entity.ReposModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    /**
     * getMostStarredRepos : methods that returns a Call of ReposModel
     *
     * @param q : creation date
     * @param sort : sorts the results of owr query
     * @param order : Determines whether the first search result returned
     * is the highest number of matches (desc) or lowest number of matches (asc)
     * @param page : Page number of the results to fetch
     * @return Call<ReposModel>
     */
    @GET("repositories")
    suspend fun getMostStarredRepos(
        @Query("q") q: String?,
        @Query("sort") sort: String?,
        @Query("order") order: String?,
        @Query("page") page: Int?
    ): ReposModel
}