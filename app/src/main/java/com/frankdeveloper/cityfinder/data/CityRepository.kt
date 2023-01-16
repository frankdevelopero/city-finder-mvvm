package com.frankdeveloper.cityfinder.data

import com.frankdeveloper.cityfinder.data.database.dao.CityDao
import com.frankdeveloper.cityfinder.data.database.entities.CityEntity
import com.frankdeveloper.cityfinder.data.model.responses.CitySearchResponse
import com.frankdeveloper.cityfinder.data.network.CityService
import com.frankdeveloper.cityfinder.domain.model.City
import com.frankdeveloper.cityfinder.domain.model.toDomain
import javax.inject.Inject

class CityRepository @Inject constructor(
    private val api: CityService,
    private val cityDao: CityDao
) {

    suspend fun getCityFromApi(query: String): City{
        val response: CitySearchResponse = api.getCity( query = query)
        return response.toDomain()
    }

    suspend fun getAllCitiesFromDatabase(): List<City>{
        val response: List<CityEntity> = cityDao.getAllCities()
        return response.map { it.toDomain() }
    }

    suspend fun insertCity(city: CityEntity){
        return cityDao.insertCity(city)
    }

    suspend fun deleteCity(city: CityEntity){
        return cityDao.deleteCity(city)
    }
}