package com.example.components;

import com.example.DAO.MedicineDao;
import com.example.configuration.CheckInBasket;
import com.example.model.Medicine;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class FormForMedicine extends VerticalLayout implements KeyNotifier {
//класс издатель

    @Autowired
    private  MedicineDao medicineDao;

    private Medicine medicine;
    @Autowired
    private CheckInBasket checkInBasket;

    private TextField name = new TextField("Компонент");
    private NumberField countBuy = new NumberField("Количество");
    private NumberField newPrice = new NumberField("Итого");

    private Button buy = new Button("Продать", VaadinIcon.CHECK.create());
    private Button util = new Button("Утилизировать");
    private Button close = new Button("Закрыть");
    private Button save = new Button("Заказать");

    private  Dialog banner = new Dialog();

    Binder<Medicine> binder = new Binder<>(Medicine.class);

    private ChangeHandler changeHandler;

    public interface ChangeHandler {
        void onChange();
    }

    public FormForMedicine(){
        addClassName("medicine-form");
        binder.bindInstanceFields(this);
        add(
                name,
                countBuy,
                newPrice,
                buttonLayout());
        settingButton();
        settingBanner();
        setVisible(false);
    }
    public final void editMedicine(Medicine newMedicine) {
        if(newMedicine ==null)
        {
            setVisible(false);
            return;
        }
        if(newMedicine.getId()!=null)
        {
            this.medicine = medicineDao.findById(newMedicine.getId()).orElse(newMedicine);
        }else{
            this.medicine = newMedicine;
        }
        binder.setBean(medicine);
        setVisible(true);
        name.focus();
    }

    private void summaPrice() {
        int price = (int) (medicine.getPrice()*this.countBuy.getValue());
        newPrice.setValue((double) price);
    }

    private void buyMedicine() {
        if(medicine.getQuantity() > 0
                && medicine.getQuantity() >= countBuy.getValue()){
            countBuy();
            setStatusMedicine();
            saveMedicine();
        }else if(medicine.getQuantity() == 0){
            setVisible(false);
        }
        binder.setBean(medicine);
        changeHandler.onChange();
    }

    private void countBuy() {
        int result = (int) (medicine.getQuantity() - countBuy.getValue());
        medicine.setQuantity(result);
    }
    private void setStatusMedicine() {
        if(medicine.getQuantity()==0){
            medicine.setStatus("отсутствует");
        }else if (medicine.getQuantity()>0){
            medicine.setStatus("в наличии");
        }
    }

    private void saveMedicine() {
        medicineDao.save(medicine);
    }

    private void settingBanner() {
        banner.add(new Label("Товар утилизирован в корзину"));
    }

    private void utilMedicine() {
        medicineDao.delete(medicine);
        changeHandler.onChange();
    }

    private Component buttonLayout() {
        buy.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        util.addThemeVariants(ButtonVariant.LUMO_ERROR);
        buy.addClickShortcut(Key.ENTER);
        close.addClickListener(e->closeEditorMedicine());

        return new HorizontalLayout(buy, util, save, close);
    }

    private void settingButton() {
        newPrice.setValueChangeMode(ValueChangeMode.EAGER);
        newPrice.addValueChangeListener(e ->summaPrice());

        buy.addClickListener(e -> buyMedicine());
        util.addClickListener(e -> {
            banner.open();
            utilMedicine();});
        save.addClickListener(e->{

        });


    }
    private void closeEditorMedicine() {
        setVisible(false);
    }

    public void setChangeHandler(ChangeHandler h) {
        changeHandler = h;
    }


}
