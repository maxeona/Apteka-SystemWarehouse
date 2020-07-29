package com.example.View;

import com.example.DAO.MedicineDao;
import com.example.Service.MedicineServiceImpl;
import com.example.components.FormForMedicine;
import com.example.model.Medicine;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.util.StringUtils;



@Route(value = "table", layout = MainView.class)
@PageTitle("Table | Medicine")
//@CssImport("./styles/shared-styles.css")
public class TableView extends VerticalLayout
{
    private final MedicineServiceImpl medicineService;
    private final FormForMedicine formForMedicine;
    private final MedicineDao medicineDao;


    Grid<Medicine>table = new Grid<>(Medicine.class);
    TextField filterName = new TextField();
    Button newMedicine = new Button("Заказать");
    HorizontalLayout layoutButton = new HorizontalLayout(newMedicine);


    public TableView(MedicineServiceImpl medicineService, MedicineDao medicineDao){

        this.medicineService = medicineService;
        this.medicineDao = medicineDao;
        addClassName("table-view");
        setSizeFull();
        viewGrid();
        settingFilter();

        getList();

        formForMedicine = new FormForMedicine(medicineDao);


        Div style = new Div( );
        style.addClassName("styleForm");
        style.setSizeFull();

        add(filterName, layoutButton,  table, formForMedicine);


        table.asSingleSelect().addValueChangeListener(e -> {
            formForMedicine.editMedicine(e.getValue());
        });

        formForMedicine.setChangeHandler(()->{
            formForMedicine.setVisible(false);
            listMedicine(filterName.getValue());
        });
        newMedicine.addClickListener(e->formForMedicine.editMedicine(new Medicine()));

        listMedicine(null);
    }

    private void listMedicine(String value) {
        if(StringUtils.isEmpty(value)){
            table.setItems(medicineDao.findAll());
        }else{
            table.setItems(medicineDao.findByName(value));
        }
    }


    private void settingFilter() {
        filterName.setValueChangeMode(ValueChangeMode.EAGER);
        filterName.addValueChangeListener(a ->findName(a.getValue()));
        filterName.setPlaceholder("Введите название...");
        filterName.setClearButtonVisible(true);
        findName("");
    }

    private void findName(String name) {
        if(name == null||name.isEmpty()){
            table.setItems(this.medicineService.findAll());
        }else{
            table.setItems(this.medicineDao.findByName(name));
        }
    }

    private void getList() {
        table.setItems(medicineService.findAll());
    }

    private void viewGrid() {
        addClassName("table-grid");
        table.setColumns("id", "name", "price", "quantity", "type","application","data_start","data_finish","manufacturer", "status");
        table.getColumns().forEach(columns-> columns.setAutoWidth(true));
    }


}