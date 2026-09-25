package studentmanagement;

public class StudentLinkedList {

    private StudentNode head;

    public StudentLinkedList() {
        head = null;
    }

    public void addStudent(Student student) {

        if (searchStudent(student.getStudentId()) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        StudentNode newNode = new StudentNode(student);

        if (head == null) {
            head = newNode;
        } 
        else {
            StudentNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Student added successfully.");
    }

    public Student searchStudent(String studentId) {

        StudentNode current = head;

        while (current != null) {

            if (current.data.getStudentId().equals(studentId)) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        StudentNode current = head;

        System.out.println();
        System.out.println("========== STUDENT RECORDS ==========");

        while (current != null) {

            current.data.displayStudent();

            current = current.next;
        }

        System.out.println("=====================================");
    }

    public void deleteStudent(String studentId) {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        if (head.data.getStudentId().equals(studentId)) {

            head = head.next;

            System.out.println("Student deleted successfully.");
            return;
        }

        StudentNode current = head;

        while (current.next != null) {

            if (current.next.data.getStudentId().equals(studentId)) {

                current.next = current.next.next;

                System.out.println("Student deleted successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Student not found.");
    }

    public void updateStudent(
            String studentId,
            String name,
            String programme,
            double marks) {

        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        System.out.println("Student updated successfully.");
    }
    
    public boolean isEmpty() {

        return head == null;
    }

    public int countStudents() {

        int count = 0;

        StudentNode current = head;

        while (current != null) {

            count++;

            current = current.next;
        }

        return count;
    }
}
