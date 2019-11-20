package com.excilys.mapper;

import org.springframework.stereotype.Component;

import com.excilys.model.Ingredient;
import com.excilys.model.IngredientDTO;

@Component
public class IngredientMapper {

	public Ingredient fromDTO(IngredientDTO ingredientDTO) {
		return new Ingredient(ingredientDTO.getId(), ingredientDTO.getName());
	}

	public IngredientDTO toDTO(Ingredient ingredient) {
		return new IngredientDTO(ingredient.getId(), ingredient.getName());
	}
}
