package com.example.DAO;

import com.example.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineDao extends JpaRepository<Medicine, Long> {
    @Query("select a from Medicine a where a.name = :name")
    List<Medicine> findByName(@Param("name") String name);
}
