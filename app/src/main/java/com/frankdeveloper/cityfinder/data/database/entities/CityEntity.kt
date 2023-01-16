package com.frankdeveloper.cityfinder.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.frankdeveloper.cityfinder.domain.model.City

@Entity(tableName = "city_table")
data class CityEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "lat") val lat: Double,
    @ColumnInfo(name = "lng") val lng: Double,
    @ColumnInfo(name = "localtime") val localTime: String,
    @ColumnInfo(name = "condition") val condition: String,
)

fun City.toDatabase() = CityEntity(id = id, city = city, lat = lat, lng = lng, localTime = localTime, condition)

