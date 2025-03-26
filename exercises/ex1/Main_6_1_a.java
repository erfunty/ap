package exercises.ex1;

public class Main_6_1_a {
    public static void main(String[] args) {
        int sum=0;
        for (int i = 0; i < 101; i++) {
            if(i%2==0){
                sum=sum +i;
            }
        }
        System.out.println(sum);
    }
}
