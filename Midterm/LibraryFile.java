package Midterm;

import java.io.*;


public class LibraryFile implements Serializable{
    private String filePath = "library_data.bin";

    public void saveLibraryToFile(Library library) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(library);
            System.out.println("Library saved successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving library: " + e.getMessage());
        }
    }

    public Library loadLibraryFromFile(InputProcessing input) {
        Library library = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            library = (Library) ois.readObject();
            library.setInputLibrary(input);
            System.out.println("Library loaded successfully from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading library: " + e.getMessage());
            library=new Library("beheshti",input);
        }
        return library;
    }
}
