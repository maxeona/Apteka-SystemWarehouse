package com.example.DAO;

import com.example.model.BasketComponent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface BasketDao extends JpaRepository<BasketComponent, Integer> {

}
