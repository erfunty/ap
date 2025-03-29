package exercises.ex1;

public class Main_6_16 {
    public static void main(String[] args) {
        int zarb=1;
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j <11; j++) {
                zarb=i*j;
                System.out.printf("%4d",zarb);
            }
            System.out.print("\n");

        }
    }
}
