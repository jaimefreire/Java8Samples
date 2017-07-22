package snippets.streams.clients;

public class Client {

    static double budget;
    String name, project;

    public Client(String n, String pr, double p) {
        budget = p;
        name = n;
        project = pr;
    }

    public static double getBudget() {
        return budget;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + "," + budget;
    }
}