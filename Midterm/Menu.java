package Midterm;


public class Menu {
    private InputProcessing inputMenu;
    private Library libraryMenu;
    public Menu(Library library,InputProcessing inputProcessing){
        this.inputMenu=inputProcessing;
        this.libraryMenu=library;
    }


    public void startMenu(){
        String choice;
        System.out.println(libraryMenu.getName()+" LIBRARY");
        do {

            System.out.println("Entering the library as \n 1.student \n 2.manager");
            choice=inputMenu.gettingInput();
            switch (choice){
                case "1": studentSignMenu();break;
                case "2":
                case "q":
                    System.out.println("Exiting...");break;
                default:
                    System.out.println("Invalid input, try again.");
            }

        }while (!inputMenu.equals("q"));
    }
    public void studentSignMenu(){
        do {
            String choice;
            System.out.println("Have you already registered?\n 1.Enter student ID");
            System.out.println("2. New member? Sign up");
            choice=inputMenu.gettingInput();
            switch (choice){
                case "1":

                case "2":
                    libraryMenu.studentRegistration();
                    return;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }while (!inputMenu.gettingInput().equals("q"));
    }
    public void studentLibraryMenu(){
        do {
            String choice;
            System.out.println("1.Searching a book");
            choice=inputMenu.gettingInput();
            switch (choice){
                case "1":

                case "2":
                    libraryMenu.studentRegistration();
                    return;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }while (!inputMenu.gettingInput().equals("q"));
    }

    public void managerMenu(){
        do {
            String choice;
            System.out.println("LIBRARY");
            System.out.println("Have you already registered?\n 1.Enter student ID");
            System.out.println("2. New member? Sign up");
            choice=inputMenu.gettingInput();
            switch (choice){
                case "1":
                    ;
                case "2":
                default:
                    System.out.println("Invalid input, try again.");

            }
        }while (!inputMenu.gettingInput().equals("q"));
    }

}
