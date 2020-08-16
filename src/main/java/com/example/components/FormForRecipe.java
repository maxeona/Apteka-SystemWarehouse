package com.example.components;

import com.example.DAO.ComponentImpl;
import com.example.DAO.DirectoryForRecipeDao;
import com.example.DAO.RecipeDao;
import com.example.Service.DirectoryForRecipeService;
import com.example.model.ComponentForRecipes;
import com.example.model.DirectoryForRecipe;
import com.example.model.OrderRecipe;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Calendar;
import java.util.List;

public class FormForRecipe extends FormLayout implements KeyNotifier {

    private final RecipeDao recipeDao;
    private final DirectoryForRecipeDao directoryDao;
    private final ComponentImpl component;
    private OrderRecipe orderRecipe;
    private DirectoryForRecipe directory;
    private DirectoryForRecipeService directoryService;


    TextField index = new TextField("Индекс");
    TextField first_name = new TextField("Имя");
    TextField last_name = new TextField("Фамилия");
    TextField patronymic = new TextField("Отчество");
    TextField email = new TextField("Почта");
    TextField number = new TextField("Телефон");
    Button save = new Button("Заказать");
    Button cancel = new Button("Закрыть");


    HorizontalLayout horizontalLayout = new HorizontalLayout(save,  cancel);
    Binder<OrderRecipe> binder = new Binder<>(OrderRecipe.class);

    Dialog banner = new Dialog();


    private EventForm eventForm;
    public interface EventForm{
        void checkEvent();
    }
    public FormForRecipe(RecipeDao recipeDao, DirectoryForRecipeDao directoryDao, ComponentImpl component){
        this.recipeDao = recipeDao;
        this.directoryDao = directoryDao;
        this.component = component;
        binder.bindInstanceFields(this);
        add(index, first_name, last_name, patronymic, email, number, horizontalLayout);
        banner.add(new Label("Данного рецепта нету в справочнике, попробуйте корректно ввести данные."));
        settingButton();
        setVisible(false);


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
        binder.setBean(orderRecipe);
        setVisible(true);
        index.focus();
    }

    private void settingButton() {
        save.addClickListener(e->checkAndSaveOrder());
        cancel.addClickListener(e->cancelForm());
    }

    private void cancelForm(){
        setVisible(false);
    }
    private void checkAndSaveOrder() {
        try {
            checkNewRecipe();
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    private void checkNewRecipe() {
        if(directoryDao.findByIndex(index.getValue())!=null){
            checkComponent();
            settingDataForNewOrder();
            saveOrder();
        }else{
            banner.open();
        }
    }


    private void checkComponent() {
        List<ComponentForRecipes>listComponent = component.findAllComponent(index.getValue());
        for(ComponentForRecipes componentForRecipes:listComponent){
            if(componentForRecipes.getStatus()==2){
                orderRecipe.setStatus("ожидание");
                break;
            }else if(componentForRecipes.getStatus()!=2){
                continue;
            }
        }
        if(orderRecipe.getStatus()==null){
            orderRecipe.setStatus("изготавливается");
        }
    }

    private void settingDataForNewOrder() {
        orderRecipe.setData_create(Calendar.getInstance().getTime());
        if (orderRecipe.getStatus().equals("изготавливается")){
            Calendar result = Calendar.getInstance();
            int finish = directoryDao.findByIndex(orderRecipe.getIndex()).getTerm_izg();
            result.add(Calendar.DAY_OF_MONTH, finish);
            orderRecipe.setData_done(result.getTime());
        }

    }

    private void saveOrder() {
        recipeDao.save(orderRecipe);
        eventForm.checkEvent();
    }

    public void setEventForm(EventForm eventForm) {
        this.eventForm = eventForm;
    }
}
