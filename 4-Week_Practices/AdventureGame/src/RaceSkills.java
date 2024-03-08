public abstract class RaceSkills {
    private int ID;
    private String raceName;
    private int damage;
    private int magicDamage;
    private int money;
    private int health;
    private String weapon;



    public RaceSkills(int damage, int magicDamage, int money, int health , String weapon, String raceName, int ID) {
        this.damage = damage;
        this.magicDamage = magicDamage;
        this.money = money;
        this.weapon = weapon;
        this.health = health;
        this.raceName = raceName;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
