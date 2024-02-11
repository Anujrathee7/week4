package main;

import java.io.Serializable;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
public class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Map<String,Integer> completedCourse;
    private String name;
    private String studentNumber;
    
   
    public Student(String name,String studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;
        this.completedCourse = new LinkedHashMap<>();
    }
    
   
    public void addCourse(String courseName, int grade){
        completedCourse.put(courseName, grade);
    }
    
    public String getName(){
        return this.name;
    }
   
    public String getNumber(){
        return this.studentNumber;
    }

    public void listGrade(){
        for(Map.Entry<String,Integer> entry : completedCourse.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

    public List<Integer> getGrade(){
        List<Integer> grade = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : completedCourse.entrySet()){
            grade.add(entry.getValue());
        }
        return grade;
    }   
}
