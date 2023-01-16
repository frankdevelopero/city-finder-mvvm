package com.frankdeveloper.cityfinder.data.network

import com.frankdeveloper.cityfinder.data.model.responses.CitySearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApiClient {
    @GET("current.json")
    suspend fun getCity(@Query("q") query: String, @Query("key") key: String ): Response<CitySearchResponse>
}