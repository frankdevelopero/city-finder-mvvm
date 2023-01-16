package com.frankdeveloper.cityfinder.domain.model

import com.frankdeveloper.cityfinder.data.database.entities.CityEntity
import com.frankdeveloper.cityfinder.data.model.responses.CitySearchResponse

data class City(val id: Int = 0, val city: String, val lat: Double, val lng: Double, val localTime: String, val condition: String)

fun CitySearchResponse.toDomain() = City(0,  location!!.name, location.lat, location.lon, location.localtime, current!!.condition.text)
fun CityEntity.toDomain() = City(id, city, lat, lng, localTime, condition)