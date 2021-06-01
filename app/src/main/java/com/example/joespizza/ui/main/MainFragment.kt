package com.example.joespizza.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.map
import com.example.joespizza.R
import com.example.joespizza.data.IngredientDataRepository
import com.example.joespizza.domain.DoughRecipeUseCase
import com.example.joespizza.domain.GarlicBreadRecipeUseCase
import com.example.joespizza.domain.PizzaRecipeUseCase

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.message)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = getViewModel()

        viewModel.state.map { it.canMakePizza }
            .observe(viewLifecycleOwner, Observer(this::bindPizza))
        viewModel.state.map { it.canMakeGarlicBread }
            .observe(viewLifecycleOwner, Observer(this::bindGarlicBread))

    }

    private fun bindPizza(canMakePizza: Boolean) {
        textView.text = if (canMakePizza) "Can Make Pizza" else "Cannot Make Pizza :("
    }

    private fun bindGarlicBread(canMakeGarlicBread: Boolean) {
        // textView.text = if (canMakeGarlicBread) "Can Make Garlic Bread" else "Cannot Make Garlic Bread :("
    }

    private fun getViewModel(): MainViewModel {
        val ingredientRepository = IngredientDataRepository()
        val doughRecipeUseCase = DoughRecipeUseCase(ingredientRepository)

        return MainViewModel(
            PizzaRecipeUseCase(ingredientRepository, doughRecipeUseCase),
            GarlicBreadRecipeUseCase(ingredientRepository, doughRecipeUseCase)
        )
    }

}