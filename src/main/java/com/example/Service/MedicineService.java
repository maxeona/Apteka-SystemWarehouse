package com.example.Service;

import com.example.model.Medicine;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicineService {
    List<Medicine>findAll();
    void deleteById(Long id);
    void save(Medicine medicine);


}
