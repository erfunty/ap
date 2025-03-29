package exercises.ex1;

import java.util.Scanner;

public class Main_6_17 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("enter number:");
        int num=in.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <num ; j++) {
                System.out.print("*");
            }
            System.out.print(" ");
            for (int j = 0; j <num ; j++) {
                if(i==0||i==num-1||j==0||j==num-1){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
