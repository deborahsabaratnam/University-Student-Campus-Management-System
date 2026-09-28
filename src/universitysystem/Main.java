package universitysystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentLinkedList studentList = new StudentLinkedList();
        Stack actionStack = new Stack();
        Queue serviceQueue = new Queue();
        BST studentBST = new BST();
        HashTable studentHashTable = new HashTable();
        Graph campusGraph = new Graph();

        int choice;

        do {
            System.out.println("\n==============================================");
            System.out.println(" UNIVERSITY STUDENT & CAMPUS MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println("1.  Add Student Record");
            System.out.println("2.  Update Student Record");
            System.out.println("3.  Delete Student Record");
            System.out.println("4.  Display All Student Records");
            System.out.println("5.  Add Service Request");
            System.out.println("6.  Process Next Service Request");
            System.out.println("7.  Display Recent Actions");
            System.out.println("8.  Display Students using BST");
            System.out.println("9.  Search Student using Hashing");
            System.out.println("10. Display Hash Table");
            System.out.println("11. Add Campus Location");
            System.out.println("12. Remove Campus Location");
            System.out.println("13. Add Campus Connection");
            System.out.println("14. Remove Campus Connection");
            System.out.println("15. Display Campus Connections");
            System.out.println("16. Traverse Campus using BFS");
            System.out.println("17. Display All Campus Locations");
            System.out.println("18. Exit");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 18.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ----------------------------------------
                // 1. ADD STUDENT
                // ----------------------------------------
                case 1:

                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine().trim();

                    if (studentId.isEmpty()) {
                        System.out.println("Student ID cannot be empty.");
                        break;
                    }

                    if (studentList.searchStudent(studentId) != null) {
                        System.out.println("Student ID already exists.");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter Programme: ");
                    String programme = scanner.nextLine().trim();

                    System.out.print("Enter Marks: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid marks. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter Marks: ");
                    }

                    double marks = scanner.nextDouble();
                    scanner.nextLine();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    Student student = new Student(
                            studentId,
                            name,
                            programme,
                            marks
                    );

                    studentList.addStudent(student);
                    studentBST.insert(student);
                    studentHashTable.insert(student);

                    actionStack.push(
                            new Action(
                                    "ADD",
                                    "Added student " + studentId
                            )
                    );

                    break;

                // ----------------------------------------
                // 2. UPDATE STUDENT
                // ----------------------------------------
                case 2:

                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine().trim();

                    Student existingStudent = studentList.searchStudent(updateId);

                    if (existingStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine().trim();

                    System.out.print("Enter New Programme: ");
                    String newProgramme = scanner.nextLine().trim();

                    System.out.print("Enter New Marks: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid marks. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter New Marks: ");
                    }

                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();

                    if (newMarks < 0 || newMarks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    studentList.updateStudent(
                            updateId,
                            newName,
                            newProgramme,
                            newMarks
                    );

                    /*
                     * BST and Hash Table contain references to the same
                     * Student object, so the updated values are reflected
                     * there as well.
                     */

                    actionStack.push(
                            new Action(
                                    "UPDATE",
                                    "Updated student " + updateId
                            )
                    );

                    break;

                // ----------------------------------------
                // 3. DELETE STUDENT
                // ----------------------------------------
                case 3:

                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine().trim();

                    if (studentList.searchStudent(deleteId) == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    studentList.deleteStudent(deleteId);
                    studentBST.delete(deleteId);
                    studentHashTable.delete(deleteId);

                    actionStack.push(
                            new Action(
                                    "DELETE",
                                    "Deleted student " + deleteId
                            )
                    );

                    break;

                // ----------------------------------------
                // 4. DISPLAY STUDENTS
                // ----------------------------------------
                case 4:

                    studentList.displayStudents();

                    break;

                // ----------------------------------------
                // 5. ADD SERVICE REQUEST
                // ----------------------------------------
                case 5:

                    System.out.print("Enter Request ID: ");
                    String requestId = scanner.nextLine().trim();

                    System.out.print("Enter Student ID: ");
                    String requestStudentId = scanner.nextLine().trim();

                    if (studentList.searchStudent(requestStudentId) == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter Request Type: ");
                    String requestType = scanner.nextLine().trim();

                    ServiceRequest request = new ServiceRequest(
                            requestId,
                            requestStudentId,
                            requestType
                    );

                    serviceQueue.enqueue(request);

                    break;

                // ----------------------------------------
                // 6. PROCESS SERVICE REQUEST
                // ----------------------------------------
                case 6:

                    ServiceRequest processedRequest = serviceQueue.dequeue();

                    if (processedRequest != null) {
                        System.out.println("Processed service request:");
                        processedRequest.display();

                        actionStack.push(
                                new Action(
                                        "SERVICE REQUEST",
                                        "Processed request "
                                                + processedRequest.getRequestId()
                                )
                        );
                    }

                    break;

                // ----------------------------------------
                // 7. DISPLAY STACK
                // ----------------------------------------
                case 7:

                    actionStack.display();

                    break;

                // ----------------------------------------
                // 8. DISPLAY BST
                // ----------------------------------------
                case 8:

                    studentBST.displayInOrder();

                    break;

                // ----------------------------------------
                // 9. SEARCH HASH TABLE
                // ----------------------------------------
                case 9:

                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine().trim();

                    Student foundStudent = studentHashTable.search(searchId);

                    if (foundStudent != null) {
                        System.out.println("\nStudent found:");
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                // ----------------------------------------
                // 10. DISPLAY HASH TABLE
                // ----------------------------------------
                case 10:

                    studentHashTable.displayHashTable();

                    break;

                // ----------------------------------------
                // 11. ADD CAMPUS LOCATION
                // ----------------------------------------
                case 11:

                    System.out.print("Enter campus location name: ");
                    String newLocation = scanner.nextLine();

                    campusGraph.addLocation(newLocation);

                    break;

                // ----------------------------------------
                // 12. REMOVE CAMPUS LOCATION
                // ----------------------------------------
                case 12:

                    System.out.print("Enter campus location to remove: ");
                    String removeLocation = scanner.nextLine();

                    campusGraph.removeLocation(removeLocation);

                    break;

                // ----------------------------------------
                // 13. ADD CAMPUS CONNECTION
                // ----------------------------------------
                case 13:

                    System.out.print("Enter first location: ");
                    String location1 = scanner.nextLine();

                    System.out.print("Enter second location: ");
                    String location2 = scanner.nextLine();

                    campusGraph.addConnection(
                            location1,
                            location2
                    );

                    break;

                // ----------------------------------------
                // 14. REMOVE CAMPUS CONNECTION
                // ----------------------------------------
                case 14:

                    System.out.print("Enter first location: ");
                    String connectionLocation1 = scanner.nextLine();

                    System.out.print("Enter second location: ");
                    String connectionLocation2 = scanner.nextLine();

                    campusGraph.removeConnection(
                            connectionLocation1,
                            connectionLocation2
                    );

                    break;

                // ----------------------------------------
                // 15. DISPLAY CAMPUS CONNECTIONS
                // ----------------------------------------
                case 15:

                    campusGraph.displayConnections();

                    break;

                // ----------------------------------------
                // 16. BFS
                // ----------------------------------------
                case 16:

                    System.out.print("Enter starting location for BFS: ");
                    String startLocation = scanner.nextLine();

                    campusGraph.bfs(startLocation);

                    break;

                // ----------------------------------------
                // 17. DISPLAY CAMPUS LOCATIONS
                // ----------------------------------------
                case 17:

                    campusGraph.displayLocations();

                    break;

                // ----------------------------------------
                // 18. EXIT
                // ----------------------------------------
                case 18:

                    System.out.println("Exiting system...");
                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please select 1-18."
                    );
            }

        } while (choice != 18);

        scanner.close();
    }
}