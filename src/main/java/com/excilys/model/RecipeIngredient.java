package com.excilys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_ingredient_id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Ingredient ingredient;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "unit")
	private String unit;

	public RecipeIngredient() {
	}
	
	public RecipeIngredient(Integer id, Ingredient ingredient, Integer quantity, String unit) {
		this.id = id;
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.unit = unit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
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

	@Override
	public String toString() {
		return "RecipeIngredient [id=" + id + ", ingredient=" + ingredient + ", quantity=" + quantity + ", unit=" + unit
				+ "]";
	}
}
