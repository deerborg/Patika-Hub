package bussines;

import core.Helper;
import dao.BrandDao;
import entity.Brand;
import entity.Model;

import java.util.ArrayList;

public class BrandManager {
    private BrandDao brandDao;
    private ModelManager modelManager;
    public BrandManager() {
        brandDao = new BrandDao();
        modelManager = new ModelManager();
    }

    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> rowList = new ArrayList<>();
        for(Brand brand : findByAll()){ // Tablodaki veriler kadar döner
            Object[] rows = new Object[size];
            int i = 0;
            rows[i++] = brand.getBrand_id(); // Tablo başlığı 1' den başlar
            rows[i++] = brand.getBrand_name();
            rowList.add(rows);
        }
        return rowList;
    }
    public ArrayList<Brand> findByAll(){
        return brandDao.findByAll();
    }
    public boolean save(Brand brand){
        if(brand.getBrand_id() != 0){ // != null , brand_id'lerimiz database içinde kendisi atadıgı icin yeni veri eklendiginde id sütunu null olmalı, eğer null değilse ya eklenmiştir yada biz elle girdiğimiz için hata verecektir
            Helper.msg("Error");
        }
        return brandDao.save(brand);
    }
    public Brand getById(int id){
        return brandDao.getById(id);
    }
    public boolean update(Brand brand){
        if(getById(brand.getBrand_id()) == null){
            Helper.msg("Not found");
        }
        return brandDao.update(brand);
    }
    public boolean delete(int id){
        if(getById(id) == null){ // Tablo içinde eğer böyle bir id sahip satır yoksa
            Helper.msg(STR."Not Found ID : \{id}");
            return false;
        }
        for(Model model : modelManager.getByBrandId(id)){
            modelManager.deleted(model.getModel_id());
        }
        return brandDao.delete(id);
    }
}
