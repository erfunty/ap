package exercises.ex4;
class CircuitTester{
     private Circuit c2=new Circuit();



    public void state(int expectedLamp,int expectedfirst,int expectedsecond){
        System.out.printf("Combination expected:first=%d,second=%d\n",expectedfirst,expectedsecond);
        if(expectedLamp==0){
            System.out.println("lamp is off");
        }else {
            System.out.println("lamp is on");
        }
        System.out.printf("Actual Switch=first=%d,second=%d\n",c2.getFirstSwitchState(),c2.getSecondSwitchState());
        if(c2.getLampState()==0){
            System.out.println("lamp is off");
        }else {
            System.out.println("lamp is on");
        }


    }
    public void toggleFirst (){
        c2.toggleFirstSwitch();
    }
    public void toggleSecond (){
        c2.toggleSecondSwitch();
    }
}
public class Main_EX4_E3_5 {
    public static void main(String[] args) {
        CircuitTester ct1=new CircuitTester();
        /*0 for off,1 for on
         0 for down, 1 for up
         */
        ct1.state(0, 1, 1);


        ct1.toggleSecond(); // second switch down
        ct1.state(1, 1, 0);


        ct1.toggleFirst(); // first switch down
        ct1.state(0, 0, 0);


        ct1.toggleSecond(); // second switch up
        ct1.state(1, 0, 1);

    }
}
