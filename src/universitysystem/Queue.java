package universitysystem;

public class Queue {
   private ServiceRequest[] requests;
    private int front;
    private int rear;
    private int size;

    public Queue() {
        this(10);
    }

    public Queue(int capacity) {
        requests = new ServiceRequest[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(ServiceRequest request) {

        if (size == requests.length) {
            System.out.println("Queue is full.");
            return;
        }

        rear = (rear + 1) % requests.length;
        requests[rear] = request;
        size++;

        System.out.println("Service request added to queue.");
    }

    public ServiceRequest dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return null;
        }

        ServiceRequest request = requests[front];
        requests[front] = null;

        front = (front + 1) % requests.length;
        size--;

        return request;
    }

    public ServiceRequest peek() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return null;
        }

        return requests[front];
    }

    public void display() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\n========== SERVICE REQUESTS ==========");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % requests.length;
            requests[index].display();
        }

        System.out.println("======================================");
    } 
}
