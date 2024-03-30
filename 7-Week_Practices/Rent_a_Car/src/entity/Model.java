package entity;

public class Model {
    private int model_id;
    private int model_brand_id;
    private String model_name;
    private String model_year;
    private Type type;
    private Gear gear;
    private Fuel fuel;
    private Brand brand;

    public enum Gear{
        AUTO,
        MANUEL
    }
    public enum Type{
        SEDAN,
        SUV,
        HACBACK
    }
    public enum Fuel{
        DIESEL,
        GASOLINE,
        ELECTRIC,
        LPG
    }


    public Model() {
    }

    public Model(int model_id, int model_brand_id, String model_name, String model_year, Type type, Gear gear, Fuel fuel) {
        this.model_id = model_id;
        this.model_brand_id = model_brand_id;
        this.model_name = model_name;
        this.model_year = model_year;
        this.type = type;
        this.gear = gear;
        this.fuel = fuel;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public int getModel_brand_id() {
        return model_brand_id;
    }

    public void setModel_brand_id(int model_brand_id) {
        this.model_brand_id = model_brand_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_year() {
        return model_year;
    }

    public void setModel_year(String model_year) {
        this.model_year = model_year;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
