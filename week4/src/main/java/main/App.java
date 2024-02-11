package main;

import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        Scanner sc = new Scanner(System.in);
        University university = new University();
        Calculator calculator = new Calculator();
        boolean exit = false;
       
        while (!exit) {
       
            System.out.println("1) Add student, 2) List students, 3) Add course completion for student, 4) List course completions of student, 5) Calculate the average of course completions, 6) Calculate median of course completions, 7) Save students to file, 8) Load students from file, 0) End the program");
            String choiceString = sc.nextLine();
            int choice = Integer.parseInt(choiceString);
            
            switch (choice) {
                
                case 1:
                    System.out.println("What is the name of the student?");
                    String name = sc.nextLine();
                    System.out.println("What is the student number of the student?");
                    String studentNumber = sc.nextLine();
                    university.addStudent(new Student(name,studentNumber));
                    break;
               
                case 2:
                    List<Student> students = university.getStudents();
                    System.out.println("students:");
                    for(int i = 0; i < students.size();i++){
                    System.out.println(students.get(i).getNumber()+": "+students.get(i).getName());
                    }
                    break;
                
                case 3:
                    students = university.getStudents();
                    for(int i = 0; i < students.size();i++){
                        System.out.println(i+": "+students.get(i).getName());
                    }
                    System.out.println("Which student do you want to add course completion for?");
                    String indexString = sc.nextLine();
                    int studentIndex = Integer.parseInt(indexString);
                    System.out.println("What is the name of the course?");
                    String courseName = sc.nextLine();
                    System.out.println("What is the grade of the course?");
                    String gradeString = sc.nextLine();
                    int grade = Integer.parseInt(gradeString);
                    students.get(studentIndex).addCourse(courseName,grade);
                    break;
                
                case 4:
                    students = university.getStudents();
                    for(int i = 0; i < students.size();i++){
                        System.out.println(i+": "+students.get(i).getName());
                    }
                    
                    System.out.println("Which student do you want to list course completions for?");
                    indexString = sc.nextLine();
                    studentIndex = Integer.parseInt(indexString);
                    students.get(studentIndex).listGrade();
                    break;

                case 5:
                    students = university.getStudents();
                    for(int i = 0; i < students.size();i++){
                        System.out.println(i+": "+students.get(i).getName());
                    }
                    System.out.println("Which student do you want to calculate the average for?");
                    indexString = sc.nextLine();
                    studentIndex = Integer.parseInt(indexString);
                    double answer = calculator.averageGrade(students.get(studentIndex));
                    System.out.println("Average is "+ answer);
                    break;

                case 6:
                    students = university.getStudents();
                    for(int i = 0; i < students.size();i++){
                        System.out.println(i+": "+students.get(i).getName());
                    }
                    
                    System.out.println("Which student do you want to calculate the median for?");
                    indexString = sc.nextLine();
                    studentIndex = Integer.parseInt(indexString);
                    double median = calculator.medianGrade(students.get(studentIndex));
                    System.out.println("Median is "+ median);
                    break;
                case 7:
                    university.saveData();
                    break;
                case 8:
                    university.loadData();
                    students = university.getStudents();
                    break;
                case 0:                    
                    exit = true;
                    System.out.println("thank you for using the program.");
                    break;
                default:
                    System.out.println("Wrong Input value");
                    break;
            }                    
            }
        
        sc.close();
    }
}
