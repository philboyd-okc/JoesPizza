package com.example.joespizza.domain

import com.example.joespizza.data.Ingredient
import com.example.joespizza.data.IngredientRepository

class DoughRecipeUseCase(
    private val ingredientRepository: IngredientRepository
) {

    fun canMake(): Boolean {
        return ingredientRepository.getIngredientQuantity(Ingredient.FLOUR) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.WATER) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.YEAST) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.SALT) > 0
    }
}