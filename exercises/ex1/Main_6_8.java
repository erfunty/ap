package exercises.ex1;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Main_6_8 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter string:");
        String str=in.nextLine();
        for (int i = 0; i <str.length() ; i++) {
            System.out.println(str.charAt(i));
        }
    }
}
