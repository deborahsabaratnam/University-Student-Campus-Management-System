package universitysystem;

public class Stack {
     private Action[] actions;
    private int top;

    public Stack() {
        this(10);
    }

    public Stack(int size) {
        actions = new Action[size];
        top = -1;
    }

    public void push(Action action) {

        if (top == actions.length - 1) {
            System.out.println("Stack is full.");
            return;
        }

        top++;
        actions[top] = action;

        System.out.println("Action added to stack.");
    }

    public Action pop() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return null;
        }

        Action action = actions[top];
        actions[top] = null;
        top--;

        return action;
    }

    public Action peek() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return null;
        }

        return actions[top];
    }

    public void display() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("\n========== RECENT ACTIONS ==========");

        for (int i = top; i >= 0; i--) {
            actions[i].display();
            System.out.println();
        }

        System.out.println("====================================");
    }
}
