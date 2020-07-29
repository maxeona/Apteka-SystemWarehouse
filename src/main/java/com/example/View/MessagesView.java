package com.example.View;

import com.example.DAO.ComponentImpl;
import com.example.model.ComponentForRecipes;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value="messages", layout = MainView.class)
public class MessagesView extends VerticalLayout {
   private Button newMessage = new Button("Новое сообщение");


    public MessagesView(){
        add(newMessage);
    }

}
