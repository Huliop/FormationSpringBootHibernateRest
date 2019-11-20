package com.excilys.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excilys.mapper.RecipeMapper;
import com.excilys.model.Recipe;
import com.excilys.model.RecipeDTO;
import com.excilys.persistence.RecipeDAO;

@Service
public class RecipeService {

	private final RecipeDAO instanceDAO;
	private final RecipeMapper instanceMapper;
	
	private static final Logger LOG = LoggerFactory.getLogger(RecipeService.class);

	@Autowired
	public RecipeService(RecipeDAO recipeDAO, RecipeMapper recipeMapper) {
		this.instanceDAO = recipeDAO;
		this.instanceMapper = recipeMapper;
	}

	@Transactional
	public List<RecipeDTO> getAll() {

		List<Recipe> list = instanceDAO.getAll();
		List<RecipeDTO> result = new ArrayList<RecipeDTO>();

		for (Recipe recipe : list) {
			result.add(instanceMapper.toDTO(recipe));
		}

		return result;
	}

	@Transactional
	public RecipeDTO getById(Integer id) {
		return instanceMapper.toDTO(instanceDAO.getById(id));
	}

	@Transactional
	public void create(RecipeDTO recipeDTO) {
		LOG.error(recipeDTO.toString());
		instanceDAO.create(instanceMapper.fromDTO(recipeDTO));
	}

	@Transactional
	public void update(RecipeDTO recipeDTO) {
		instanceDAO.update(instanceMapper.fromDTO(recipeDTO));
	}

	@Transactional
	public void delete(RecipeDTO recipeDTO) {
		instanceDAO.delete(instanceMapper.fromDTO(recipeDTO));
	}

	@Transactional
	public void deleteById(Integer id) {
		instanceDAO.deleteById(id);
	}
}
