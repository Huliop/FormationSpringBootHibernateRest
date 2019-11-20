package com.excilys.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "picture")
	private String picture;

	@Column(name = "description")
	private String description;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<RecipeIngredient> ingredients = new HashSet<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "instructions")
	private Set<String> instructions = new HashSet<>();

	public Recipe(Integer id, String name, String picture, String description, Set<RecipeIngredient> ingredients,
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<RecipeIngredient> ingredients) {
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
		return "Recipe [id=" + id + ", name=" + name + ", picture=" + picture + ", description=" + description
				+ ", ingredients=" + ingredients + ", instructions=" + instructions + "]";
	}
}
