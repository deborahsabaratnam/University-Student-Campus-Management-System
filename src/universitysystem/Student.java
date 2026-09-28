package universitysystem;

public class Student {

    private String studentId;
    private String name;
    private String course;
    private double marks;

    public Student(String studentId, String name, String course, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId
                + ", Name: " + name
                + ", Course: " + course
                + ", Marks: " + marks;
    }
}