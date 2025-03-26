package exercises.ex1;

import java.util.Scanner;

public class Main_5_18 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String list=new String();
        System.out.print("enter name1:");
        String name1=in.nextLine();
        System.out.print("enter name2:");
        String name2=in.nextLine();
        System.out.print("enter name3:");
        String name3=in.nextLine();
        if(name1.compareTo(name2)<0){
            if(name1.compareTo(name3)<0){
                if(name2.compareTo(name3)<0){
                    list=name1+"\n"+name2+"\n"+name3;
                }
                else{
                    list=name1+"\n"+name3+"\n"+name2;
                }
            }
            else{
                list=name3+"\n"+name1+"\n"+name2;
            }
        }
        else{
            if(name2.compareTo(name3)<0){
                if(name1.compareTo(name3)<0){
                    list=name2+"\n"+name1+"\n"+name3;
                }
                else{
                    list=name2+"\n"+name3+"\n"+name1;
                }
            }
            else{
                list=name3+"\n"+name2+"\n"+name1;
            }
        }
        System.out.println(list);

    }
}
