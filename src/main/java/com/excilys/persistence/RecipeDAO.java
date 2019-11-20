package com.excilys.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.model.Recipe;

@Repository
public class RecipeDAO {
	private static final String SELECT_ALL = "from Recipe";
	private static final String SELECT_BY_ID = "from Recipe where recipe_id = ?0";
	//private static final Logger LOG = LoggerFactory.getLogger(Ingredient.class);

	@PersistenceContext
	private final EntityManager entityManager;

	@Autowired
	public RecipeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Recipe> getAll() {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery(SELECT_ALL, Recipe.class).getResultList();
	}

	public Recipe getById(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery(SELECT_BY_ID, Recipe.class).setParameter(0, id).getSingleResult();
	}
	
	public void create(Recipe recipe) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.save(recipe);
	}
	
	public void update(Recipe recipe) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.update(recipe);
	}
	
	public void delete(Recipe recipe) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(recipe);
	}
	
	public void deleteById(Integer id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(getById(id));
	}
	
}
