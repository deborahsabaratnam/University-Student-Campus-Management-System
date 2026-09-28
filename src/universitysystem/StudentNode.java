package universitysystem;

public class StudentNode {

    Student data;
    StudentNode left;
    StudentNode right;

    public StudentNode(Student data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
