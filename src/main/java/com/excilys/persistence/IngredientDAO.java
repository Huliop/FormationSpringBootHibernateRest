package com.excilys.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excilys.model.Ingredient;

@Repository
public class IngredientDAO {

	private static final String SELECT_ALL = "from Ingredient";
	private static final String SELECT_BY_ID = "from Ingredient where ingredient_id = ?0";

	@PersistenceContext
	private final EntityManager entityManager;

	@Autowired
	public IngredientDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Ingredient> getAll() {
		Session session = entityManager.unwrap(Session.class);

		return session.createQuery(SELECT_ALL, Ingredient.class).getResultList();
	}

	public Ingredient getById(Integer id) {
		Session session = entityManager.unwrap(Session.class);

		return session.createQuery(SELECT_BY_ID, Ingredient.class).setParameter(0, id).getSingleResult();
	}

	public void create(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);

		session.save(ingredient);
	}

	public void update(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);

		session.update(ingredient);
	}

	public void delete(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);

		Ingredient persistentIngredient = getById(ingredient.getId());
		session.delete(persistentIngredient);
	}

	public void deleteById(Integer id) {
		Session session = entityManager.unwrap(Session.class);

		session.delete(getById(id));
	}
}
