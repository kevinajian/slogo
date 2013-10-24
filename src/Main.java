import java.util.HashMap;
import java.util.Map;

import parser.Parser;
import controller.Controller;
import model.Constants;
import model.Model;
import model.ModelController;
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
		ModelController mc = new ModelController();
		Controller controller = new Controller(view, mc);
		mc.setController(controller);
		view.setController(controller);
		controller.initiate();
	}
}
