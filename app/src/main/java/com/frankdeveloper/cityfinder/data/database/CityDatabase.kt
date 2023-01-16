package com.frankdeveloper.cityfinder.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.frankdeveloper.cityfinder.data.database.dao.CityDao
import com.frankdeveloper.cityfinder.data.database.entities.CityEntity

@Database(entities = [CityEntity::class], version = 1)
abstract class CityDatabase: RoomDatabase() {

    abstract fun getCityDao(): CityDao
}