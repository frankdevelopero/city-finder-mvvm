package com.frankdeveloper.cityfinder.di

import android.content.Context
import androidx.room.Room
import com.frankdeveloper.cityfinder.data.database.CityDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val CITY_DATABASE_NAME = "city_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CityDatabase::class.java, CITY_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db: CityDatabase) = db.getCityDao()
}