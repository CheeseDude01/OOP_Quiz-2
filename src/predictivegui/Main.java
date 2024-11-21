package predictivegui;

import predictive.DictionaryTreeImpl;

public class Main {
    public static void main(String[] args) {
        DictionaryTreeImpl dictionary = new DictionaryTreeImpl();
        Model model = new Model(dictionary);
        View view = new View(model);
        Controller controller = new Controller(model, view);

        controller.start();
    }
}
