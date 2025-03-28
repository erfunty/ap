package exercises.ex1;

import java.util.Scanner;

public class Main_6_3 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("enter string");
        String str=in.nextLine();
//        String str="Hello Fucking World";
        for (int i = 0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))){
                System.out.print(str.charAt(i)+" ");
            }
        }
        System.out.println("\n");
        ////////////////////////////////
        for (int i = 1; i < str.length(); i+=2) {
                System.out.print(str.charAt(i)+" ");
            }
        }




}
