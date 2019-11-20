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

import com.excilys.model.IngredientDTO;
import com.excilys.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
	
	private final IngredientService instanceService;
	
	@Autowired
	public IngredientController(IngredientService ingredientService) {
		this.instanceService = ingredientService;
	}
	
	@GetMapping
	public List<IngredientDTO> getAll() {
		return instanceService.getAll();
	}
	
	@GetMapping("/{id}")
	public IngredientDTO getById(@PathVariable("id") Integer id) {
		return instanceService.getById(id);
	}
	
	@PostMapping("/create/{name}")
	public void create(@PathVariable("name") String name) {
		instanceService.create(name);
	}
	
	@PutMapping
	public void update(@RequestBody IngredientDTO ingredientDTO) {
		instanceService.update(ingredientDTO);
	}
	
	@DeleteMapping
	public void delete(@RequestBody IngredientDTO ingredientDTO) {
		instanceService.delete(ingredientDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		instanceService.deleteById(id);
	}
}