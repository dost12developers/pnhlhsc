package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.IngredientDetail;

public interface IngredientDetailDAO {
	IngredientDetail get(int id);
	List<IngredientDetail> list();
	boolean add(IngredientDetail ingredientDetail);
	boolean update(IngredientDetail ingredientDetail);
	boolean delete(IngredientDetail ingredientDetail);
}
