package exercises.ex4;
class Circuite6{
    private int lampState;
    private int[] Switch=new int[2];

    public Circuite6(){
        lampState=0;
        Switch[0]=1;
        Switch[1]=1;


    }
    public int getSwitchState(int switchNum){
        return Switch[switchNum-1];
    }
    public int getLampState(){
        return lampState;
    } // 0 for off, 1 for on
    public void toggleSwitch(int switchNum){
        Switch[switchNum-1] = 1 - Switch[switchNum-1] ;
        lampState = 1 - lampState;

    }

    public void showLampState(){
        if(getLampState()==0){
            System.out.println("lamp is off.");
        }else {
            System.out.println("lamp is on.");
        }
    }
}
public class Main_EX4_E3_6 {
    public static void main(String[] args) {
        Circuite6 c1=new Circuite6();
        c1.toggleSwitch(1);
        c1.toggleSwitch(1);
        c1.toggleSwitch(2);
        c1.showLampState();
    }
}
