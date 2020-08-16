package com.example.configuration;


import com.example.Service.MedicineServiceImpl;
import com.example.components.FormForDetailsAboutRecipe;
import com.example.components.FormForMedicine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherSettingConfig {

    @Bean
    public MedicineServiceImpl getMedicineService(){
        return new MedicineServiceImpl();
    }

    @Bean
    public FormForMedicine getFormForMedicine(){
        return new FormForMedicine();
    }





}
