package exercises.ex4;


class Circuit{
    private int lampState;
    private int firstSwitchState;
    private int secondSwitchState;
    public Circuit(){
        lampState=0;
        firstSwitchState=1;
        secondSwitchState=1;
    }
    public int getFirstSwitchState(){
        return firstSwitchState;
    } // 0 for down, 1 for up
    public int getSecondSwitchState(){
        return secondSwitchState;
    }
    public int getLampState(){
        return lampState;
    } // 0 for off, 1 for on
    public void toggleFirstSwitch(){
        if(lampState==0) {
            firstSwitchState--;
            lampState++;
        } else {
            firstSwitchState++;
            lampState--;
        }

    }
    public void toggleSecondSwitch(){
        if(lampState==0) {
            secondSwitchState--;
            lampState++;
        } else {
            secondSwitchState++;
            lampState--;
        }
    }
    public void showLampState(){
        if(getLampState()==0){
            System.out.println("lamp is off.");
        }else {
            System.out.println("lamp is on.");
        }
    }
}
public class Main_EX4_E3_4 {
    public static void main(String[] args) {
        Circuit c1=new Circuit();
        c1.showLampState();
        c1.toggleFirstSwitch();
        c1.toggleSecondSwitch();
        c1.toggleFirstSwitch();
        c1.showLampState();
    }
}
