package MVC.Model;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void notify(String message) {
        System.out.println("Уведомление для " + name + ": " + message);
    }
}