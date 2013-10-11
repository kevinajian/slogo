import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import model.Model;
import view.View;

/**
 * Program starts here
 * @author Kevin
 */
public class Main {
	
	/**
	 * initializes controller
	 * @param args
	 */
	public static void main(String[]args){
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(view, model);
		view.setController(controller);
	}
}
