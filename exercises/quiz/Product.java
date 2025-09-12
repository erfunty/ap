package exercises.quiz;


import java.util.Objects;

public class Product {
    private String name;
    private int price;


    public Product(String name,int price){
        this.name=name;
        this.price=price;
    }
    public int getPrice(){
        return price;
    }


    @Override
    public String toString(){
        return "name="+name+"\t"+"price="+price+"\t";
    }
    @Override
    public boolean equals(Object o){
        if (o==this)return true;
        if(!(o instanceof Product)) return false;
        Product product=(Product) o;
        return price==product.price&&Objects.equals(name,product.name);
    }



    @Override
    public int hashCode() {
        return Objects.hash(name,price);
    }
}
