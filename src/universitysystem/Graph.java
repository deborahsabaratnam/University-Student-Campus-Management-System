package universitysystem;

import java.util.*;

public class Graph {

    // Adjacency list:
    // Each location is stored as a key,
    // and its connected locations are stored in a list.
    private Map<String, List<String>> adjacencyList;

    // Constructor
    public Graph() {
        adjacencyList = new LinkedHashMap<>();
    }

    // --------------------------------------------------
    // 1. ADD CAMPUS LOCATION
    // --------------------------------------------------
    public void addLocation(String location) {

        location = location.trim();

        if (location.isEmpty()) {
            System.out.println("Location name cannot be empty.");
            return;
        }

        if (adjacencyList.containsKey(location)) {
            System.out.println("Location already exists: " + location);
            return;
        }

        adjacencyList.put(location, new ArrayList<>());

        System.out.println("Location added successfully: " + location);
    }

    // --------------------------------------------------
    // 2. REMOVE CAMPUS LOCATION
    // --------------------------------------------------
    public void removeLocation(String location) {

        location = location.trim();

        if (!adjacencyList.containsKey(location)) {
            System.out.println("Location not found: " + location);
            return;
        }

        // Remove the location itself
        adjacencyList.remove(location);

        // Remove the location from all other locations'
        // connection lists.
        for (List<String> connections : adjacencyList.values()) {
            connections.remove(location);
        }

        System.out.println("Location removed successfully: " + location);
    }

    // --------------------------------------------------
    // 3. ADD CONNECTION / ROAD
    // --------------------------------------------------
    public void addConnection(String location1, String location2) {

        location1 = location1.trim();
        location2 = location2.trim();

        // Check that both locations exist
        if (!adjacencyList.containsKey(location1)) {
            System.out.println("Location not found: " + location1);
            return;
        }

        if (!adjacencyList.containsKey(location2)) {
            System.out.println("Location not found: " + location2);
            return;
        }

        // A location cannot connect to itself
        if (location1.equalsIgnoreCase(location2)) {
            System.out.println("A location cannot connect to itself.");
            return;
        }

        // Check duplicate connection
        if (adjacencyList.get(location1).contains(location2)) {
            System.out.println("Connection already exists between "
                    + location1 + " and " + location2);
            return;
        }

        // Add connection in both directions
        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);

        System.out.println("Connection added successfully between "
                + location1 + " and " + location2);
    }

    // --------------------------------------------------
    // 4. REMOVE CONNECTION / ROAD
    // --------------------------------------------------
    public void removeConnection(String location1, String location2) {

        location1 = location1.trim();
        location2 = location2.trim();

        if (!adjacencyList.containsKey(location1)) {
            System.out.println("Location not found: " + location1);
            return;
        }

        if (!adjacencyList.containsKey(location2)) {
            System.out.println("Location not found: " + location2);
            return;
        }

        if (!adjacencyList.get(location1).contains(location2)) {
            System.out.println("No connection exists between "
                    + location1 + " and " + location2);
            return;
        }

        // Remove connection from both directions
        adjacencyList.get(location1).remove(location2);
        adjacencyList.get(location2).remove(location1);

        System.out.println("Connection removed successfully between "
                + location1 + " and " + location2);
    }

    // --------------------------------------------------
    // 5. DISPLAY CAMPUS NETWORK
    // --------------------------------------------------
    public void displayConnections() {

        if (adjacencyList.isEmpty()) {
            System.out.println("The campus graph is empty.");
            return;
        }

        System.out.println("\n===== CAMPUS NETWORK =====");

        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {

            String location = entry.getKey();
            List<String> connections = entry.getValue();

            System.out.print(location + " -> ");

            if (connections.isEmpty()) {
                System.out.println("No connections");
            } else {
                System.out.println(String.join(", ", connections));
            }
        }

        System.out.println("==========================");
    }

    // --------------------------------------------------
    // 6. BFS TRAVERSAL
    // --------------------------------------------------
    public void bfs(String startLocation) {

        startLocation = startLocation.trim();

        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Starting location not found: "
                    + startLocation);
            return;
        }

        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        // Start BFS
        visited.add(startLocation);
        queue.add(startLocation);

        System.out.println("\n===== BFS TRAVERSAL =====");

        while (!queue.isEmpty()) {

            String currentLocation = queue.poll();

            System.out.println(currentLocation);

            // Visit all connected locations
            for (String neighbour : adjacencyList.get(currentLocation)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println("=========================");
    }

    // --------------------------------------------------
    // 7. CHECK WHETHER A LOCATION EXISTS
    // --------------------------------------------------
    public boolean containsLocation(String location) {

        if (location == null) {
            return false;
        }

        return adjacencyList.containsKey(location.trim());
    }

    // --------------------------------------------------
    // 8. CHECK WHETHER A CONNECTION EXISTS
    // --------------------------------------------------
    public boolean connectionExists(String location1, String location2) {

        if (location1 == null || location2 == null) {
            return false;
        }

        if (!adjacencyList.containsKey(location1.trim())
                || !adjacencyList.containsKey(location2.trim())) {
            return false;
        }

        return adjacencyList.get(location1.trim())
                .contains(location2.trim());
    }

    // --------------------------------------------------
    // 9. DISPLAY ALL LOCATIONS
    // --------------------------------------------------
    public void displayLocations() {

        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("\n===== CAMPUS LOCATIONS =====");

        for (String location : adjacencyList.keySet()) {
            System.out.println("- " + location);
        }

        System.out.println("============================");
    }
}