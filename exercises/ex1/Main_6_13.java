package exercises.ex1;

import java.util.Scanner;

public class Main_6_13 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("enter number:");
        int num= in.nextInt();
        while (num>0){
            System.out.println(num%2);
            num/=2;
        }
    }
}
