package com.example.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "warehouse")
public class OrderToTheWarehouse extends VerticalLayout {
    private Button test = new Button("Корзина");
    private Button history = new Button("История заказов");
    HorizontalLayout horizontalLayout = new HorizontalLayout(test, history);

    public OrderToTheWarehouse(){
        add(horizontalLayout);
    }

}
