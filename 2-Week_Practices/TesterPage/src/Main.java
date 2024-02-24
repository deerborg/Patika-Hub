import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

       int b;
       int[] list = {100,150,5,30};
       Arrays.sort(list);
       b = Arrays.binarySearch(list, 5);
       System.out.println(b);
       String a = Arrays.toString(list);
       
       System.out.println(a);
       
       int[] c = Arrays.copyOf(list, 2);
       System.out.println(Arrays.toString(c));
       int[] d = Arrays.copyOfRange(list, 0, 3);
        System.out.println(Arrays.toString(d));
       
       
    }
}
