package universitysystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Graph campusGraph = new Graph();

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("   UNIVERSITY CAMPUS ROUTE SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Campus Location");
            System.out.println("2. Remove Campus Location");
            System.out.println("3. Add Campus Connection");
            System.out.println("4. Remove Campus Connection");
            System.out.println("5. Display Campus Connections");
            System.out.println("6. Display Campus Locations");
            System.out.println("7. Traverse Campus using BFS");
            System.out.println("8. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");

            // Validate menu input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 8.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {

                // =========================================
                // 1. ADD CAMPUS LOCATION
                // =========================================
                case 1:
                    System.out.print("Enter campus location name: ");
                    String newLocation = scanner.nextLine();

                    campusGraph.addLocation(newLocation);
                    break;

                // =========================================
                // 2. REMOVE CAMPUS LOCATION
                // =========================================
                case 2:
                    System.out.print("Enter campus location to remove: ");
                    String removeLocation = scanner.nextLine();

                    campusGraph.removeLocation(removeLocation);
                    break;

                // =========================================
                // 3. ADD CAMPUS CONNECTION
                // =========================================
                case 3:
                    System.out.print("Enter first location: ");
                    String location1 = scanner.nextLine();

                    System.out.print("Enter second location: ");
                    String location2 = scanner.nextLine();

                    campusGraph.addConnection(location1, location2);
                    break;

                // =========================================
                // 4. REMOVE CAMPUS CONNECTION
                // =========================================
                case 4:
                    System.out.print("Enter first location: ");
                    String connectionLocation1 = scanner.nextLine();

                    System.out.print("Enter second location: ");
                    String connectionLocation2 = scanner.nextLine();

                    campusGraph.removeConnection(
                            connectionLocation1,
                            connectionLocation2
                    );
                    break;

                // =========================================
                // 5. DISPLAY CAMPUS CONNECTIONS
                // =========================================
                case 5:
                    campusGraph.displayConnections();
                    break;

                // =========================================
                // 6. DISPLAY CAMPUS LOCATIONS
                // =========================================
                case 6:
                    campusGraph.displayLocations();
                    break;

                // =========================================
                // 7. BFS TRAVERSAL
                // =========================================
                case 7:
                    System.out.print("Enter starting location for BFS: ");
                    String startLocation = scanner.nextLine();

                    campusGraph.bfs(startLocation);
                    break;

                // =========================================
                // 8. EXIT
                // =========================================
                case 8:
                    System.out.println("Exiting Campus Route System...");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select a number from 1 to 8."
                    );
            }

        } while (choice != 8);

        scanner.close();
    }
}
