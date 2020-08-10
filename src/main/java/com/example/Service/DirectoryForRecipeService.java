package com.example.Service;

import com.example.DAO.DirectoryForRecipeDao;
import com.example.model.DirectoryForRecipe;

public class DirectoryForRecipeService {
    private final DirectoryForRecipeDao directoryForRecipeDao;

    public DirectoryForRecipeService(DirectoryForRecipeDao directoryForRecipeDao){

        this.directoryForRecipeDao = directoryForRecipeDao;
    }

    public int getDayForRecipe(String index){
        DirectoryForRecipe directoryForRecipe = directoryForRecipeDao.findByIndex(index);
        int result = directoryForRecipe.getTerm_izg();
        return result;
    }

}
