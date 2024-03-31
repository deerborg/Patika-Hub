package entity;

public class Brand {
    private int brand_id;
    private String brand_name;

    public Brand() {
    }

    public Brand(int brand_id, String brand_name) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
    }

    public Brand(String brand_name) {
        this.brand_name = brand_name;
    }

    @Override
    public String toString() {
        return STR."BrandDao{brand_id=\{brand_id}, brand_name='\{brand_name}\{'\''}\{'}'}";
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
}
