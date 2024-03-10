import java.util.Scanner;

public class Main{

    public static void checkIndex(int index, Object[] arr){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ENTER INDEX : ");
        index = scanner.nextInt();

        try {
            System.out.println("YOUR CHOICE : " + arr[index]);
        }catch (Exception e){
            System.out.println("ERROR : " + e.getMessage());
        }
    }


    public static void main(String[] args) {

        Object[] list = {1,2,3,4,5,"NAME","SURNAME",4,5,7,8};

        checkIndex(5,list);

    }
}
