package com.example.DAO;

import com.example.model.ComponentForRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ComponentImpl extends JpaRepository<ComponentForRecipes, Long> {

    @Query(
            value="select component from ComponentForRecipes as component, DirectoryForRecipe as directory" +
                    " where component.recipe_id=directory.id_sprav " +
                    "and directory.index= :index")
    List<ComponentForRecipes>findAllComponent(@Param("index") String index);


}
