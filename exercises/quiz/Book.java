package exercises.quiz;

public class Book extends Product{
    private String author;
    private String title;
    public Book(String name, int price,String author,String title) {
        super(name, price);
        this.author=author;
        this.title=title;
    }
    @Override
    public String toString(){
        return super.toString()+"author="+author+"\t"+"title="+title;
    }
}
