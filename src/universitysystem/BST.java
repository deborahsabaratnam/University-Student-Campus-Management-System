package src.universitysystem;

public class BST {

    private static class BSTNode {
        private Student student;
        private BSTNode left;
        private BSTNode right;

        BSTNode(Student student) {
            this.student = student;
        }
    }

    private BSTNode root;

    public void insert(Student student) {
        String studentId = getStudentId(student);

        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Invalid Student ID.");
            return;
        }

        if (search(studentId) != null) {
            System.out.println("Error: Student ID already exists in BST.");
            return;
        }

        root = insertRecursive(root, student);
        System.out.println("Student added to BST successfully.");
    }

    private BSTNode insertRecursive(BSTNode node, Student student) {
        if (node == null) {
            return new BSTNode(student);
        }

        String studentId = getStudentId(student);
        int comparison = studentId.compareTo(getStudentId(node.student));

        if (comparison < 0) {
            node.left = insertRecursive(node.left, student);
        } else if (comparison > 0) {
            node.right = insertRecursive(node.right, student);
        }

        return node;
    }

    public Student search(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return null;
        }

        BSTNode current = root;

        while (current != null) {
            int comparison = studentId.compareTo(getStudentId(current.student));

            if (comparison == 0) {
                return current.student;
            }

            current = comparison < 0 ? current.left : current.right;
        }

        return null;
    }

    public void delete(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Invalid Student ID.");
            return;
        }

        if (search(studentId) == null) {
            System.out.println("Student not found in BST.");
            return;
        }

        root = deleteRecursive(root, studentId);
        System.out.println("Student deleted from BST successfully.");
    }

    private BSTNode deleteRecursive(BSTNode node, String studentId) {
        if (node == null) {
            return null;
        }

        int comparison = studentId.compareTo(getStudentId(node.student));

        if (comparison < 0) {
            node.left = deleteRecursive(node.left, studentId);
        } else if (comparison > 0) {
            node.right = deleteRecursive(node.right, studentId);
        } else {
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            BSTNode successor = findMinimum(node.right);
            node.student = successor.student;
            node.right = deleteRecursive(
                    node.right,
                    getStudentId(successor.student)
            );
        }

        return node;
    }

    private BSTNode findMinimum(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        System.out.println();
        System.out.println("========== BST STUDENT RECORDS ==========");
        inOrder(root);
        System.out.println("==========================================");
    }

    private void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.left);
            node.student.displayStudent();
            inOrder(node.right);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    private String getStudentId(Student student) {
        if (student == null || student.getStudentId() == null) {
            return null;
        }

        return String.valueOf(student.getStudentId());
    }
}