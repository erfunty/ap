package ape.e1;


import java.util.ArrayList;

class Pen{
    String color;
    double price;
    String brand;
    int off;
    public Pen(String color, double price,String brand,double off){
        this.color=color;
        this.price=price-price*off/100;
        this.brand=brand;
    }
    public void showinfo(){
        System.out.println(color+price+brand);
    }
}
class Book {
    String name;
    double price;
    int off;

    public Book(String name, double price,double off){
        this.name=name;
        this.price=price-price*off/100;
    }
    public void showinfo(){
        System.out.println(name+price);
    }
}

public class Q {
    public static void main(String[] args) {
        ArrayList<Pen> p=new ArrayList<>();
        ArrayList<Book>b=new ArrayList<>();
        p.add(new Pen("red",2.5,"bic",15));
        p.add(new Pen("blue",3.5,"bic",10));
        b.add(new Book("new clown",10.5,10));
        b.add(new Book("clown",20,10));
        for (Pen pens : p) {
            pens.showinfo();
        }
        for (Book books : b) {
            books.showinfo();
        }

    }
}

