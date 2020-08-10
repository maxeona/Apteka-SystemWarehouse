package com.example.View;

import com.example.DAO.DirectoryForRecipeDao;
import com.example.DAO.MedicineDao;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.HashMap;
import java.util.Map;

@Route(value = "analytic", layout = MainView.class)
public class AnalyticMed extends VerticalLayout {

    private final MedicineDao medicineDao;
    private final DirectoryForRecipeDao recipeDao;

    public AnalyticMed(MedicineDao medicineDao, DirectoryForRecipeDao recipeDao){

        this.medicineDao = medicineDao;
        this.recipeDao = recipeDao;


        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(
                getMedicineStat(),
                getRecipeStat()
        );
    }

    private Component getRecipeStat() {
        Chart chart = new Chart(ChartType.PIE);
        DataSeries dataSeries = new DataSeries();
        Map<String, Integer>stat = getAllSrar();
        stat.forEach((name, number)->
                dataSeries.add(new DataSeriesItem(name, number))
                );
        chart.getConfiguration().setSeries(dataSeries);
        return chart;
    }

    private Map<String, Integer> getAllSrar() {
        HashMap<String, Integer>stats= new HashMap<>();
        medicineDao.findAll().forEach(medicine->
                stats.put(medicine.getName(), medicine.getQuantity()));

        return stats;
    }

    private Span getMedicineStat() {
        Span stat = new Span("Медикаменты");
        stat.addClassName("medicine-stat");
        return stat;
    }
}
