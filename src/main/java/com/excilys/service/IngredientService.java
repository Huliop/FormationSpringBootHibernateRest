package com.excilys.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excilys.mapper.IngredientMapper;
import com.excilys.model.Ingredient;
import com.excilys.model.IngredientDTO;
import com.excilys.persistence.IngredientDAO;

@Service
public class IngredientService {

	private final IngredientDAO instanceDAO;
	private final IngredientMapper instanceMapper;

	@Autowired
	public IngredientService(IngredientDAO ingredientDAO, IngredientMapper ingredientMapper) {
		this.instanceDAO = ingredientDAO;
		this.instanceMapper = ingredientMapper;
	}

	@Transactional
	public List<IngredientDTO> getAll() {

		List<Ingredient> list = instanceDAO.getAll();
		List<IngredientDTO> result = new ArrayList<IngredientDTO>();

		for (Ingredient i : list) {
			result.add(instanceMapper.toDTO(i));
		}

		return result;
	}

	@Transactional
	public IngredientDTO getById(Integer id) {
		return instanceMapper.toDTO(instanceDAO.getById(id));
	}

	@Transactional
	public void create(String name) {
		instanceDAO.create(new Ingredient(name));
	}

	@Transactional
	public void update(IngredientDTO ingredientDTO) {
		instanceDAO.update(instanceMapper.fromDTO(ingredientDTO));
	}

	@Transactional
	public void delete(IngredientDTO ingredientDTO) {
		instanceDAO.delete(instanceMapper.fromDTO(ingredientDTO));
	}

	@Transactional
	public void deleteById(Integer id) {
		instanceDAO.deleteById(id);
	}

}
