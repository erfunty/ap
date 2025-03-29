package exercises.ex1;

import java.util.Scanner;

public class Main_6_18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter number:");
        int n = in.nextInt();



        for (int i = 1; i <= n; i++) {
            for (int j = i; j <n; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2* i-1);j++) {
                System.out.print("*");
            }


            System.out.println();
        }


        for (int i=n-1; i >= 1;i--) {
            for (int j =n;j>i;j--) {
                System.out.print(" ");
            }
            for (int j=1;j<=(2*i-1);j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
