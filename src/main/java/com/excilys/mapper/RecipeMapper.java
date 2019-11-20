package com.excilys.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.excilys.model.Recipe;
import com.excilys.model.RecipeDTO;
import com.excilys.model.RecipeIngredient;
import com.excilys.model.RecipeIngredientDTO;

@Component
public class RecipeMapper {

	private RecipeIngredientMapper instanceMapper;

	public Recipe fromDTO(RecipeDTO recipeDTO) {
		return new Recipe(recipeDTO.getId(), recipeDTO.getName(), recipeDTO.getPicture(), recipeDTO.getDescription(),
				setFromDto(recipeDTO.getIngredients()), recipeDTO.getInstructions());
	}

	public RecipeDTO toDTO(Recipe recipe) {
		return new RecipeDTO(recipe.getId(), recipe.getName(), recipe.getPicture(), recipe.getDescription(),
				setToDto(recipe.getIngredients()), recipe.getInstructions());
	}

	public Set<RecipeIngredient> setFromDto(Set<RecipeIngredientDTO> set) {
		Set<RecipeIngredient> newSet = new HashSet<>();

		for (RecipeIngredientDTO ri : set) {
			newSet.add(instanceMapper.fromDTO(ri));
		}

		return newSet;
	}

	public Set<RecipeIngredientDTO> setToDto(Set<RecipeIngredient> set) {
		Set<RecipeIngredientDTO> newSet = new HashSet<>();

		for (RecipeIngredient ri : set) {
			newSet.add(instanceMapper.toDTO(ri));
		}

		return newSet;
	}

}
