package com.example.joespizza.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.joespizza.domain.PizzaRecipeUseCase

class MainViewModel(
    private val pizzaRecipeUseCase: PizzaRecipeUseCase
) : ViewModel() {

    private val _state: MutableLiveData<Boolean> = MutableLiveData(false)
    val state: LiveData<Boolean> = _state

    init {
        _state.value = pizzaRecipeUseCase.canMakePizza()
    }

}