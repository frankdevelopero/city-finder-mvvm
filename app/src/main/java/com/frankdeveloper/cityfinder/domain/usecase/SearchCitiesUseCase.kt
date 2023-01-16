package com.frankdeveloper.cityfinder.domain.usecase

import com.frankdeveloper.cityfinder.data.CityRepository
import com.frankdeveloper.cityfinder.data.database.entities.toDatabase
import com.frankdeveloper.cityfinder.domain.model.City
import javax.inject.Inject

class SearchCitiesUseCase @Inject constructor(private val repository: CityRepository){

    suspend operator fun invoke(query: String): City {
        val city = repository.getCityFromApi(query)
        city.let {
            repository.insertCity(city.toDatabase())
        }
        return city
    }
}