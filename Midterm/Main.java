package Midterm;

public class Main {
    public static void main(String[] args) {
        InputProcessing inputProcessing=new InputProcessing();
        Library library = new Library("beheshti",inputProcessing);
        Menu menu = new Menu(library,inputProcessing);
        menu.startMenu();
    }

}
