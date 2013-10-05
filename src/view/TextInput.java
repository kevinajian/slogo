package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.ResourceBundle;
import jgame.*;
import org.jbox2d.*;

public class TextInput extends JPanel{
   
    private ResourceBundle myResources;
    private JTextArea myTextArea;
    private static final int FIELD_SIZE = 30;
    private ActionListener myActionListener;
    private JTextField myField;
	/**
* Create an input area for the user ---
* text field for text,
* buttons for starting actions
*/
	public TextInput()
	{
	    myResources = ResourceBundle.getBundle("resources." + "English");
        add(makeTextField());
        add(makeButton());
        add(makeClear());
        myTextArea = new JTextArea();
	}
	   /**
	* Create a button whose action is to clear the display area when pressed.
	*
	* Note, since this class will not ever be used by any other class, make it
	* inline (i.e., as anonymous inner classes) --- saves making a separate
	* file for one line of actual code.
	*/
	    protected JButton makeClear () {
	        JButton result = new JButton(myResources.getString("ClearCommand"));
	        result.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed (ActionEvent e) {
	                myTextArea.setText("");
	            }
	        });
	        return result;
	    }


	    /**
	* Create a standard text field (a single line that responds to enter being
	* pressed as an ActionEvent) that listens for a variety of kinds of events
	*/
	    protected JTextField makeTextField () {
	        myField = new JTextField(FIELD_SIZE);
	        myField.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					myField.setText("");
					
				}
	        	
	        });
	        return myField;
	    }

	    /**
	* Create a standard button (a rectangular area that responds to mouse
	* press and release within its bounds) that listens for a variety of kinds
	* of events
	*/
	    protected JButton makeButton () {
	        JButton result = new JButton(myResources.getString("ActionCommand"));
	        result.addActionListener(myActionListener);
	        return result;
	    }
}
