package universitysystem;

public class StudentLinkedList {

    private StudentNode head;

    // Constructor
    public StudentLinkedList() {
        head = null;
    }

    // Add a student to the end of the linked list
    public void addStudent(Student student) {
        StudentNode newNode = new StudentNode(student);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
    }

    // Display all students
    public void displayStudents() {
        if (head == null) {
            System.out.println("No students found.");
            return;
        }

        StudentNode current = head;

        while (current != null) {
            System.out.println(current.getStudent());
            current = current.getNext();
        }
    }

    // Search for a student by ID
    public Student searchStudent(String studentId) {
        StudentNode current = head;

        while (current != null) {

            if (current.getStudent().getStudentId().equals(studentId)) {
                return current.getStudent();
            }

            current = current.getNext();
        }

        return null;
    }

    // Delete a student by ID
    public boolean deleteStudent(String studentId) {

        if (head == null) {
            return false;
        }

        // If the student is the first node
        if (head.getStudent().getStudentId().equals(studentId)) {
            head = head.getNext();
            return true;
        }

        StudentNode current = head;

        while (current.getNext() != null) {

            if (current.getNext().getStudent().getStudentId().equals(studentId)) {
                current.setNext(current.getNext().getNext());
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    // Count the number of students
    public int size() {
        int count = 0;
        StudentNode current = head;

        while (current != null) {
            count++;
            current = current.getNext();
        }

        return count;
    }
}