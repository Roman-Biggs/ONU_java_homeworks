package exercise.third;

import java.util.ArrayList;

public class Student {
    private String ID;
    private String name;
    private ArrayList<Integer> grades;

    public Student(String ID, String name, ArrayList<Integer> grades) {
        this.ID = ID;
        this.name = name;
        this.grades = grades;
    }

    public Student(String ID, String name){
        this.ID = ID;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getID() { return ID; }
    public String getName() { return name; }
    public ArrayList<Integer> getGrades() { return new ArrayList<Integer>(grades); } //returns copy of list

    public void setID(String ID) { this.ID = ID; }
    public void setName(String name) { this.name = name; }
    public void addGrade(Integer grade) {
        grades.add(grade);
    }

    @Override
    public String toString() { return "ID: " + ID + ", Name: " + name + ", Grades: " + grades; }
}