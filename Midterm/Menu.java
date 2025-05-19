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
            System.out.println("Entering the library as \n 1.student \n 2.manager \n 3.librarian");
            choice=inputMenu.gettingInput();
            switch (choice){
                case "1": studentSignMenu();break;
                case "2": managerMenu();break;
                case "3": librarianMenu();break;
                case "q":
                    System.out.println("Exiting...");break;
                default:
                    System.out.println("Invalid input, try again.");
            }

        }while (!choice.equals("q"));
    }
    public void studentSignMenu(){
        String choice;
        do {

            System.out.println("Have you already registered?\n 1.Login with student number");
            System.out.println(" 2. New member? Sign up");
            choice=inputMenu.gettingInput();
            switch (choice){
                case "1":
                    studentLibraryMenu();
                    break;

                case "2":
                    libraryMenu.studentRegistration();
                    return;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }while (!choice.equals("q"));
    }
    public void studentLibraryMenu(){

        System.out.println("enter your student number:");
        String ID=inputMenu.getStudentID();
        if(!libraryMenu.checkExistStudent(ID)){
            return;
        }
        String choice;
        do {
            System.out.println(" 1.Searching a book\n 2.borrow book request\n 3.show the list of student books");
            choice=inputMenu.gettingInput();
            switch (choice){
                case "1":
                    libraryMenu.searchingBook();
                    break;
                case "2":
                    libraryMenu.borrowingBookRequest(ID);
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }while (!choice.equals("q"));
    }


    public void managerMenu(){
        String choice;
        do {
            System.out.println("1.add librarian");

            choice=inputMenu.gettingInput();
            switch (choice){
                case "1":
                    libraryMenu.addLibrarian();
                default:
                    System.out.println("Invalid input, try again.");

            }
        }while (!choice.equals("q"));
    }
    public void librarianMenu(){
        System.out.println("enter your employee ID:");
        String ID=inputMenu.getEmployeetID();
        if(!libraryMenu.checkExistLibrarian(ID)){
            return;
        }
        String choice;
        do {
            System.out.println(" 1.Editing personal information\n 2.add book\n 3.checking requests");

            choice=inputMenu.gettingInput();
            switch (choice){
                case "1":
                    libraryMenu.editingInformationLibrarian(ID);
                    break;
                case "2":
                    libraryMenu.addBook();
                    break;
                case  "3":
                    libraryMenu.checkingRequests(ID);
                    break;


                default:
                    System.out.println("Invalid input, try again.");

            }
        }while (!choice.equals("q"));
    }

}
