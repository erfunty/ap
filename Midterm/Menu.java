package Midterm;



public class Menu  {
    private InputProcessing inputMenu;
    private Library libraryMenu;
    private LibraryFile lFile;
    public Menu(Library library,InputProcessing inputProcessing,LibraryFile libraryFile){
        this.inputMenu=inputProcessing;
        this.libraryMenu=library;
        this.lFile=libraryFile;
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
                    lFile.saveLibraryToFile(libraryMenu);
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
            System.out.println(" 1.Searching a book\n 2.borrow book request\n 3.show the list of student books\n 4.returning a book request");
            choice=inputMenu.gettingInput();
            switch (choice){
                case "1":
                    libraryMenu.searchingBook();
                    break;
                case "2":
                    libraryMenu.borrowingBookRequest(ID);
                    break;
                case "3":
                    libraryMenu.showStudentBooks(ID);
                    break;
                case "4":
                    libraryMenu.returningBookRequest(ID);
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
                    break;
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
            System.out.println(" 1.Editing personal information\n 2.add book\n 3.checking requests \n 4.checking return request");

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
                case "4":
                    libraryMenu.checkingReturnRequests(ID);
                    break;

                default:
                    System.out.println("Invalid input, try again.");

            }
        }while (!choice.equals("q"));
    }

}
