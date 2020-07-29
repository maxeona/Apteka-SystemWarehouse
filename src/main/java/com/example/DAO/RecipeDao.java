package com.example.DAO;

import com.example.model.OrderRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDao extends JpaRepository<OrderRecipe, Long> {
}
