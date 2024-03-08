import java.util.Arrays;

public class MyList<T> {

    private T[] list;
    private int capacity;
    private int size;

    public MyList(int capacity) {
        this.capacity = capacity;
        this.list = (T[]) new Object[capacity];
        this.size = 0;
    }

    public MyList() {
        this.capacity = 10;
        this.list = (T[]) new Object[capacity];
        this.size = 0;
    }

    // dizideki eleman sayisini verir
    public int size() {
        return size;
    }

    // sınıfa ait diziye eleman eklemek için kullanılmalıdır. Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartır.
    public void add(T data) {
        if (size < capacity) {
            list[size] = data;
            size++;
        } else {
            System.out.println("Kapasite doldu ve 2 katına çıkarılıyor");
            capacity *= 2;
        }
    }

    // verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.
    public T get(int index) {

        for (int i = 0; i < list.length; i++) {
            if (i == index) {
                return list[i];
            }
        }
        return null;
    }

    // verilen indisteki veriyi yenisi ile değiştirme işlemini yapmalıdır. Geçersiz indis girilerse null döndürür.
    public T set(int index, T data) {
        for (int i = 0; i < list.length; i++) {
            return list[index] = data;
        }
        return null;
    }

    // diziyi yazdırır
    public void print() {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) { // eleman silme durumunda son eleman null değer olacağı için, listemizde çıktı alırken null değerleri yazdırmıyoruz
                System.out.print(list[i] + " ");
            }
        }

    }

    public void remove(int index) {
        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        list[list.length - 1] = null;
        size--;
    }

    // Parametrede verilen nesnenin listedeki indeksini verir. Nesne listede yoksa -1 değerini verir.
    public int indexOf(T data) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == data) {
                return i;
            }
        }
        return -1;
    }

    // Belirtilen öğenin listedeki son indeksini söyler. Nesne listede yoksa -1 değerini verir.
    public int lastIndexOf(T data) {
        int count = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == data) {
                count = i;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        for (int i = 0; i < list.length; i++) {
            list[i] = null;
        }
        size--;
        capacity--;
    }
    // Parametrede verilen indeks aralığına ait bir liste döner.
    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            return null;
        }

        MyList<T> subList = new MyList<>();
        for (int i = start; i <= finish; i++) {
            subList.add(list[i]);
        }
        return subList;
    }
    // Parametrede verilen değerin dizide olup olmadığını söyler.
    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(data)) {
                return true;
            }
        }
        return false;
    }
    // Listedeki öğeleri, aynı sırayla bir array haline getirir.
    public T[] toArray() {
        return Arrays.copyOf(list, size);
    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        liste.add(20);
        liste.add(50);
        liste.add(60);
        liste.add(70);

        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));

        // Bulduğu ilk indeksi verir
        System.out.println("Indeks : " + liste.indexOf(20));

        // Bulamazsa -1 döndürür
        System.out.println("Indeks :" + liste.indexOf(100));

        // Bulduğu son indeksi verir
        System.out.println("Indeks : " + liste.lastIndexOf(20));

        // Listeyi Object[] dizisi olarak geri verir.
        Object[] dizi = liste.toArray();
        System.out.println("Object dizisinin ilk elemanı :" + dizi[0]);

        // Liste veri türünde alt bir liste oluşturdu
        MyList<Integer> altListem = liste.subList(0, 3);
        System.out.println(altListem.toString());

        // Değerim listedeki olup olmadığını sorguladı
        System.out.println("Listemde 20 değeri : " + liste.contains(20));
        System.out.println("Listemde 120 değeri : " + liste.contains(120));

        // Listeyi tamamen boşaltır ve varsayılan boyutuna çevirir
        liste.clear();
        System.out.println(liste.toString());
    }


}