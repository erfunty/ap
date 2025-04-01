package exercises.ex2;

import java.io.IOException;
import java.util.Random;



class PacmanEngine{
    private int k;
    private int food;
    int res;
    private int pacman_x;
    private int pacman_y;
    private char[][] arr;
    private int score;
    public PacmanEngine(int valuek,int valuec){
        Random generator = new Random();
        score=0;
        k=valuek;
        food=valuec;
        int showf=valuec;
        int row;
        int column;
        arr = new char[k + 2][k + 2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i != 0 && i != k + 1 && j != 0 && j != k + 1) {
                    arr[i][j] = ' ';
                } else {
                    arr[i][j] = '*';
                }
            }
        }
        while (showf>0){
            row=generator.nextInt(k+2);
            column=generator.nextInt(k+2);
            if(arr[row][column]!='*'&&arr[row][column]!='.'&&arr[row][column]!='C'){
                arr[row][column]='.';
                showf--;
            }


        }
        pacman_y=(k+2)/2;
        pacman_x=(k+2)/2;
        arr[pacman_y][pacman_x]='C';
    }
    public void move(int move_y, int move_x) {
        int x = pacman_x + move_x;
        int y = pacman_y + move_y;
        if (arr[y][x] != '*'){
            if (arr[y][x] == '.') {
                score++;
                food--;
                if (food == 0) {
                    res = 2;
                    return;
                }
            }

            arr[pacman_y][pacman_x] = ' ';
            pacman_x = x;
            pacman_y = y;
            arr[pacman_y][pacman_x] = 'C';
        }
    }
    public void printMatrix(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void printScore(){
        System.out.println("score:"+score);
    }
    public int result(){
        return res;
    }
}
public class Main_EX2_PM_2_2 {
    public static void main(String[] args) throws IOException {
        int k=9;
        int c=15;
        PacmanEngine pacmanEngine = new PacmanEngine(k,c);
        int choise;
        long start = System.currentTimeMillis();
        do {
            if (pacmanEngine.res == 2) {
                System.out.println("You Win! ");
                pacmanEngine.printScore();

            }
            pacmanEngine.printMatrix();
            pacmanEngine.printScore();
            try {
                Thread.sleep(500 );
            } catch (Exception e) {}
            if(System.in.available() > 0) {
                choise = System.in.read();
                switch (choise) {
                    case 'w':
                        pacmanEngine.move(-1, 0);
                        break;
                    case 's':
                        pacmanEngine.move(1, 0);
                        break;
                    case 'a':
                        pacmanEngine.move(0, -1);
                        break;
                    case 'd':
                        pacmanEngine.move(0, 1);
                        break;
                    case 'q':
                        System.out.println("Game Over!");
                }
            }else {
                choise = 'z';
            }
            if (pacmanEngine.res == 2) {
                System.out.println("You Win! ");
                pacmanEngine.printScore();
                choise='q';
            }
        } while (choise != 'q');
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed/1000+"s");

    }

}
