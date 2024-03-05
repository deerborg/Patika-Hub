import java.util.Random;
import java.util.Scanner;

public class AllMechanic {
    Location location;
    Inventory items;
    private int health;
    private int damage;
    private int money;
    private String race;
    private String playerName;
    private int userChoice;
    private int enemyHealth;
    private int winCounter = 0;
    private int awardValue;


    Scanner value = new Scanner(System.in);
    Random random = new Random();

    public AllMechanic(String playerName) {
        this.playerName = playerName;
    }

    public AllMechanic() {

    }


    public void choiceRace() {
        Elf elf = new Elf();
        Human human = new Human();
        Orc orc = new Orc();
        System.out.println("Elf : Hem büyü hem okçu yetenekleri gelişmiş doğa üstü canlılardır");
        System.out.println("Human : Zeki, bencil ve eğitim yönelimine göre yeteneklerini geliştirir. Tek elli ve çift elli silahlarda yeteneklidir, büyü hasarı veremez");
        System.out.println("Orc : Ticari zekaları gelişmiştir, kısa ve tek elli silaharlarda ve hafif büyü saldılarında yeteneklidir, dövüş yetenekleri kısıtlıdır ama parayı nasıl kazanacaklarını bilirler.");
        System.out.println(" 1 - Elf \n 2 - Human \n 3 - Orc");

        while (true) {
            userChoice = value.nextInt();
            if (userChoice == 1) {
                racesInfo(new Elf());
                this.health = elf.getHealth();
                this.money = elf.getMoney();
                this.damage = elf.getDamage();
                this.race = elf.getRaceName();
                break;
            }
            if (userChoice == 2) {
                racesInfo(new Human());
                this.health = human.getHealth();
                this.money = human.getMoney();
                this.damage = human.getDamage();
                this.race = human.getRaceName();
                break;
            }
            if (userChoice == 3) {
                racesInfo(new Orc());
                this.health = orc.getHealth();
                this.money = orc.getMoney();
                this.damage = orc.getDamage();
                this.race = orc.getRaceName();
                break;
            }
            if (userChoice < 0 || userChoice > 3) {
                System.out.println("Sadece 3 ırk mevcut");
                continue;
            }
        }

    }

    public void racesInfo(RaceSkills select) {
        System.out.println("Irk : " + select.getRaceName());
        System.out.println("Hasar : " + select.getDamage());
        System.out.println("Büyü Hasarı : " + select.getMagicDamage());
        System.out.println("Başlangıç altını: " + select.getMoney());
        System.out.println("Sağlık : " + select.getHealth());
        System.out.println("Silah : " + select.getWeapon());
    }

    public void market() {
        Meat meat = new Meat();
        Bread bread = new Bread();
        Sword sword = new Sword();
        Knife knife = new Knife();
        HeavyArmor hArmor = new HeavyArmor();
        LightArmor lArmor = new LightArmor();
        System.out.println("Tezgah ");
        while (true) {
            System.out.println("1 - Yemekler \t 2 - Silahlar \t 3 - Zırhlar \t 4 - Ayrıl");
            userChoice = value.nextInt();
            if (userChoice == 1) {
                System.out.println("1 - Ekmek \t 2 - Kırmızı Et");
                userChoice = value.nextInt();
                if (userChoice == 1) {
                    if (money < bread.getItemPrice()) {
                        System.out.println("SEFİL DURUMDASIN");
                        break;
                    }
                    itemInfo(new Bread());
                    this.money -= bread.getItemPrice();
                    health += bread.getWeaponDamageorHealth();
                    System.out.println("Sağlığın arttı : " + health);
                    System.out.println("Kalan kuruşların " + this.money);
                    break;
                }
                if (userChoice == 2) {
                    if (money < meat.getItemPrice()) {
                        System.out.println("SEFİL DURUMDASIN");
                        break;
                    } else {
                        itemInfo(new Meat());
                        this.money -= meat.getItemPrice();
                        health += meat.getWeaponDamageorHealth();
                        System.out.println("Sağlığın arttı : " + health);
                        System.out.println("Kalan kuruşların : " + this.money);
                        break;
                    }
                }
            }
            if (userChoice == 2) {
                System.out.println("1 - Kaliteli silah(yay,kılıç)\t2 - Talim Silahları(yay,kılıç)");
                userChoice = value.nextInt();
                if (userChoice == 1) {
                    if (money < sword.getItemPrice()) {
                        System.out.println("SEFİL DURUMDASIN");
                        break;
                    }
                    itemInfo(new Sword());
                    this.money -= sword.getItemPrice();
                    System.out.println("Zengin züppe!");
                    damage += sword.getWeaponDamageorHealth();
                    System.out.println("Hasarın arttı : " + damage);
                    break;
                }
                if (userChoice == 2) {
                    if (money < knife.getItemPrice()) {
                        System.out.println("SEFİL DURUMDASIN");
                        break;
                    }
                    itemInfo(new Knife());
                    money -= knife.getItemPrice();
                    System.out.println("Bununla kulağımı karıştırırım!");
                    damage += knife.getWeaponDamageorHealth();
                    System.out.println("Hasarın çıtır arttı : " + damage);
                    break;
                }
            }
            if (userChoice == 3) {
                System.out.println("1 - Çelik Parlak Göz Alıcı Harika Zırh \t 2 - LCW kazak");
                userChoice = value.nextInt();
                if (userChoice == 1) {
                    if (money < hArmor.getItemPrice()) {
                        System.out.println("SEFİL DURUMDASIN");
                        break;
                    }
                    itemInfo(new HeavyArmor());
                    money -= hArmor.getItemPrice();
                    System.out.println("Bu ay zekatını verdin mi");
                    health += hArmor.getWeaponDamageorHealth();
                    System.out.println("Dayanıklılığın arttı : " + health);
                    break;
                }
                if (userChoice == 2) {
                    if (money < lArmor.getItemPrice()) {
                        System.out.println("SEFİL DURUMDASIN");
                    }
                    itemInfo(new LightArmor());
                    money -= lArmor.getItemPrice();
                    System.out.println("Bi peçete için fazla pahalı!");
                    health += lArmor.getWeaponDamageorHealth();
                    System.out.println("Dayanıklılığın arttı : " + health);
                    break;
                }
            }
            if(userChoice == 4){
                System.out.println("TEK YİYEN TEK ÖLÜR!");
                break;
            }
            if (userChoice < 0 || userChoice > 4) {
                System.out.println("AVM de değilsin");
                continue;
            }
        }
    }

    public void choiceLocation(){
        RuinPalace ruin = new RuinPalace();
        River river = new River();
        Cave cave = new Cave();
        System.out.println("1 - Mağaralara\t2 - Issız Nehir\t 3 - Terkedilmiş Malikane");
        userChoice = value.nextInt();
        while (true){
            if(userChoice == 1){
                System.out.println("CESURSUN, mağaralara doğru yola çıktın...");
                System.out.println("Puslu,soğuk ve karanlık!");
                System.out.println("Canın : " + health);
                System.out.println("Gücün : " + damage);
                System.out.println("Mağaranın girişine geldin... İçeri girecek misin? 1 - Evet 2 - Korkak!");
                userChoice = value.nextInt();
                if(userChoice == 1){
                    System.out.println("Mağaradan abuk subuk sesler geliyor!");
                    System.out.println("Yaratık Adı : " + cave.getMonster());
                    System.out.println("Yaratık gücü: " + cave.getEnemyDamage());
                    System.out.println("Yaratık Canı : " + cave.getEnemyHealth());
                    enemyHealth = cave.getEnemyHealth();
                    System.out.println(cave.getMonster() + " Sana doğru hızlıca geliyor...!!!:!:!:!:!:!");
                    System.out.println("Vuruşuyonuz");
                    while (true){
                        System.out.println("Yaratık sağlam yapıştırdı");
                        health -= cave.getEnemyDamage();
                        System.out.println("Canın : " + health + " Yediğin hasar: " + cave.getEnemyDamage());
                        System.out.println("Bi tanade sen koydun");
                        enemyHealth -= damage;
                        System.out.println("Koyduğun hasar: " + damage);
                        System.out.println("Yaratığın kalan canı " + enemyHealth);
                        if(health < 0 && health < enemyHealth){
                            System.out.println("GEBERDİN, OYUN BİTTİ");
                            winCounter = 0;
                            break;
                        }
                        if(enemyHealth < 0 && enemyHealth < health){
                            System.out.println("ASLAN ASLAN!! AL BUNLAR GANNİMETİN");
                            System.out.println("Aldın bişeyler");
                            this.awardValue += cave.getAward();
                            money += 200;
                            winCounter++;
                            System.out.println("Kapma doğru yola çıkıyorsun...");
                            break;
                        }
                        if(winCounter < 0){
                            System.out.println("Dandik kral koşarak sana sarılıyor");
                            System.out.println("Helal kocum, gec yat dinlen biraz");
                            health+=50;
                            System.out.println("Dinleniyorsun... Sağlığın arttı" + health);
                            break;
                        }

                    }

                }

            }
            if(userChoice == 2){
                System.out.println("Hava kapalı ve heryer pis kokuyor");
                System.out.println("Canın : " + health);
                System.out.println("Gücün : " + damage);
                System.out.println("Nehirin kıyısını kontrol ediyorsun..");
                System.out.println("Kokunun kaynağına bakacak mısın? 1 - Evet , 2 - Korkak! ");
                userChoice = value.nextInt();
                if(userChoice == 1){
                    System.out.println("Yürüyen cesetler!!!!");
                    System.out.println("Yaratık Adı : " + river.getMonster());
                    System.out.println("Yaratık gücü: " + river.getEnemyDamage());
                    System.out.println("Yaratık Canı : " + river.getEnemyHealth());
                    enemyHealth = river.getEnemyHealth();
                    System.out.println(cave.getMonster() + " Sana doğru hızlıca geliyor...!!!:!:!:!:!:!");
                    System.out.println("Vuruşuyonuz");
                    while (true){
                        System.out.println("Yaratık sağlam yapıştırdı");
                        health -= river.getEnemyDamage();
                        System.out.println("Canın : " + health + " Yediğin hasar: " + river.getEnemyDamage());
                        System.out.println("Bi tanade sen koydun");
                        enemyHealth -= damage;
                        System.out.println("Koyduğun hasar: " + damage);
                        System.out.println("Yaratığın kalan canı " + enemyHealth);
                        if(health < 0 && health < enemyHealth){
                            System.out.println("GEBERDİN, OYUN BİTTİ");
                            winCounter = 0;
                            break;
                        }
                        if(enemyHealth < 0 && enemyHealth < health){
                            System.out.println("ASLAN ASLAN!! AL BUNLAR GANNİMETİN");
                            System.out.println("Aldın bişeyler");
                            this.awardValue += river.getAward();
                            money += 200;
                            winCounter++;
                            System.out.println("Kapma doğru yola çıkıyorsun...");
                            break;
                        }
                        if(winCounter < 0){
                            System.out.println("Dandik kral koşarak sana sarılıyor");
                            System.out.println("Helal kocum, gec yat dinlen biraz");
                            health+=50;
                            System.out.println("Dinleniyorsun... Sağlığın arttı" + health);
                            break;
                        }

                    }

                }

            }
            if(userChoice == 3){
                System.out.println("Yıkı dökük ama güzel bir yere benziyor");
                System.out.println("Canın : " + health);
                System.out.println("Gücün : " + damage);
                System.out.println("Keskin vızıltılar duyuyorsun");
                System.out.println("Sesin kaynağına bakacak mısın? 1 - Evet , 2 - Korkak! ");
                userChoice = value.nextInt();
                if(userChoice == 1){
                    System.out.println("Kan sinekleriii!!!");
                    System.out.println("Yaratık Adı : " + ruin.getMonster());
                    System.out.println("Yaratık gücü: " + ruin.getEnemyDamage());
                    System.out.println("Yaratık Canı : " + ruin.getEnemyHealth());
                    enemyHealth = ruin.getEnemyHealth();
                    System.out.println(cave.getMonster() + " Sana doğru hızlıca geliyor...!!!:!:!:!:!:!");
                    System.out.println("Vuruşuyonuz");
                    while (true){
                        System.out.println("Yaratık sağlam yapıştırdı");
                        health -= ruin.getEnemyDamage();
                        System.out.println("Canın : " + health + " Yediğin hasar: " + ruin.getEnemyDamage());
                        System.out.println("Bi tanade sen koydun");
                        enemyHealth -= damage;
                        System.out.println("Koyduğun hasar: " + damage);
                        System.out.println("Yaratığın kalan canı " + enemyHealth);
                        if(health < 0 && health < enemyHealth){
                            System.out.println("GEBERDİN, OYUN BİTTİ");
                            winCounter = 0;
                            break;
                        }
                        if(enemyHealth < 0 && enemyHealth < health){
                            System.out.println("ASLAN ASLAN!! AL BUNLAR GANNİMETİN");
                            System.out.println("Aldın bişeyler");
                            this.awardValue += ruin.getAward();
                            money += 200;
                            winCounter++;
                            System.out.println("Kapma doğru yola çıkıyorsun...");
                            break;
                        }
                        if(winCounter < 0){
                            System.out.println("Dandik kral koşarak sana sarılıyor");
                            System.out.println("Helal kocum, gec yat dinlen biraz");
                            health+=50;
                            System.out.println("Dinleniyorsun... Sağlığın arttı" + health);
                            break;
                        }

                    }

                }
            }
            break;
        }
    }


    public void itemInfo(Inventory items) {
        items.getItemPrice();
        items.getItemName();
        items.getItemValue();
        items.getWeaponDamageorHealth();
    }

    public int getHealth() {
        return health;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Inventory getItems() {
        return items;
    }

    public void setItems(Inventory items) {
        this.items = items;
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public void setWinCounter(int winCounter) {
        this.winCounter = winCounter;
    }

    public int getAwardValue() {
        return awardValue;
    }

    public void setAwardValue(int awardValue) {
        this.awardValue = awardValue;
    }

    public Scanner getValue() {
        return value;
    }

    public void setValue(Scanner value) {
        this.value = value;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


}
