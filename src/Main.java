import controller.Controller;
import model.Model;

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
		//View view = new View();
		Model model = new Model();
		Controller controller = new Controller(view, model);
		controller.initiate();
	}
	
}
