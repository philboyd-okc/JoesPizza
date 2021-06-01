package com.example.joespizza.domain

import com.example.joespizza.data.Ingredient
import com.example.joespizza.data.IngredientRepository

class GarlicBreadRecipeUseCase(
    private val ingredientRepository: IngredientRepository,
    private val doughRecipeUseCase: DoughRecipeUseCase
) {

    fun canMake(): Boolean {
        return doughRecipeUseCase.canMake() &&
                ingredientRepository.getIngredientQuantity(Ingredient.GARLIC) > 0
    }
}