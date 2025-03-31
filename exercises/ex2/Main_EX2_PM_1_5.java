package exercises.ex2;

import java.util.Random;

public class Main_EX2_PM_1_5 {
    public static void main(String[] args) {
        Random generator = new Random();
        int x=1;
        int y=1;
        int randomove;
        int k = 10;
        char[][] arr = new char[k + 2][k + 2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i != 0 && i != k + 1 && j != 0 && j != k + 1) {
                    arr[i][j] = ' ';
                } else {
                    arr[i][j] = '*';
                }
            }
        }
        arr[y][x]='x';
        while(true) {
            randomove = generator.nextInt(3);
            switch (randomove) {
                case 2:
                    if(arr[y+1][x]!='*') {
                        System.out.println("DOWN");
                        arr[y+1][x]='x';
                        arr[y][x]=' ';
                        y++;
                    }else{
                        System.out.println("hitting the game wall");
                    }
                    break;
                case 3:

                    break;
                case 0:
                    if(arr[y-1][x]!='*') {
                        System.out.println("UP");
                        arr[y-1][x]='x';
                        arr[y][x]=' ';
                        y--;
                    }else{
                        System.out.println("hitting the game wall");
                    }
                    break;
                case 1:
                    if(arr[y][x+1]!='*') {
                        System.out.println("RIGHT");
                        arr[y][x+1]='x';
                        arr[y][x]=' ';
                        x++;
                    }else {
                        System.out.println("hitting the game wall");
                    }
                    break;
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}


        }



    }
}
