package com.frankdeveloper.cityfinder.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frankdeveloper.cityfinder.domain.usecase.SearchCitiesUseCase
import com.frankdeveloper.cityfinder.domain.model.City
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel  @Inject constructor(
    private val searchCitiesUseCase: SearchCitiesUseCase
): ViewModel() {

    val city = MutableLiveData<City>()
    val isLoading = MutableLiveData<Boolean>()

    fun searchCity(query: String){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result = searchCitiesUseCase(query = query)
            city.postValue(result)
            isLoading.postValue(false)
        }
    }
}