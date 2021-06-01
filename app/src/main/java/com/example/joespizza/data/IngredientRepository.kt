package com.example.joespizza.data

interface IngredientRepository {
    fun getIngredientQuantity(ingredient: Ingredient): Int
}

class IngredientDataRepository : IngredientRepository {

    private val randomNumbers = (0..10)

    override fun getIngredientQuantity(ingredient: Ingredient): Int {
        return randomNumbers.random()
    }

}
