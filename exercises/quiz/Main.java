package exercises.quiz;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> list=new ArrayList<>();
        list.add(new Book("clown",25,"me","jenaii"));
        list.add(new Book("big java",120,"yki","horror"));
        list.add(new Pen("beek",24,Color.blue));
        list.add(new Pen("beek",24,Color.blue));
        list.add(new Pen("faber",51,Color.red));
        for (Product product : list) {
            System.out.println(product);
        }
        System.out.println("..................................");
        ProductTools.cleaning(list);
        System.out.println("....................................");
        ProductTools.best(list);
    }
}
