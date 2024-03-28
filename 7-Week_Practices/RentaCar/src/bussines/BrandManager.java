package bussines;

import dao.BrandDao;
import entity.Brand;

import javax.swing.*;
import java.util.ArrayList;

public class BrandManager {
    private BrandDao brandDao;

    public BrandManager() {
        brandDao = new BrandDao();
    }

    public boolean save(Brand brand){
        if(brand.getBrand_id() != 0){ // markanın daha önceden kimliği oluşturulmuşsa hata verir
            JOptionPane.showMessageDialog(null,"Error");
        }
        return brandDao.save(brand);
    }

    public ArrayList<Brand> findAll(){
        return brandDao.findAll();
    }
    public Brand getById(int id){
        return brandDao.getById(id);
    }
    public boolean update(Brand brand){
        if(getById(brand.getBrand_id()) == null){
            JOptionPane.showMessageDialog(null,"Not Found");
        }
        return brandDao.update(brand);
    }
    public boolean deleted(int id){
        if(getById(id) == null){
            JOptionPane.showMessageDialog(null,"Not Found");
            return false;
        }
        return brandDao.deleted(id);
    }

}
