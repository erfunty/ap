package Midterm;

public class Main {
    public static void main(String[] args) {

        LibraryFile lFile=new LibraryFile();
        InputProcessing inputProcessing=new InputProcessing();
        Manager manager=new Manager("ali","ahmadi","high school");
        Menu menu = new Menu(lFile.loadLibraryFromFile(inputProcessing),inputProcessing,lFile);
        menu.startMenu();
    }



}
