package controller;

import model.Model;

/**
 * Command string in happens here, sends this string
 * to the model to be sent to be processed.
 * Controller also receives processed info and then updates
 * the view based on this info.
 * @author carlosreyes kevinjian
 *
 */
public class Controller {
	Model myModel;
	View myView;
	
	public Controller(View view, Model model){
		myView = view;
		myModel=model;
	}
	
	public String viewString() {
		return myView.getInputString();
	}
	
	public State modelCurrentState() {
		return myModel.getCurrentState();
	}
	
	public List<Line> getTrail() {
		return myModel.getTrail();
	}
	
	
}
