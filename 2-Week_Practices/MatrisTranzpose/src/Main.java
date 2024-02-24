
public class Main {
    public static void main(String[] args) {
        int[][] list= {{3,5,7},{2,4,6}};
        System.out.println("List matris : ");

        for (int vertical = 0; vertical < list.length; vertical++) {
            for (int horizon = 0; horizon < list[vertical].length; horizon++) {
                   System.out.print(list[vertical][horizon]+" ");
                }
            System.out.println("");
        }

        System.out.println("result : ");

        for (int vertical = 0; vertical <list[0].length ; vertical++) {
            for (int horizon = 0; horizon < list.length ; horizon++) {
                System.out.print(list[horizon][vertical]+" ");
            }
            System.out.println("");
        }
    }
}
