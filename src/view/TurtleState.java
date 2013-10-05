package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TurtleState extends JScrollPane{
    private ActionListener myActionListener;
    private JTextArea myTextArea;
	public TurtleState(JTextArea text)
	{
		super(text);
		myTextArea = text;
	}

	
}
