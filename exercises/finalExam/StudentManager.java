package exercises.finalExam;

import java.io.*;
import java.util.*;


public class StudentManager {
    private List<Student> students;
    private final String studentFPath="student.dat";

    public StudentManager() {
        this.students = new ArrayList<>();
        loadStudents();
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Please choose a different username.");
            return;
        }

        Student newStudent = new Student(name, studentId, username, password);
        students.add(newStudent);
        saveStudent();
        System.out.println("Student registration completed successfully.");
    }

    public Student authenticateStudent(String username, String password) {
        return students.stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public void displayStudents() {
        System.out.println("\n--- List of Registered Students ---");

        if (students.isEmpty()) {
            System.out.println("No students have registered yet.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }


    private boolean isUsernameTaken(String username) {
        return students.stream().anyMatch(s -> s.getUsername().equals(username));
    }

    public int getStudentCount() {
        return students.size();
    }
    private void saveStudent(){
        try(ObjectOutputStream writerStu=new ObjectOutputStream(new FileOutputStream(studentFPath))) {
           writerStu.writeObject(students); ;
        } catch (IOException e){
            System.out.println("Error saving student: "+e.getMessage());
        }

    }
    private void loadStudents(){
        File file=new File(studentFPath);
        if (!file.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(studentFPath))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }
}
