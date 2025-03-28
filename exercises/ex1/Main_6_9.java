package exercises.ex1;

import java.util.Scanner;

public class Main_6_9 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("enter string:");
        String str=in.nextLine();
        for (int i = str.length()-1; i >=0 ; i--) {
            System.out.print(str.charAt(i));

        }
    }
}
