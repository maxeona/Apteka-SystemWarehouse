package com.example.View;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

import java.util.Collections;

@Route(value = "login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    LoginForm loginForm = new LoginForm();

    public LoginView(){

        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        loginForm.setAction("login");


        add(
                loginForm
        );
    }


    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if(!event.getLocation().
                getQueryParameters().
                getParameters().containsKey("Ошибка")){
            loginForm.setError(true);
        }
    }
}
