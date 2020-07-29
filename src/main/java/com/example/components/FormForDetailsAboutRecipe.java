package com.example.components;

import com.example.DAO.RecipeDao;
import com.example.model.ComponentForRecipes;
import com.example.model.DirectoryForRecipe;
import com.example.model.OrderRecipe;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.List;

public class FormForDetailsAboutRecipe extends FormLayout implements KeyNotifier {

    private final RecipeDao recipeDao;
    private OrderRecipe orderRecipe;
    private TextField index = new TextField("Индекс");
    private TextField first_name = new TextField("Имя");
    private TextField last_name = new TextField("Фамилия");
    private TextField patronymic = new TextField("Отчество");
    private TextField email = new TextField("Почта");
    private TextField number = new TextField("Телефон");
    private TextField status = new TextField("Статус изготовления");
    private DatePicker data_start = new DatePicker("Дата заявки");
    private DatePicker data_finish = new DatePicker("Дата готовности");
    private Button update = new Button("Изменить");
    private Button delete = new Button("Удалить");
    private Button close = new Button("Закрыть");
    private Button buyComponent = new Button("Заказать компоненты");
    private HorizontalLayout buttonLayout = new HorizontalLayout(update, delete, buyComponent, close);
    private Binder<OrderRecipe>recipeBinder = new Binder<>(OrderRecipe.class);

    private ChangeEvent changeEvent;

    public interface ChangeEvent {
        void eventOn();
    }

    public void setChangeEvent(ChangeEvent changeEvent) {
        this.changeEvent = changeEvent;
    }

    public FormForDetailsAboutRecipe(RecipeDao recipeDao){
        this.recipeDao = recipeDao;
        addClassName("form-order");
        settingButton();
        settingField();
        add(index, data_start, data_finish, status, first_name, last_name, patronymic, email, number, buttonLayout);
        recipeBinder.bindInstanceFields(this);
        setVisible(false);
        buyComponent.setVisible(false);
    }



    public final void editOrder(OrderRecipe neworderRecipe) {
        if(neworderRecipe ==null)
        {
            setVisible(false);
            return;
        }
        if(neworderRecipe.getId_order()!=null)
        {
            this.orderRecipe = recipeDao.findById(neworderRecipe.getId_order()).orElse(neworderRecipe);
        }else{
            this.orderRecipe = neworderRecipe;
        }
        if(orderRecipe.getStatus().equals("ожидает дополнительных компонентов")){
            openVisibleButton();
        }
        recipeBinder.setBean(orderRecipe);
        setVisible(true);
        index.focus();
    }

    private void utilOrder() {
        recipeDao.delete(orderRecipe);
        changeEvent.eventOn();
    }

    private void cancelForm(){
        setVisible(false);
        changeEvent.eventOn();
    }

    private void saveOrder() {
        recipeDao.save(orderRecipe);
        changeEvent.eventOn();
    }

    private void settingButton() {
        delete.addClickListener(e -> {
            utilOrder();});
        update.addClickListener(e->saveOrder());
        close.addClickListener(e->cancelForm());

    }
    private void settingField() {
        index.setReadOnly(true);
        first_name.setReadOnly(true);
        last_name.setReadOnly(true);
        patronymic.setReadOnly(true);
        status.setReadOnly(true);
        status.setAutoselect(true);
    }
    private void openVisibleButton(){
        buyComponent.setVisible(true);
    }



}
