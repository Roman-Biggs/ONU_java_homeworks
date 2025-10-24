package exercise.third;

import java.util.HashMap;

public class GradeBook {
    private HashMap<String, Student> StudentsAndGrades = new HashMap<>();

    public GradeBook(HashMap<String, Student> info) { this.StudentsAndGrades = info; }

    public GradeBook() {}

    public HashMap<String, Student> getStudentsAndGrades() { return new HashMap<>(StudentsAndGrades); }

    public void addStudentAndGrades(Student student) { StudentsAndGrades.put(student.getID(), student); }

    public Student findStudentInfoByID(String ID) { return StudentsAndGrades.get(ID); }

    public void removeStudentInfoByID(String ID) {
        if (StudentsAndGrades.containsKey(ID)) {
            StudentsAndGrades.remove(ID);
            System.out.println("Student with ID: " + ID + " has been removed.");
        }
        else {
            System.out.println("Student with ID: " + ID + " is not found.");
        }
    }

    public void clearGradeBook() { StudentsAndGrades.clear(); System.out.println("Grade book has been cleared."); }

    public void printAllStudentsAndGrades() {
        if (StudentsAndGrades.isEmpty()) {
            System.out.println("Grade book is empty.");
        }
        else {
            System.out.println("All students in grade book:");
            for (Student s :  StudentsAndGrades.values()) {
                System.out.println(s);
            }
        }
    }

}