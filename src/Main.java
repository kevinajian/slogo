import java.util.HashMap;
import java.util.Map;

import parser.Parser;
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
		Model model = new Model(1);
		Map<Integer, Model> models = new HashMap<Integer, Model>();
		models.put(model.getId(), model);
		Parser parser = new Parser(models);
		Controller controller = new Controller(view, parser);
		view.setController(controller);
		controller.initiate();
	}
}
