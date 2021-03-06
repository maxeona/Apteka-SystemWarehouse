package com.example.View;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


@Route("")
@CssImport("./styles/shared-styles.css")
public class MainView extends AppLayout {

    public MainView(){
        viewHeader();
        drawerNavigation();
        createHeader();
    }

    private void viewHeader() {
        H1 logo = new H1("Apteka.ru");
        logo.addClassName("logo");

        HorizontalLayout headLayout = new HorizontalLayout(new DrawerToggle(), logo); //navigation slider
        headLayout.addClassName("header");
        headLayout.setWidth("100%");
        headLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(headLayout);
    }


    private void drawerNavigation() {

        RouterLink routerLink1 = new RouterLink("Товар", TableView.class);
        routerLink1.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink routerLink3 = new RouterLink("Аналитика", AnalyticMed.class);
        routerLink3.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink resipe = new RouterLink("Рецепты", RecipeOrderView.class);
        resipe.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink warehouse = new RouterLink("Склад", OrderToTheWarehouse.class);
        warehouse.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(routerLink1, resipe,  warehouse, routerLink3));
    }

    private void createHeader() {

        Anchor logout = new Anchor("logout", "Выйти");

        HorizontalLayout header = new HorizontalLayout(logout);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.STRETCH);
        header.setWidth("100%");
        header.addClassName("header");

        addToNavbar(header);
    }


}
