package com.example.DAO;

import com.example.model.BasketComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BasketDao extends JpaRepository<BasketComponent, Integer> {



}
