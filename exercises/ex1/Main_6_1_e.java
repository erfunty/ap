package exercises.ex1;

import java.util.Scanner;

public class Main_6_1_e {
    public static void main(String[] args) {
        System.out.print("enter number:");
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int sumo=0;
        while (num>0){
            if((num%10)%2==1){
                sumo=sumo+num%10;
            }
            num=num/10;
        }
        System.out.println("sum odd digit:"+sumo);
    }
}
