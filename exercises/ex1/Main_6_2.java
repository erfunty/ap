package exercises.ex1;

import java.util.Scanner;

public class Main_6_2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int min=2147483647;
        int max=0;
        System.out.print("enter a number:");
        while(in.hasNextInt()){
            System.out.print("enter a number:");
            int num=in.nextInt();
            if(num<min){
                min=num;
            }
            if(num>max){
                max=num;
            }

        }
        System.out.println("the bigest number:"+max+"\n"+"the smallest number:"+min);
    }
}
