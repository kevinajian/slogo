package view;
import java.awt.event.*;

import javax.swing.*;

import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class TextInput extends JPanel{
   
    private ResourceBundle myResources;
    private static final int FIELD_SIZE = 100;
    private JTextField myField;
    private View myView;
	/**
* Create an input area for the user ---
* text field for text,
* buttons for starting actions
*/
	public TextInput(View view)
	{
	    myResources = ResourceBundle.getBundle("resources." + "English");
        add(makeTextField());
        add(makeSubmit());
        myView = view;
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
					System.out.println(myField.getText());
					//myView.sendString(myField.getText());
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
	    protected JButton makeSubmit () {
	        JButton result = new JButton(myResources.getString("ActionCommand"));
	        result.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println(myField.getText());
					//myView.sendString(myField.getText());
					myField.setText("");
				}
	        });
	        return result;
	    }
}
