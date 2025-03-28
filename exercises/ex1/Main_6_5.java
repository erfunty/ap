package exercises.ex1;

import java.util.Scanner;

class Dataset{
    private double[] arr=new double[10];
    int currentsize=0;
    public void add(double value){
        arr[currentsize]=value;
        currentsize++;
    }
    public void show(){
        for (int i = 0; i <currentsize ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public void getAverage(){
        double sum=0;
        double average=0;
        for (int i = 0; i < currentsize; i++) {
            sum+=arr[i];
        }
        average=sum/currentsize;
        System.out.println("Average:"+average);
    }
    public void getSmallest(){
        double small=arr[0];
        for (int i = 1; i <currentsize ; i++) {
            if(arr[i]<small){
                small=arr[i];
            }
        }
        System.out.println("smallest:"+small);
    }
    public void getLargest(){
        double big=arr[0];
        for (int i = 1; i <currentsize ; i++) {
            if(arr[i]>big){
                big=arr[i];
            }
        }
        System.out.println("Largest:"+big);
    }
    public void getRange(){
        double range;
        double big=arr[0];
        for (int i = 1; i <currentsize ; i++) {
            if(arr[i]>big){
                big=arr[i];
            }
        }
        double small=arr[0];
        for (int i = 1; i <currentsize ; i++) {
            if(arr[i]<small){
                small=arr[i];
            }
        }
        range=big-small;
        System.out.println("range:"+range);

    }
}


public class Main_6_5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Dataset arrvalue=new Dataset();

        System.out.println("enter values one by one with enter:");

        while (in.hasNextDouble()){
            arrvalue.add(in.nextDouble());


        }
        arrvalue.getAverage();
        arrvalue.getLargest();
        arrvalue.getSmallest();
        arrvalue.getRange();
    }
}
