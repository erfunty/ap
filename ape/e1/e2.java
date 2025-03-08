package ape.e1;

import java.util.Scanner;

public class e2 {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.println("enter your income:");
        int money= scan.nextInt();
        if(money<50000){
            System.out.println("your tax is:"+money/100);
        } else if (money>50000&&money<75000){
            System.out.println("your tax is:"+money/50);
        } else if (money>75000&&money<100000) {
            System.out.println("your tax is:"+money*3/100);
        } else if (money>100000&&money<250000) {
        System.out.println("your tax is:"+money/25);
        }else if (money>250000&&money<500000) {
            System.out.println("your tax is:"+money/20);
        }else if (money>500000) {
            System.out.println("your tax is:"+money*6/100);
        }
    }
}
