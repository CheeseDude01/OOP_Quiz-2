package predictivegui;

// Controller class as the mediator between model and view classes
public class Controller {
    private View view;
    
    public Controller(View view) {
        this.view = view;
    }
    
    // Initialize the view
    public void initView(String title) {
        view.init(title);
    }
}
