package predictivegui;

// Main class of predictive text
public class Main {
    public static void main(String[] args) {
        // Create new view and controller instance
        View view = new View();
        Controller controller = new Controller(view);
        
        // Initialize the view using the controller class
        controller.initView("Predictive Text");
    }
}
