package com.example.configuration;

import com.example.DAO.BasketDao;
import com.example.DAO.ComponentImpl;
import com.example.DAO.MedicineDao;
import com.example.model.Medicine;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


//слушатель
@Route(value = "hello")
public class OrderToWarehouse extends FormLayout {

    @Autowired
    private CheckInBasket checkInBasket;
    private final BasketDao basketDao;
    private final ComponentImpl component;
    Grid<Medicine>newList = new Grid<>(Medicine.class);;
    public OrderToWarehouse(MedicineDao medicineDao, BasketDao basketDao, ComponentImpl component){
        this.basketDao = basketDao;
        this.component = component;
        add(newList);
    }



}
