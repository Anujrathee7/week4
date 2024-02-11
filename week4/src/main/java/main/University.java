package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;
    
    public University(){
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getStudents(){
        return students;
    }

    public void saveData(){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("students.ser"))){
            outputStream.writeObject(students);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadData(){
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("students.ser"))) {
                students = (List<Student>) inputStream.readObject();
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        
    }
}
