import controllers.Controller;
import views.Views;

public class App {
    public static void main(String[] args) {
        Views view = new Views();
        Controller controller = new Controller(view);
        controller.start();
    }
}