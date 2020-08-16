package com.example.DAO;

import com.example.model.ComponentForRecipes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComponentImpl extends JpaRepository<ComponentForRecipes, Long> {

    @Query(
            value="select component from ComponentForRecipes as component, DirectoryForRecipe as directory" +
                    " where component.recipe_id=directory.id_sprav " +
                    "and directory.index= :index")
    List<ComponentForRecipes>findAllComponent(@Param("index") String index);

    @Query(value = "select component from ComponentForRecipes as component, BasketComponent as basket where component.id=basket.components_id")
    List<ComponentForRecipes>findComponent();

    ComponentForRecipes findByName(String name);



}
