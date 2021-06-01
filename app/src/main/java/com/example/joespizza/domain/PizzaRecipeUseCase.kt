package com.example.joespizza.domain

import com.example.joespizza.data.Ingredient
import com.example.joespizza.data.IngredientRepository

class PizzaRecipeUseCase(
    private val ingredientRepository: IngredientRepository
) {

    fun canMakePizza(): Boolean {
        return ingredientRepository.getIngredientQuantity(Ingredient.FLOUR) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.WATER) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.YEAST) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.SALT) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.MOZZARELLA) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.BASIL) > 0 &&
                ingredientRepository.getIngredientQuantity(Ingredient.TOMATO) > 0
    }
}