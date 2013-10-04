import controller.Controller;
import model.Model;


public class Main {
	
	public static void main(String[]args){
		//View
		Model model = new Model();
		Controller controller = new Controller(view, model);
	}
	
}
