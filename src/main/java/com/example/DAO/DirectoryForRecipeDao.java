package com.example.DAO;

import com.example.model.DirectoryForRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DirectoryForRecipeDao extends JpaRepository<DirectoryForRecipe, Long>{

    @Query("select  b from DirectoryForRecipe b where b.index = :index")
    DirectoryForRecipe findByIndex(@Param("index")String index);
}
