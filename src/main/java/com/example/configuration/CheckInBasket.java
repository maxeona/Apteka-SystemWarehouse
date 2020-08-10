package com.example.configuration;

import com.example.DAO.BasketDao;
import com.example.DAO.ComponentImpl;
import com.example.model.BasketComponent;
import com.example.model.ComponentForRecipes;
import com.example.model.OrderRecipe;
import java.util.List;

public class CheckInBasket {

    private final BasketDao basketDao;
    private final ComponentImpl component;
    private OrderRecipe orderRecipe;
    private ComponentForRecipes componentForRecipes;
    private int counter;

    BasketComponent basketComponent = new BasketComponent();

    public CheckInBasket(BasketDao basketDao, ComponentImpl component) {
        this.basketDao = basketDao;
        this.component = component;
    }

    public void updateTable(OrderRecipe orderRecipe) {
        String result = orderRecipe.getIndex();
        List<ComponentForRecipes> listComponent = component.findAllComponent(result);

        for (ComponentForRecipes componentForRecipes: listComponent) {
                if (componentForRecipes.getStatus() == 2) {
                basketComponent.setPrice(200);
                basketComponent.setCount(1);
                basketComponent.setComponents_id(componentForRecipes.getId());
                basketDao.save(basketComponent);
            }
        }
    }
}

