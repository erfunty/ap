package exercises.ex2;

import java.io.IOException;
class PacmanEngine{
    private int k;
    private int pacman_x;
    private int pacman_y;
    private char[][] arr;
    public PacmanEngine(int value){
        k=value;
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
        pacman_y=(k+2)/2;
        pacman_x=(k+2)/2;
        arr[pacman_y][pacman_x]='C';
    }
    public void move(int move_y, int move_x) {
        int x = pacman_x + move_x;
        int y = pacman_y + move_y;
        if (arr[y][x] != '*'){
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
}
public class Main_EX2_PM_2_1 {
    public static void main(String[] args) throws IOException {
        int k=9;
        PacmanEngine pacmanEngine = new PacmanEngine(k);
        int choise;
        do {
            pacmanEngine.printMatrix();
            try {
                Thread.sleep(500);
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
            } while (choise != 'q');
    }
}
