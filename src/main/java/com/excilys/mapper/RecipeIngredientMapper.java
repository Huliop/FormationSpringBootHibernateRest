package com.excilys.mapper;

import org.springframework.stereotype.Component;

import com.excilys.model.RecipeIngredient;
import com.excilys.model.RecipeIngredientDTO;

@Component
public class RecipeIngredientMapper {

	private final IngredientMapper instanceMapperIngredient;

	public RecipeIngredientMapper(IngredientMapper ingredientMapper) {
		this.instanceMapperIngredient = ingredientMapper;
	}

	public RecipeIngredient fromDTO(RecipeIngredientDTO recipeIngredientDTO) {
		return new RecipeIngredient(recipeIngredientDTO.getId(),
				instanceMapperIngredient.fromDTO(recipeIngredientDTO.getIngredient()),
				recipeIngredientDTO.getQuantity(), recipeIngredientDTO.getUnit());
	}

	public RecipeIngredientDTO toDTO(RecipeIngredient recipeIngredient) {
		return new RecipeIngredientDTO(recipeIngredient.getId(),
				instanceMapperIngredient.toDTO(recipeIngredient.getIngredient()), recipeIngredient.getQuantity(),
				recipeIngredient.getUnit());
	}
}
