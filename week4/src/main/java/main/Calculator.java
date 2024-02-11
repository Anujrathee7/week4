package main;
import java.util.Collections;
import java.util.List;

public class Calculator {
    
    public double averageGrade(Student student){
        List<Integer> grade = student.getGrade();
        if (grade.isEmpty()) {
            return 0;
        }
        double average = 0;
        
        for(int i=0; i<grade.size();i++){
            average += grade.get(i);
        }

        return average/grade.size();
    }

    public double medianGrade(Student student){
        List<Integer> grade = student.getGrade();
        if (grade.isEmpty()) {
            return 0;
        }

        Collections.sort(grade);
        int size = grade.size();
        int middle = size/2;
        double total = grade.get(middle-1)+grade.get(middle);
        if (size%2 == 0) {
            return total/2.0;
        } else {
            return grade.get(middle);
        }


    }

}
