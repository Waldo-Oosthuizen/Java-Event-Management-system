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
            "Alice",
            "alice@gmail.com"
        ));
        // Bob
        students.add(new Student(
            102,
            "Bob",
            "bob@gmail.com"
        ));

        students.add(new Student(
            103,
            "Charlie",
            "charlie@gmail.com"
        ));
    }


    private Student bob = new Student(
        102,
        "Bob",
        "bob@gmail.com"
    );

    private Student charlie = new Student(
        103,
        "Charlie",
        "charlie@gmail.com"
    );

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
