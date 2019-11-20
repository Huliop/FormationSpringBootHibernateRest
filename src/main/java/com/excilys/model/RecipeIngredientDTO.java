package com.excilys.model;

public class RecipeIngredientDTO {

	private Integer id;
	private IngredientDTO ingredient;
	private Integer quantity;
	private String unit;

	public RecipeIngredientDTO(Integer id, IngredientDTO ingredientDTO, Integer quantity, String unit) {
		this.id = id;
		this.ingredient = ingredientDTO;
		this.quantity = quantity;
		this.unit = unit;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IngredientDTO getIngredient() {
		return ingredient;
	}

	public void setIngredient(IngredientDTO ingredient) {
		this.ingredient = ingredient;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
