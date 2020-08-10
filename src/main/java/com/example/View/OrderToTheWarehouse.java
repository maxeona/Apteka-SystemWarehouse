package com.example.View;

import com.example.DAO.BasketDao;
import com.example.DAO.ComponentImpl;
import com.example.DAO.MedicineDao;
import com.example.configuration.CheckInBasket;
import com.example.model.ComponentForRecipes;
import com.example.model.Medicine;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "warehouse", layout = MainView.class)
public class OrderToTheWarehouse extends VerticalLayout {
    private final ComponentImpl component;
    private final BasketDao basketDao;
    private final MedicineDao medicineDao;
    private  CheckInBasket checkInBasket;
    private Button basketView = new Button("Корзина");
    private Button history = new Button("История заказов");
    private Button orderMedicine = new Button("Заказать");
    private Button close = new Button("Закрыть");
    HorizontalLayout horizontalLayout = new HorizontalLayout(basketView, history);
    Grid<ComponentForRecipes>basketComponent = new Grid<>(ComponentForRecipes.class);
    HorizontalLayout layoutForm = new HorizontalLayout(orderMedicine, close);
    Accordion accordion = new Accordion();
    Grid<Medicine>medicineGrid = new Grid<>(Medicine.class);

    public OrderToTheWarehouse(ComponentImpl component, BasketDao basketDao, MedicineDao medicineDao){
        this.component = component;
        this.basketDao = basketDao;
        this.medicineDao = medicineDao;
        checkInBasket = new CheckInBasket(basketDao, component);
        getAll();
        settingButton();
        accordionSetting();
        add(horizontalLayout,accordion,  layoutForm);
        orderMedicine.setVisible(false);
        close.setVisible(false);
        accordion.setVisible(false);
    }

    private void accordionSetting() {
        accordion.add("Компоненты", basketComponent);
        accordion.setSizeFull();
        accordion.add("Медикаменты", medicineGrid);
        medicineGrid.setColumns("name");
        setWidthFull();
    }

    private void settingButton() {
        basketView.addClickListener(evt->{
            accordion.setVisible(true);
            orderMedicine.setVisible(true);
            close.setVisible(true);
        });
        close.addClickListener(evt->{
           accordion.setVisible(false);
           orderMedicine.setVisible(false);
           close.setVisible(false);
        });
    }

    private void getAll(){
        basketComponent.setItems(component.findComponent());
        basketComponent.setColumns("name");
    }

}
