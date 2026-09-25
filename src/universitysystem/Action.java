package universitysystem;

public class Action {
     private String actionType;
    private String description;

    public Action(String actionType, String description) {
        this.actionType = actionType;
        this.description = description;
    }

    public String getActionType() {
        return actionType;
    }

    public String getDescription() {
        return description;
    }

    public void display() {
        System.out.println("Action Type: " + actionType);
        System.out.println("Description: " + description);
    }
}
