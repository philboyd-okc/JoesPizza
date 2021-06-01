package com.example.joespizza.domain

import com.example.joespizza.data.Ingredient
import com.example.joespizza.data.IngredientRepository

class PizzaRecipeUseCase(
    private val ingredientRepository: IngredientRepository,
    private val doughRecipeUseCase: DoughRecipeUseCase
) {

    fun canMake(): Boolean {
        return doughRecipeUseCase.canMake() &&
                ingredientRepository.getIngredientQuantity(Ingredient.MOZZARELLA) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.BASIL) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.TOMATO) > 0
    }
}