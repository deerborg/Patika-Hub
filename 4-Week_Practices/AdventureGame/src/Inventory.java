public abstract   class  Inventory {

    private String itemName;
    private int itemPrice;
    private int itemValue;
    private int weaponDamageorHealth;

    public Inventory(String itemName, int itemPrice, int itemValue, int weaponDamage) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemValue = itemValue;
        this.weaponDamageorHealth = weaponDamage;
    }

    public int getWeaponDamageorHealth() {
        return weaponDamageorHealth;
    }

    public void setWeaponDamageorHealth(int weaponDamageorHealth) {
        this.weaponDamageorHealth = weaponDamageorHealth;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }
}
