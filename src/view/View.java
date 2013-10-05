package view;
import java.awt.*;
import javax.swing.*;

import slogoGame.TurtleGame;

import controller.Controller;

import java.util.ResourceBundle;
import jgame.*;

@SuppressWarnings("serial")
public class View extends JFrame{
    // this constant should be defined by Java, not me :(
    // most GUI components will be temporary variables,
    // only store components you need to refer to later
    // get strings from resource file
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    // this constant should be defined by Java, not me :(
    private ResourceBundle myResources;
    private TextInput myTextInput;
    private TurtleGame myTurtleGame;
    private Controller myController;
    
    public View ()
    {
    	//this.setName("Turtle View");
        setTitle("Turtle View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create a single file chooser for the entire example
        // create and arrange sub-parts of the GUI
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        // create listeners that will respond to events
        // position interface components
        myTextInput = new TextInput(this);
        myTurtleGame = new TurtleGame(new JGPoint(1000,750));//
        getContentPane().add(new TurtleState(new JTextArea(35,35)), BorderLayout.EAST);
        getContentPane().add(myTextInput, BorderLayout.SOUTH);
        getContentPane().add(myTurtleGame, BorderLayout.CENTER);
        // create app menus
        // size and display the GUI
        pack();
        setVisible(true);
    }
    
    public void setController(Controller controller){
    	myController = controller;
    }
    
	public void sendString(String string) {
		myController.processString(string);
	}

    /**
* Display any string message in a popup error dialog.
*
* @param message message to display
*/
    public void showError (String message) {
        JOptionPane.showMessageDialog(this, message,
                                      myResources.getString("ErrorTitle"),
                                      JOptionPane.ERROR_MESSAGE);
    }

}
