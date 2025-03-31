package exercises.ex2;

import java.util.Scanner;
import java.lang.String;
public class Main_EX2_PM_1_4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter your choise (w for up/a for left/s for down/d for right): ");
         char choise;
         do {
             choise=in.next().charAt(0);
             switch (choise){
                 case 'w':
                     System.out.println("UP");
                     break;
                 case 'a':
                     System.out.println("LEFT");
                     break;
                 case 's':
                     System.out.println("DOWN");
                     break;
                 case 'd':
                     System.out.println("RIGHT");
                     break;
                 case 'q':
                     System.out.println("EXIT");
                     break;
                 default:
                     System.out.println("WARNING");
             }
         }while (choise!='q');
    }
}
