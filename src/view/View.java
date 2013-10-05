package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.ResourceBundle;
import jgame.*;
import org.jbox2d.*;
public class View extends JFrame{
    // this constant should be defined by Java, not me :(
    private static final int FIELD_SIZE = 30;
    // most GUI components will be temporary variables,
    // only store components you need to refer to later
    private JTextArea myTextArea;
    // get strings from resource file
    private ActionListener myActionListener;
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    // this constant should be defined by Java, not me :(
    private static final String USER_DIR = "user.dir";
    private ResourceBundle myResources;
    private TextInput myTextInput;
    
    public View ()
    {
        setTitle("Turtle View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create a single file chooser for the entire example
        // create and arrange sub-parts of the GUI
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        // create listeners that will respond to events
        makeListeners();
        // position interface components
        myTextInput = new TextInput();
        getContentPane().add(myTextInput, BorderLayout.SOUTH);
        getContentPane().add(makeDisplay(), BorderLayout.CENTER);
        // create app menus
        setJMenuBar(makeMenus());
        // size and display the GUI
        pack();
        setVisible(true);
    }
    
	public String getInputString() {
		// TODO Auto-generated method stub
		return "";
	}
    public void showMessage (String message) {
        myTextArea.append(message + "\n");
        myTextArea.setCaretPosition(myTextArea.getText().length());
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

    /**
* Create all the listeners so they can be later assigned to specific
* components.
*
* Note, since these classes will not ever be used by any other class, make
* them inline (i.e., as anonymous inner classes) --- saves making a
* separate file for one line of actual code.
*/
    protected void makeListeners () {
        // listener for "high-level" events, i.e., those made
        // up of a sequence of low-level events, like a button
        // press (mouse down and up within a button object)
        myActionListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                echo("action", e);
            }
        };
    }

    /**
* Create a menu to appear at the top of the frame,
* usually File, Edit, App Specific Actions, Help
*/
    protected JMenuBar makeMenus () {
        JMenuBar result = new JMenuBar();
        return result;
    }



	   /**
	* Create a display area for showing out to the user, since it may display
	* lots of text, make it automatically scroll when needed
	*/
	    protected JComponent makeDisplay () {
	        // create with size in rows and columns
	        myTextArea = new JTextArea(FIELD_SIZE, FIELD_SIZE);
	        return new JScrollPane(myTextArea);
	    }


 
    /**
* Echo key presses by showing important attributes
*/
    private void echo (String s, KeyEvent e) {
        showMessage(s + " char:" + e.getKeyChar() + " mod: " +
                    KeyEvent.getKeyModifiersText(e.getModifiers()) + " mod: " +
                    KeyEvent.getKeyText(e.getKeyCode()));
    }

    /**
* Echo action events including time event occurs
*/
    private void echo (String s, ActionEvent e) {
        showMessage(s + " = " + e.getActionCommand() + " " + e.getWhen());
    }

    /**
* Echo mouse events (enter, leave, etc., including position and buttons)
*/
    private void echo (String s, MouseEvent e) {
        showMessage(s + " x = " + e.getX() + " y = " + e.getY() + " mod: " +
                    MouseEvent.getMouseModifiersText(e.getModifiers()) + " button: " +
                    e.getButton() + " clicks " + e.getClickCount());
    }

    /**
* Echo other events (e.g., Focus)
*/
    private void echo (String s, AWTEvent e) {
        showMessage(s + " " + e);
    }

    /**
* Echo data read from reader to display
*/
    private void echo (Reader r) {
        try {
            String s = "";
            BufferedReader input = new BufferedReader(r);
            String line = input.readLine();
            while (line != null) {
                s += line + "\n";
                line = input.readLine();
            }
            showMessage(s);
        }
        catch (IOException e) {
            showError(e.toString());
        }
    }

    /**
* Echo display to writer
*/
    private void echo (Writer w) {
        PrintWriter output = new PrintWriter(w);
        output.println(myTextArea.getText());
        output.flush();
        output.close();
    }
}
