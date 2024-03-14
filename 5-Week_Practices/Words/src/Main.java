import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countA = 1;
        System.out.print("ENTER WORDS: ");
        String words = scanner.nextLine().toLowerCase();
        String[] dizi = words.split(" ");

        HashMap<String,Integer> map = new HashMap<>();

        Arrays.sort(dizi);

        //  dizi[i] değerini, daha önceden map dizisinde bulunduğuna dair sorgu yapar, ilk sorguda false döndüğü için countA 1 den başlatıp arttırıyoruz
        for (int i = 0; i < dizi.length; i++) {
            if(map.containsKey(dizi[i])){
                map.put(dizi[i],countA);
                countA++;
            }
            else{
                map.put(dizi[i],1);
                countA = 1;
                countA++;
            }
        }

        // Kelimelerin kaçar adet geçtiğini çıktı olarak verir
        for (Map.Entry<String,Integer> ent : map.entrySet()){
            System.out.println("KELİME : " + ent.getKey());
            System.out.println("GEÇTİĞİ ADET : " + ent.getValue());
            System.out.println("----------------------------");
        }



        // En çok geçen cümleyi verir, aynı sayıda olursa en son hangisini görürse onu çıktı olarak gösterir
        int loopWords = 0;
        String loopWord = "";
        for (Map.Entry<String,Integer> ent : map.entrySet()){
            if(ent.getValue() > loopWords){
                loopWord = ent.getKey();
                loopWords = ent.getValue();
            }
        }
        System.out.println("EN COK GECEN GELİME : " + loopWord +"\n" + "ADEDİ : " + loopWords);



    }
}
