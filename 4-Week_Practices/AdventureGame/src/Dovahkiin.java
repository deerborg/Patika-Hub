import java.util.Scanner;

/**
 * @author Furkan Aydemir, deerborg
 * @since 2024
 */

/*
    Skyrimden benzer diyolaglar alarak yazılmıştır, birebir hali değildir. Çok uzun o hali.
 */


public class Dovahkiin {
    RaceSkills races;
    Elf elf;
    Orc orc;
    Human human;
    AllMechanic mechanic;
    Inventory item;
    private Scanner value = new Scanner(System.in);


    public void goToNewWorld() {
        startIntro();
        System.out.println();
        bracket();
        System.out.println("Karakter bir at arabasının içinde elleri kelepçeli şekilde yavaşça gözlerini açar");
        System.out.println("===========================================");
        shortDelay();
        welcomeDovahkiin();
        longDelay();
        System.out.print("Karaktere korkuyla bakarak: Peki sen kimsin? ");
        System.out.println();
        String userName = value.nextLine();
        AllMechanic allMechanic = new AllMechanic(userName);
        System.out.println("O kadar da umrumda değilsin aslında, yolun sonunda hepimizin kellesini vuracaklar " + allMechanic.getPlayerName());
        shortDelay();
        System.out.println("===========================================");
        shortDelay();
        System.out.println("Araç yavaşça askerlerin olduğu ufak bir kasabaya giriş yapmaya başlar...");
        shortDelay();
        System.out.println("Avlu içinde onlarca asker ortada bir kütük ve etrafında kasaba haklı mevcuttur");
        shortDelay();
        System.out.println("Seni ve senin ile birlikte olan diğer suçuları gardiyan sertçe indirir");
        shortDelay();
        System.out.println("Çavuş sırayla herkesin ismini ve suçunu bir liste içinde okuyarak yüzüne karşı kişilerin bağrır");
        shortDelay();
        System.out.println();
        System.out.println("Sıra sana gelir...");
        shortDelay();
        System.out.println("Çavuş: Adın ne! listede göremiyorum!");
        shortDelay();
        System.out.println("Adım " + allMechanic.getPlayerName() + " neden burda olduğumu bilmiyorum");
        shortDelay();
        System.out.println("Çavuş erbaşına bakarak :  Bu serserinin adı ve suçu listede yok, Kimsin sen ne işin var burda");
        shortDelay();
        bracket();
        System.out.println("GÖREV - 1 : KENDİNİ TANIT");
        longDelay();
        System.out.println("Karakterini oluştur: ");
        bracket();
        allMechanic.choiceRace();
        bracket();
        longDelay();
        System.out.println("KALINCA BİR YARATIK SESİ GELİR..");
        System.out.println("Etafa bakınırlar");
        longDelay();
        bracket();
        System.out.println(allMechanic.getPlayerName() + " suçun sadece şuanda bu at arabasında bulunmak, umrumda değil bugün bu işi bitircez");
        bracket();
        longDelay();
        System.out.println("ŞİDDETLİ SES BİR DAHA GELİR");
        shortDelay();
        System.out.println("Etarafa iyice bakarlar");
        shortDelay();
        System.out.println("Kafanı kütüğe yerleştirirler");
        shortDelay();
        System.out.println("EJDERHA GÖZLE GÖRÜLÜR ŞEKİLDE UÇMAKTADIR");
        shortDelay();
        System.out.println("Halk evlerine kaçışır");
        shortDelay();
        bracket();
        System.out.println("Skyrimin giriş kısmını izleyin o anlar yaşanıyor");
        bracket();
        System.out.println("Bir şekilde kurtuldun, bir seçim yapman gerek. Ya devrimci kral ile birlikte yol al yada askerlerle");
        bracket();
        shortDelay();
        int userChoice;

        while (true) {
            System.out.println("1- Kendini kral gibi tanıtan adamın yanında savaş");
            System.out.println("2- Askerler ile omuz omuza vererek  sahte krala karşı savaş");
            userChoice = value.nextInt();
            if (userChoice == 2) {
                System.out.println("Sahte kral öldü. Bu patikanın aşağısında yaşadığım kasaba var önce oraya geçelim üstüne başına bişeyler buluruz hem tanıştırmak istediğim insanlar var");
                System.out.println("GÖREV 1 TAMAMLANDI");
                break;
            }
            if (userChoice == 1) {
                System.out.println("Bu yolda benle ilerleyeceğine emindim, tüm o askerlerli öldürürken ki soğuk kanlılığın beni çok etkiledi. İlerdeki dağda kampımız var oraya geçip seni bi toparlayalım");
                System.out.println("GÖREV 1 TAMAMLANDI");
                break;
            }
            if (userChoice < 1 || userChoice > 2) {
                System.out.println("SADECE 2 SEÇENEK HAKKIN VAR!");
            }
        }
        bracket();
        if (userChoice == 1 || userChoice == 2) {
            if(userChoice == 2){
                System.out.println("MALMISIN LA ADAMLAR KAFANI KESCEKTİ DANDİK KRALLA DEVAM!");
            }
            System.out.println("GÖREV 2 - UYUM SAĞLA");
            longDelay();
            System.out.println("Yamaca doğru abuk subuk bir yere ilerliyorsunuz, hava çok soğuk ve fazlasıyla açsın");
            shortDelay();
            System.out.println("Sağlığın açlık ve soğuktan dolayı azalıyor, canın: " + (allMechanic.getHealth() - 20));
            shortDelay();
            System.out.println("Bakımsız bir mağaraya girdin, ortada dev bir ateş var. Sahte kral sana yaklaştı");
            shortDelay();
            System.out.println("Aramıza hoş geldin yoldaş, bizi şimdilik idare et");
            shortDelay();
            System.out.println("Sana bi ekmek ve yıpranmış bir yün kazak uzattı");
            System.out.println("SEÇİM YAP : \n 1 - Kabul et \n 2 - Red et");
            while (true) {
                userChoice = value.nextInt();
                if (userChoice == 1) {
                    allMechanic.setHealth(allMechanic.getHealth() - 20);
                    System.out.println("Bi süre bu duruma alışacaksın, emin ol demircide daha iyilerini alabilirsin");
                    System.out.println("Sağlığın arttı : " + (allMechanic.getHealth() + 10));
                    System.out.println("TAMAMLANAN GÖREV - UYUM SAĞLA");
                    break;
                }
                if (userChoice == 2) {
                    allMechanic.setHealth(allMechanic.getHealth() - 40);
                    System.out.println("O zaman bi ara demircinin yanına uğra, yoksa açlıktan ve soğuktan gebereceksin");
                    System.out.println("Sağlığın azaldı : " + (allMechanic.getHealth()));
                    System.out.println("TAMAMLANAN GÖREV - UYUM SAĞLA");
                    break;
                } else {
                    System.out.println("Bi seçim yap");
                }
            }
            longDelay();
            System.out.println("GÖREV 3 - YENİ DÜNYA YENİ DÜZEN");
            longDelay();
            System.out.println("Demircinin yanına doğru ilerliyorsun . Gür bıyıklı ve bu soğukta çıplak şekilde duruyor ");
            shortDelay();
            System.out.println("Seni gördü ve pis pis sırıtıyor...");
            shortDelay();
            System.out.println("NE İSTİYORSUN!");
            shortDelay();
            System.out.println("Titrek sesle, elindekilere bakmak istiyorum diye mırıldandın, ezik!");
            shortDelay();
            System.out.println("Demirci tezgahını gösteriyor");
            shortDelay();
            System.out.println("Cebindeki son kuruşların :" + allMechanic.getMoney() + " altın");
            allMechanic.market();
            System.out.println("Tekrardan markete girmek istiyorsan ( 1 ) bas, kuruşarın : " + allMechanic.getMoney());
            userChoice = value.nextInt();
            while (true) {
                if (userChoice == 1) {
                    allMechanic.market();
                    System.out.println("Kalan kuruşların : " + allMechanic.getMoney());
                    shortDelay();
                    System.out.println("TEKRAR GÖZ ATMAK İSTİYORMUSUN! 1-2");
                    if (userChoice == 1) {
                        allMechanic.market();
                        System.out.println("Kalan kuruşların : " + allMechanic.getMoney());
                        shortDelay();
                        System.out.println("DUKKAN KAPANDI!");
                        break;
                    } else {
                        System.out.println("kalan kuruşların " + allMechanic.getMoney());
                        break;
                    }
                } else {
                    System.out.println("BENİ OYALAMA!");
                    break;
                }
            }
            bracket();
            System.out.println("Cebindeki kuruşlar azalıyor yada hiç olmamıştı, at arabasında gözünü açacak kadar çaresizdin, ekibine yardım etki sevsinler, sevsinlerki karnın doysun");
            shortDelay();
            bracket();
            System.out.println("GÖREV 3 - BEN TEK HEPİNİZ");
            shortDelay();
            System.out.println("Kolpa kral yanına geliyor... " + allMechanic.getPlayerName() + " kasabadaki hünerlerini bizim için kullanma vaktin geldi... \n Yoldaşlar, Yamaçtaki mağarada, \n Issız nehirde \n Terkedilmiş malikanede");
            shortDelay();
            System.out.println("Yaratıkların birşeyler sakladığını düşünüyor... Hazır olduğunda bi göz atmanı istiyorum. EMREDİYORUM!");
            shortDelay();
            System.out.println("Önce nereye bakmak istersin ?");
            allMechanic.choiceLocation();
            if(allMechanic.getWinCounter() < 0){
                System.out.println("KAYBETTİN OYUNA TEKRAR BAŞLAMAK İÇİN METOTDU TEKRAR ÇAĞIR");
            }
            if(allMechanic.getWinCounter() > 0){
                shortDelay();
                System.out.println("Özgüvenlisin, kamp içinde saygın arttı, ganimetlerini arkadaşlarınla paylaşıyorsun. Toplam ganimetin" + allMechanic.getMoney());
                shortDelay();
                System.out.println("Demirci sana gene pis pis sırıtıyor, zaten parayı başka harcayacak bir yer yazmadım o yüzden demircinin yanına doğru git..");
                shortDelay();
                allMechanic.market();
                shortDelay();
                System.out.println("Alacağını aldın şimdi git diğer bölgeleri temizle!!");
                while (true){
                    if(allMechanic.getWinCounter() > 0){
                        System.out.println("Demircide parayı ezmek istiyor musun? 1 - Evet  2 - Hayır");
                        userChoice = value.nextInt();
                        if(userChoice == 1){
                            shortDelay();
                            allMechanic.market();
                            shortDelay();
                        }
                        if(userChoice == 2){
                            if (allMechanic.getHealth() < 0){
                                shortDelay();
                                System.out.println("ÇOK YORGUNSUN KIYAMAM, git yiyecek bişeyler al");
                                shortDelay();
                                allMechanic.market();
                                if(allMechanic.getHealth() > 0){
                                    shortDelay();
                                    allMechanic.choiceLocation();
                                }
                            }
                            else {
                                shortDelay();
                                allMechanic.choiceLocation();
                            }
                        }
                    }
                    if(allMechanic.getWinCounter() >= 3){
                        System.out.println("OYUNU KAZANDINIZ TEBRİKLER");
                        break;
                    }
                    if(allMechanic.getWinCounter() < 0){
                        System.out.println("KAYBETTİN");
                        break;
                    }
                }
            }
        }
    }


    public void welcomeDovahkiin() {
        String[] firstChoice = {
                "Hadvar: Hey, nihayet uyanıyorsun. Sınırı geçmeye mi çalışıyordun? Aynı bizim gibi, bu İmparatorluk pususuna düştün ve o hırsız da orada.",
                "Lokir: Amaan, Stormcloak'lar yüzünden işler karıştı. Skyrim, siz gelene kadar keyifliydi. İmparatorluk rahattı. Eğer seni aramazlarsa, o atı çalar, Hammerfell'e gitmiş olurdum bile.",
                "Hadvar: Burada olmamız gerekmiyordu. İmparatorluğun işi bu Stormcloak'lar.",
                "Lokir: Artık hepimiz aynı gemideyiz, hırsız.",
                "Ralof: Hiç susmaz mısın sen it herif!",
                "Hadvar: Bu neden bu kadar sinirli hah?",
                "Lokir: Sus, ulan! Ulfric Stormcloak'la konuşuyorsun, gerçek Yüksek Kral!",
                "Ralof: Ulfric mi? Rüzgar Kuyuları'nın Jarl'ı sen misin? İsyanın liderisin. Ama seni yakaladılarsa... Vay canına, bizi nereye götürecekler acaba?"
        };
        for (int i = 0; i < firstChoice.length; i++) {
            System.out.println(firstChoice[i]);
        }
    }
    // Gerçekçi diyaloglar için, milis süresini 3000 yapın, uzun gelirse 1 çekebilirsiniz
    public void longDelay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Gerçekçi diyaloglar için, milis süresini 2000 yapın, uzun gelirse 1 çekebilirsiniz
    public void shortDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void introDelay(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startIntro(){
        System.out.println("OYUN YÜKLENİYOR");
        shortDelay();
        System.out.print("Bekleyin");
        shortDelay();
        System.out.print(".");
        introDelay();
        System.out.print(".");
        introDelay();
        System.out.print(".");
        introDelay();
        System.out.print(".");
        introDelay();
        System.out.println("METİNLER YÜKLENDİ....");
        introDelay();
        System.out.println("███████╗ █████╗ ██╗  ██╗███████╗██╗   ██╗██████╗  ██╗███╗   ███╗                               ");
        introDelay();
        System.out.println("██╔════╝██╔══██╗██║ ██╔╝██╔════╝╚██╗ ██╔╝██╔══██╗███║████╗ ████║                               ");
        introDelay();
        System.out.println("█████╗  ███████║█████╔╝ █████╗   ╚████╔╝ ██████╔╝╚██║██╔████╔██║                               ");
        introDelay();
        System.out.println("██╔══╝  ██╔══██║██╔═██╗ ██╔══╝    ╚██╔╝  ██╔══██╗ ██║██║╚██╔╝██║                               ");
        introDelay();
        System.out.println("██║     ██║  ██║██║  ██╗███████╗   ██║   ██║  ██║ ██║██║ ╚═╝ ██║                               ");
        introDelay();
        System.out.println("╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═╝╚═╝     ╚═╝                               ");

    }

    public void bracket() {
        System.out.println("===============================");
    }

}
