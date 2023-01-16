package com.frankdeveloper.cityfinder.data.network

import com.frankdeveloper.cityfinder.data.model.responses.CitySearchResponse
import com.frankdeveloper.cityfinder.utils.Constants.WEATHER_API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import javax.inject.Inject

class CityService @Inject constructor(private val api:CityApiClient) {

    suspend fun getCity(query: String): CitySearchResponse{
        return withContext(Dispatchers.IO) {
            val response = api.getCity(query = query, key = WEATHER_API_KEY)
            response.body() ?: CitySearchResponse()
        }
    }

}