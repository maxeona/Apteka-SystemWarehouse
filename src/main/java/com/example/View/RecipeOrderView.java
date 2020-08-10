package com.example.View;

import com.example.DAO.BasketDao;
import com.example.DAO.ComponentImpl;
import com.example.DAO.DirectoryForRecipeDao;
import com.example.DAO.RecipeDao;
import com.example.components.FormForDetailsAboutRecipe;
import com.example.components.FormForRecipe;
import com.example.model.OrderRecipe;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "test", layout = MainView.class)
public class RecipeOrderView extends VerticalLayout {
    private final RecipeDao recipeDao;
    private  final DirectoryForRecipeDao directory;
    private final ComponentImpl component;
    private final BasketDao basketDao;



    private Grid<OrderRecipe>orderlist=new Grid<>(OrderRecipe.class);
    private Button newOrder = new Button("Новый заказ");
    private Button journalRecipe = new Button("Журнал рецептов");
    private HorizontalLayout horizontalLayout = new HorizontalLayout(newOrder, journalRecipe);

    private final FormForRecipe testForm;
    private final FormForDetailsAboutRecipe forDetailsAboutRecipe;
    public RecipeOrderView(RecipeDao recipeDao, ComponentImpl component, BasketDao basketDao, DirectoryForRecipeDao directory) {
        this.recipeDao = recipeDao;
        this.component = component;
        this.basketDao = basketDao;
        forDetailsAboutRecipe = new FormForDetailsAboutRecipe(recipeDao, basketDao, component);

        testForm = new FormForRecipe(recipeDao, directory, component);
        this.directory = directory;
        addClassName("table-view");
        setSizeFull();
        viewGrid();

        getList();


        Div style = new Div(orderlist );
        style.addClassName("styleForm");
        style.setSizeFull();

        orderlist.setVisible(false);
        add(horizontalLayout, style, testForm, forDetailsAboutRecipe);
        newOrder.addClickListener(e->testForm.editOrder(new OrderRecipe()));
        journalRecipe.addClickListener(a->openTable());
        orderlist.asSingleSelect().addValueChangeListener(e -> {
            forDetailsAboutRecipe.editOrder(e.getValue());
        });
        forDetailsAboutRecipe.setChangeEvent(()->{
            forDetailsAboutRecipe.setVisible(false);
            listRecipe();
        });
        testForm.setEventForm(()->{
            testForm.setVisible(false);
            listRecipe();
        });
    }

    private void listRecipe() {
        orderlist.setItems(recipeDao.findAll());
    }

    private void openTable() {
        orderlist.setVisible(true);
    }


    private void getList() {
        orderlist.setItems(recipeDao.findAll());
        orderlist.setColumns(
                "index", "first_name", "last_name", "patronymic", "email", "number", "data_create", "data_done", "status");
    }

    private void viewGrid() {
        addClassName("table-grid");
    }

}
