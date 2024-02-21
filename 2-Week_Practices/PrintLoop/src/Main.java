import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userValue = new Scanner(System.in);

        System.out.print("enter value : ");
        int value = userValue.nextInt();
        System.out.print("print : ");
        printLoopLow(value, value);

    }

    static int printLoopLow(int valueDown,int valueUp) {
        System.out.print(valueDown + " ");
        if (valueDown > 0) {
            valueDown -= 5;
            return printLoopLow(valueDown, valueUp);
        } else {
            return printLoopUp(valueDown, valueUp);
        }
    }

    static int printLoopUp(int valueDown,int valueUp) {
        if (valueDown < valueUp) {
            valueDown += 5;
            System.out.print(valueDown + " ");
            return printLoopUp(valueDown, valueUp);
        }
        else
            return valueDown;
    }
}