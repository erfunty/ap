package ape.e1;

import java.util.Scanner;

public class e1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("enter a number:");
        float num = scan.nextFloat();
        if(num==0){
            System.out.println("zero");
        } else if (num>0) {
            System.out.println("positive");
            if(num<1){
                System.out.println("small");
            } else if (num>1000000) {
                System.out.println("big");
            }
        } else {
            System.out.println("negative");
        }
    }
}
