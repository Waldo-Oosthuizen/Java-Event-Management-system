package managers;

import java.util.List;
import java.util.ArrayList;

import models.Student;



public class StudentManager {
    
    private List<Student> students;
   

    // Constructor
    public StudentManager() {
        
         students = new ArrayList<>();

        // Alice
        students.add(new Student(
            101,
            "Harry",
            "harry@gmail.com"
        ));
        // Bob
        students.add(new Student(
            102,
            "Ron",
            "ron@gmail.com"
        ));

        students.add(new Student(
            103,
            "Hermione",
            "hermoine@gmail.com"
        ));
    }




    // Getter
    public List<Student> getStudents() {
        return students;
    }

    // Get student by ID
    public Student getStudentById(Integer studentId){

        for (Student student : students) {
            if (student.getId().equals(studentId)){
                return student;
            }
        }

        return null;

    }

}
