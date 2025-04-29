package exercises.ex4;
class Letter{
    private String sender;
    private String receiver;
    private String body="";
    public Letter(String from, String to){
        sender=from;
        receiver=to;
        body=body.concat("Dear ").concat(receiver).concat(":").concat("\n\n");
    }
    public void addLine(String line){
        body=body.concat(line).concat("\n");
    }
    public String getText(){
        return body=body.concat("\n").concat("Sincerely,").concat("\n\n").concat(sender);
    }

}
public class Main_EX4_E3_15 {
    public static void main(String[] args) {
        Letter l1=new Letter("me","me");
        l1.addLine("hi");
        l1.addLine("bye");
        System.out.println(l1.getText());
    }
}
