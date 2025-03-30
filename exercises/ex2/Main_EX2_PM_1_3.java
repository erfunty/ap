package exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_1_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random generator = new Random();
        int row;
        int column;
        int k = 8;
        int c;
        do {
            System.out.print("enter number:");
            c = in.nextInt();
            if (c>=k*k){
                System.out.println("Invalid number error, please enter a number less than "+k*k);
            }
        } while (c >= k * k);
        char[][] arr = new char[k + 2][k + 2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i != 0 && i != k + 1 && j != 0 && j != k + 1) {
                    arr[i][j] = ' ';
                } else {
                    arr[i][j] = '*';
                }
            }
        }
        while (c>0){
            row=generator.nextInt(k+2);
            column=generator.nextInt(k+2);
            if(arr[row][column]!='*'&&arr[row][column]!='.'){
                arr[row][column]='.';
                c--;
            }


        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
