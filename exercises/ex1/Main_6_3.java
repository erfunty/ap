package exercises.ex1;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main_6_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       System.out.println("enter string");
      String str = in.nextLine();
     //String str="Hello Fucking World";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                System.out.print(str.charAt(i) + " ");
            }
        }
        System.out.println("\n");
        ////////////////////////////////
        for (int i = 1; i < str.length(); i += 2) {
            System.out.print(str.charAt(i) + " ");
        }
        /// ////////////////////////
        System.out.println("\n");
        System.out.println(str.replaceAll("[AEIOUaeiou]", "_"));

        /// ///////////
        int vowels=0;
        for (char c:str.toCharArray()){
             if ("AEIOUaeiou".indexOf(c) != -1) {
                vowels++;
            }
        }
        System.out.println(vowels);
        /// //////////////
        for (int i=0;i<str.length();i++) {
            if ("AEIOUaeiou".indexOf(str.charAt(i)) != -1) {
                System.out.print(i + " ");
            }
        }



    }




}

