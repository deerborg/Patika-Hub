public abstract class Location {

    private String locationName;
    private String monster;
    private int enemyDamage;
    private int enemyHealth;
    private int award;


    public Location(String locationName, String monster, int enemyDamage, int enemyHealth, int award) {
        this.award = award;
        this.locationName = locationName;
        this.monster = monster;
        this.enemyDamage = enemyDamage;
        this.enemyHealth = enemyHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public String getMonster() {
        return monster;
    }

    public void setMonster(String monster) {
        this.monster = monster;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public void setEnemyDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
