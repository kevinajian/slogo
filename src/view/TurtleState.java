package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TurtleState extends JPanel{
    private ActionListener myActionListener;
    private JTextField myField;
	public TurtleState()
	{
		add(makeButton());
		myField = new JTextField();
	}

	private JButton makeButton() {
        JButton result = new JButton();
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                myField.setText("HERE IS WHERE TURTLE STATUS IS DISPLAYED");
            }
        });
        return result;
	}
	
}
