package com.example.joespizza.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.joespizza.domain.GarlicBreadRecipeUseCase
import com.example.joespizza.domain.PizzaRecipeUseCase

class MainViewModel(
    private val pizzaRecipeUseCase: PizzaRecipeUseCase,
    private val garlicBreadRecipeUseCase: GarlicBreadRecipeUseCase
) : ViewModel() {

    private val _state: MutableLiveData<ViewState> = MutableLiveData(ViewState())
    val state: LiveData<ViewState> = _state

    init {
        val canMakePizza = pizzaRecipeUseCase.canMake()
        val canMakeGarlicBread = pizzaRecipeUseCase.canMake()

        _state.value = ViewState(canMakePizza, canMakeGarlicBread)
    }

    data class ViewState(
        val canMakePizza: Boolean = false,
        val canMakeGarlicBread: Boolean = false
    )
}