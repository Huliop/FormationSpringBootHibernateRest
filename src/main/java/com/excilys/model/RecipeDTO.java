package com.excilys.model;

import java.util.Set;

public class RecipeDTO {

	private Integer id;
	private String name;
	private String description;
	private String picture;
	private Set<RecipeIngredientDTO> ingredients;
	private Set<String> instructions;

	public RecipeDTO(Integer id, String name, String picture, String description, Set<RecipeIngredientDTO> ingredients,
			Set<String> instructions) {
		this.id = id;
		this.name = name;
		this.picture = picture;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Set<RecipeIngredientDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<RecipeIngredientDTO> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(Set<String> instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "RecipeDTO [id=" + id + ", name=" + name + ", description=" + description + ", picture=" + picture
				+ ", ingredients=" + ingredients + ", instructions=" + instructions + "]";
	}

}
