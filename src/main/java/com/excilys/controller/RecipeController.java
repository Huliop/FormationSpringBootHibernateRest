package com.excilys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.model.RecipeDTO;
import com.excilys.service.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	
	private final RecipeService instanceService;
	
	@Autowired
	public RecipeController(RecipeService ingredientService) {
		this.instanceService = ingredientService;
	}
	
	@GetMapping
	public List<RecipeDTO> getAll() {
		return instanceService.getAll();
	}
	
	@GetMapping("/{id}")
	public RecipeDTO getById(@PathVariable("id") Integer id) {
		return instanceService.getById(id);
	}
	
	@PostMapping
	public void create(@RequestBody RecipeDTO recipeDTO) {
		instanceService.create(recipeDTO);
	}
	
	@PutMapping
	public void update(@RequestBody RecipeDTO recipeDTO) {
		instanceService.update(recipeDTO);
	}
	
	@DeleteMapping
	public void delete(@RequestBody RecipeDTO recipeDTO) {
		instanceService.delete(recipeDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		instanceService.deleteById(id);
	}
}
