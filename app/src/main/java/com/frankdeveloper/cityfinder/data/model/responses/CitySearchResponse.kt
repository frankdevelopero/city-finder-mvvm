package com.frankdeveloper.cityfinder.data.model.responses

data class CitySearchResponse(
    val current: Current ?=null,
    val location: Location ?= null
)