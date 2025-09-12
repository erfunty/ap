package exercises.quiz;

import java.util.*;
import java.util.stream.Collectors;

public class ProductTools {
    public static void cleaning(List<Product> list){
        List<Product> cleanedproduct=list.stream().
                collect(Collectors.toCollection(HashSet::new)).
                stream().
                sorted(Comparator.comparingInt(Product::getPrice)).
                collect(Collectors.toList());
        for (Product product : cleanedproduct) {
            System.out.println(product);
        }
    }
    public static List<Optional> best(List<Product> list){
        Optional<Book> max=list.stream().filter(n -> n instanceof Book).map(n ->(Book) n).max(Comparator.comparingInt(Product::getPrice));
        Optional<Pen> maxp=list.stream().filter(n->n instanceof Pen).map(n -> (Pen) n).max(Comparator.comparingInt(Product::getPrice));
        List<Optional> p=new ArrayList<>();
        p.add(max);
        p.add(maxp);
        return p;


    }

}
