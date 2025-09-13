package exercises.finalExam;

public class Librarian {
    private String name;
    private String username;
    private String password;

    public Librarian(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password changed successfully.");
    }

    @Override
    public String toString() {
        return "Librarian Name: " + name + " | Username: " + username;
    }
}
