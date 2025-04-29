package exercises.ex4;




class CashRegister {
    private double total;
    private String receipt;

    public CashRegister() {
        total = 0;
        receipt = "";
    }

    public void add(double price) {
        total += price;
        receipt = receipt.concat(": $" + String.valueOf(price) + "\n");
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        System.out.print(receipt);
        System.out.println("Total: $" + String.valueOf(total));
    }
}

public class Main_EX4_E3_10 {
    public static void main(String[] args) {
        CashRegister cash=new CashRegister();
        cash.add(245);
        cash.add(14);
        cash.add(15);
        cash.printReceipt();
    }
}
