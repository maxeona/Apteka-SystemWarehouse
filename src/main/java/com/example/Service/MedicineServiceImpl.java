package com.example.Service;

import com.example.DAO.MedicineDao;
import com.example.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineDao medicineDao;

    @Autowired
    public MedicineServiceImpl(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }
    @Override
    public List<Medicine> findAll() { return medicineDao.findAll(); }


    @Override
    public void deleteById(Long id) { medicineDao.deleteById(id); }

    @Override
    public void save(Medicine medicine) {

        if(medicine!=null){
            medicineDao.save(medicine);
        }
    }


}
