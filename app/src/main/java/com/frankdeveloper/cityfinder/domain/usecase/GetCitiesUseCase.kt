package com.frankdeveloper.cityfinder.domain.usecase

import com.frankdeveloper.cityfinder.data.CityRepository
import com.frankdeveloper.cityfinder.data.database.entities.toDatabase
import com.frankdeveloper.cityfinder.domain.model.City
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(private val repository: CityRepository) {

    suspend operator fun invoke(): List<City> {
        return repository.getAllCitiesFromDatabase()
    }

    suspend fun deleteCity(city: City){
        return repository.deleteCity(city = city.toDatabase())
    }
}