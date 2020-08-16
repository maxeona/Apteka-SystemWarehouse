package com.example.DAO;

import com.example.model.OrderRecipe;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeDao extends JpaRepository<OrderRecipe, Long> {
}
