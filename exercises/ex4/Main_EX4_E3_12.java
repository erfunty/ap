package exercises.ex4;

class Employee{
    private String employeeName;
    private double salary;

    public Employee(String employeeName, double currentSalary){
        this.employeeName=employeeName;
        this.salary=currentSalary;
    }
    public String getName(){
        return employeeName;
    }
    public double getSalary(){
        return salary;
    }
    public void raiseSalary(double byPercent){
        salary+=byPercent*salary/100;
    }
}
public class Main_EX4_E3_12 {
    public static void main(String[] args) {
        Employee harry = new Employee("Hacker, Harry", 50000);
        harry.raiseSalary(10);
        System.out.println(harry.getName());
        System.out.println(harry.getSalary());

    }
}
