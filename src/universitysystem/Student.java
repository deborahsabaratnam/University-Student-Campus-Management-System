package universitysystem;

public class Student {

<<<<<<< HEAD
    Object getStudentId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
=======
    private String studentId;
    private String name;
    private String programme;
    private double marks;

    public Student(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getProgramme() {
        return programme;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void displayStudent() {
        System.out.println(
            "Student ID: " + studentId +
            " | Name: " + name +
            " | Programme: " + programme +
            " | Marks: " + marks
        );
    }
>>>>>>> 01790ad299837c3751973b027e1c838c90c2f843
}
