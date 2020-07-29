package com.example.components;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class OrderToWarehouse extends VerticalLayout {
    public OrderToWarehouse(){
        H1 word = new H1("Проба");
        add(word);
    }
}
