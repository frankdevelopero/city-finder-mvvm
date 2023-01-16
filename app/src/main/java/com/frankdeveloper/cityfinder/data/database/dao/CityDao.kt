package com.frankdeveloper.cityfinder.data.database.dao

import androidx.room.*
import com.frankdeveloper.cityfinder.data.database.entities.CityEntity

@Dao
interface CityDao {

    @Query("SELECT * FROM city_table ORDER BY id DESC")
    suspend fun getAllCities():List<CityEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city:CityEntity)

    @Delete
    suspend fun deleteCity(city: CityEntity)
}