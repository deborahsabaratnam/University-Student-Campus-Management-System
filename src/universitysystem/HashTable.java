package universitysystem;

public class HashTable {

    private static final int TABLE_SIZE = 10;
    private final HashNode[] table;

    private static class HashNode {
        private final Student student;
        private HashNode next;

        HashNode(Student student) {
            this.student = student;
        }
    }

    public HashTable() {
        table = new HashNode[TABLE_SIZE];
    }

    private int hashFunction(String studentId) {
        int hash = 0;

        for (int i = 0; i < studentId.length(); i++) {
            hash = (hash * 31 + studentId.charAt(i)) % TABLE_SIZE;
        }

        return Math.abs(hash);
    }

    private String getStudentId(Student student) {
        if (student == null || student.getStudentId() == null) {
            return null;
        }

        return String.valueOf(student.getStudentId()).trim();
    }

    public void insert(Student student) {
        String studentId = getStudentId(student);

        if (studentId == null || studentId.isEmpty()) {
            System.out.println("Invalid Student ID.");
            return;
        }

        int index = hashFunction(studentId);
        HashNode current = table[index];

        while (current != null) {
            if (studentId.equals(getStudentId(current.student))) {
                System.out.println(
                        "Error: Student ID already exists in Hash Table."
                );
                return;
            }

            current = current.next;
        }

        HashNode newNode = new HashNode(student);
        newNode.next = table[index];
        table[index] = newNode;

        System.out.println("Student added to Hash Table successfully.");
    }

    public Student search(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return null;
        }

        studentId = studentId.trim();
        int index = hashFunction(studentId);
        HashNode current = table[index];

        while (current != null) {
            if (studentId.equals(getStudentId(current.student))) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    public void delete(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Invalid Student ID.");
            return;
        }

        studentId = studentId.trim();
        int index = hashFunction(studentId);
        HashNode current = table[index];
        HashNode previous = null;

        while (current != null) {
            if (studentId.equals(getStudentId(current.student))) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                System.out.println(
                        "Student deleted from Hash Table successfully."
                );
                return;
            }

            previous = current;
            current = current.next;
        }

        System.out.println("Student not found in Hash Table.");
    }

    public void displayHashTable() {
        System.out.println();
        System.out.println("========== HASH TABLE ==========");

        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Index " + i + ": ");

            HashNode current = table[i];

            if (current == null) {
                System.out.println("Empty");
                continue;
            }

            while (current != null) {
                System.out.print(getStudentId(current.student));

                if (current.next != null) {
                    System.out.print(" -> ");
                }

                current = current.next;
            }

            System.out.println();
        }

        System.out.println("================================");
    }
}