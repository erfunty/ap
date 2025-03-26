package exercises.ex1;

import java.util.Scanner;

public class Main_6_2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int min=2147483647;
        int max=0;
        int odd=0;
        int even=0;
        int cumul=0;
        int num=0;
        int previous=-1;
        String cumulative=new String();
        String pre=new String();
        System.out.print("enter a number:");
        while(in.hasNextInt()){
            System.out.print("enter a number:");
            if(previous!=num) {
                previous = num;
            }
            else{
                previous=-1;
            }
            num=in.nextInt();
            if(num<min){
                min=num;
            }
            if(num>max){
                max=num;
            }
            ///////////////////////////////////
            if(num%2==0){
                even++;
            }
            else{
                odd++;
            }
            //////////////////////////////////
            cumul=cumul+num;
            cumulative=cumulative+"  "+cumul;
            //////////////////////////////////
            if(previous==num){
                pre=pre+"   "+previous;
            }

        }

        System.out.println(cumulative);
        System.out.println(pre);
        System.out.println("the bigest number:"+max+"\n"+"the smallest number:"+min);
        System.out.println("number of odd:"+odd+"\n"+"number of even:"+even);
    }
}
