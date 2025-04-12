package exercises.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class PacmanEngine2{
    private int k;
    private int food;
    int res;
    private int pacman_x;
    private int pacman_y;
    private char[][] arr;
    private int score;
    private String fileName = Main_EX2_PM_2_3.SAVE_PATH;
    public PacmanEngine2(){}
    public PacmanEngine2(int valuek,int valuec){
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
    public void save() throws FileNotFoundException {
        PrintWriter matrix= new PrintWriter(fileName);
        matrix.println(k);
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                matrix.print(arr[i][j]);
            }
            matrix.println();
        }
        matrix.print(score);
        matrix.println();
        matrix.print(food);
        matrix.close();
    }
    public void load() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        k =scanner.nextInt();
        scanner.nextLine();
        arr=new char[k+2][k+2];
        for (int i = 0; i < arr.length; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = line.charAt(j);
                if (line.charAt(j) == 'C') {
                    pacman_x = j;
                    pacman_y = i;
                }
            }
        }

            if (scanner.hasNextInt()) {
                score = scanner.nextInt();
            }
            if (scanner.hasNextInt()) {
                food = scanner.nextInt();
            }

        scanner.close();
    }
}
public class Main_EX2_PM_2_3 {
    public static final String SAVE_PATH = "matrix.txt";
    public static void main(String[] args) throws IOException {
        int k = 9;
        int c = 15;
        PacmanEngine2 pacmanEngine2;

        File saveFile = new File(SAVE_PATH);
        if (saveFile.exists()) {
                pacmanEngine2 = new PacmanEngine2();
                pacmanEngine2.load();
        } else {
            System.out.println("No saved game found. Start new game.");
            pacmanEngine2 = new PacmanEngine2(k, c);
        }
        int choise;
        long start = System.currentTimeMillis();
        do {

            if (pacmanEngine2.res == 2) {
                System.out.println("You Win! ");
                pacmanEngine2.printScore();

            }
            pacmanEngine2.printMatrix();
            pacmanEngine2.printScore();
            try {
                Thread.sleep(500 );
            } catch (Exception e) {}
            if(System.in.available() > 0) {
                choise = System.in.read();
                switch (choise) {
                    case 'w':
                        pacmanEngine2.move(-1, 0);
                        break;
                    case 's':
                        pacmanEngine2.move(1, 0);
                        break;
                    case 'a':
                        pacmanEngine2.move(0, -1);
                        break;
                    case 'd':
                        pacmanEngine2.move(0, 1);
                        break;
                    case 'q':
                        System.out.println("Game Over!");
                        pacmanEngine2.save();
                }
            }else {
                choise = 'z';
            }
            if (pacmanEngine2.res == 2) {
                System.out.println("You Win! ");
                pacmanEngine2.printScore();
                choise='q';
                pacmanEngine2.save();
            }
        } while (choise != 'q');
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed/1000+"s");

    }
}
