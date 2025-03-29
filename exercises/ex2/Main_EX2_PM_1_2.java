package exercises.ex2;

public class Main_EX2_PM_1_2 {
    public static void main(String[] args) {
        int k=8;
        char[][] arr=new char[k+2][k+2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(i!=0&&i!=k+1&&j!=0&&j!=k+1){
                    arr[i][j]=' ';
                }else {
                    arr[i][j]='*';
                }
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
