package entity;

public class Car {
    private int car_id;
    private int car_model_id;
    private Car.Color car_color;
    private int car_km;
    private String car_plate;
    private Model model;
    private Brand brand;

    public enum Color{
        WHITE,
        BLACK,
        RED,
        BLUE
    }


    public Car() {

    }


    @Override
    public String toString() {
        return STR."Car{car_id=\{car_id}, car_model_id=\{car_model_id}, car_color='\{car_color}\{'\''}, car_km=\{car_km}, car_plate='\{car_plate}\{'\''}, model=\{model}\{'}'}";
    }

    public Color getCar_color() {
        return car_color;
    }

    public void setCar_color(Color car_color) {
        this.car_color = car_color;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getCar_model_id() {
        return car_model_id;
    }

    public void setCar_model_id(int car_model_id) {
        this.car_model_id = car_model_id;
    }
    public int getCar_km() {
        return car_km;
    }

    public void setCar_km(int car_km) {
        this.car_km = car_km;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
