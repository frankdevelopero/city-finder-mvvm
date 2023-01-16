package com.frankdeveloper.cityfinder.presentation.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frankdeveloper.cityfinder.domain.model.City
import com.frankdeveloper.cityfinder.domain.usecase.GetCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase
): ViewModel() {

    val cities = MutableLiveData<List<City>>()

    fun getCities(){
        viewModelScope.launch {
            val cityList = getCitiesUseCase()
            cities.postValue(cityList)
        }
    }

    fun deleteCity(city: City){
        viewModelScope.launch {
            getCitiesUseCase.deleteCity(city)
        }
    }
}