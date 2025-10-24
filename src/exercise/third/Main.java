package exercise.third;

import java.util.ArrayList;

//Variant - 1
public class Main {

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();

        Student s1 = new Student("1", "Vasilii");
        s1.addGrade(80);
        s1.addGrade(90);

        Student s2 = new Student("2", "Genadii");
        s2.addGrade(75);
        s2.addGrade(79);
        s2.addGrade(64);

        Student s3 = new Student("3", "Vitalii");
        s3.addGrade(65);
        s3.addGrade(78);
        s3.addGrade(92);
        s3.addGrade(83);

        //Added students to gradeBook
        gradeBook.addStudentAndGrades(s1);
        gradeBook.addStudentAndGrades(s2);
        gradeBook.addStudentAndGrades(s3);

        gradeBook.printAllStudentsAndGrades();
        Student found = gradeBook.findStudentInfoByID("2");
        System.out.println("Founded student with ID=2:");
        System.out.println(found);
        System.out.println("Removing student with ID=1:");
        gradeBook.removeStudentInfoByID("1");
        System.out.println("Actual grade book is:");
        gradeBook.printAllStudentsAndGrades();
        System.out.println("Clearing out grade book:");
        gradeBook.clearGradeBook();
    }
}