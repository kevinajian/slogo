package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

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
    private static final String USER_DIR = "user.dir";
    // this constant should be defined by Java, not me :(
    private ResourceBundle myResources;
    private TextInput myTextInput;
    private TurtleGame myTurtleGame;
    private Controller myController;
    private JFileChooser myChooser;
    
    public View ()
    {
    	//this.setName("Turtle View");
        setTitle("Turtle View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create a single file chooser for the entire example
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        // create and arrange sub-parts of the GUI
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        // create listeners that will respond to events
        // position interface components
        myTextInput = new TextInput(this);
        myTurtleGame = new TurtleGame(new JGPoint(800,600));//
        getContentPane().add(new TurtleState(new JTextArea(35,35)), BorderLayout.EAST);
        getContentPane().add(myTextInput, BorderLayout.SOUTH);
        getContentPane().add(myTurtleGame, BorderLayout.CENTER);
        // create app menus
        setJMenuBar(makeMenus());
        // size and display the GUI
        pack();
        setVisible(true);
    }
    
    private JMenuBar makeMenus() {
        JMenuBar result = new JMenuBar();
        result.add(makeFileMenu());
        result.add(makeHelpMenu());
        result.add(new BackgroundMenu(myResources.getString("BackgroundMenu"), myTurtleGame));
        result.add(new PenColorMenu(myResources.getString("PenMenu"), myTurtleGame));
        result.add(new GridMenu(myResources.getString("GridMenu"), myTurtleGame));
        result.add(new TurtleMenu(myResources.getString("TurtleMenu"), myTurtleGame));
        return result;
	}
    private JMenu makeHelpMenu() {
		JMenu result = new JMenu(myResources.getString("HelpMenu"));
        result.add(new AbstractAction(myResources.getString("HelpCommand")) {
            public void actionPerformed (ActionEvent e) {
            	String helpPage = "http://www.cs.duke.edu/courses/fall13/compsci308/assign/03_slogo/commands.php";
            	URI myNewLocation = null;
            	java.awt.Desktop myNewBrowserDesktop = java.awt.Desktop.getDesktop();
            	try {
					myNewLocation = new java.net.URI(helpPage);
				} catch (URISyntaxException e1) {
					helpPage = "www.google.com";
				}
				try {
					myNewBrowserDesktop.browse(myNewLocation);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		return result;	
	}

	protected JMenu makeFileMenu () {
        JMenu result = new JMenu(myResources.getString("FileMenu"));
        result.add(new AbstractAction(myResources.getString("OpenCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    int response = myChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        new FileReader(myChooser.getSelectedFile());
                    }
                }
                catch (IOException io) {
                    // let user know an error occurred, but keep going
                    showError(io.toString());
                }
            }
        });
        result.add(new JSeparator());
        result.add(new AbstractAction(myResources.getString("QuitCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });
        return result;
    }

	public void setController(Controller controller){
    	myController = controller;
    }
    
	public void sendString(String string) throws Exception {
		myController.processInput(string);
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
