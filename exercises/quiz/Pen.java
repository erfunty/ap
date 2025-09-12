package exercises.quiz;

public class Pen extends Product{
    Color color;


    public Pen(String name, int price,Color color) {
        super(name, price);
        this.color=color;
    }
    @Override
    public String toString(){
        return super.toString()+"color="+color;
    }
}
