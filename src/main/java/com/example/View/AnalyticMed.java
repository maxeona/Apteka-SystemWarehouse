package com.example.View;

import com.example.Service.MedicineService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "analytic", layout = MainView.class)
public class AnalyticMed extends VerticalLayout {

    private final MedicineService medicineService;

    public AnalyticMed(MedicineService medicineService){
        this.medicineService = medicineService;

    }
}
