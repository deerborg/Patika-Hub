package bussines;

import doa.BrandDao;
import entity.Brand;

import java.util.ArrayList;

public class BrandManager {
    private BrandDao brandDao;

    public BrandManager() {
        brandDao = new BrandDao();
    }

    public ArrayList<Brand> findAll(){
        return brandDao.findAll();
    }

}
