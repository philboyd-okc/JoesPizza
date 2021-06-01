package com.example.joespizza.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.joespizza.data.Ingredient
import com.example.joespizza.data.IngredientRepository

class MainViewModel(
    private val ingredientRepository: IngredientRepository
) : ViewModel() {

    private val _state: MutableLiveData<Boolean> = MutableLiveData(false)
    val state: LiveData<Boolean> = _state

    init {
        val canMakePizza =
            ingredientRepository.getIngredientQuantity(Ingredient.FLOUR) > 0 &&
                    ingredientRepository.getIngredientQuantity(Ingredient.WATER) > 0 &&
                    ingredientRepository.getIngredientQuantity(Ingredient.YEAST) > 0 &&
                    ingredientRepository.getIngredientQuantity(Ingredient.SALT) > 0 &&
                    ingredientRepository.getIngredientQuantity(Ingredient.MOZZARELLA) > 0 &&
                    ingredientRepository.getIngredientQuantity(Ingredient.BASIL) > 0 &&
                    ingredientRepository.getIngredientQuantity(Ingredient.TOMATO) > 0

        _state.value = canMakePizza
    }

}