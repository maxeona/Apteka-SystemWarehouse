package com.example.Service;

import com.example.DAO.RecipeDao;
import com.example.model.OrderRecipe;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RecipeService {
    @Autowired
    private RecipeDao recipeDao;

    public Optional<OrderRecipe> findById(Long id){
        return recipeDao.findById(id);
    }
    public void delete(OrderRecipe orderRecipe){
        recipeDao.delete(orderRecipe);
    }
    public void save(OrderRecipe orderRecipe){
        recipeDao.save(orderRecipe);
    }
}
