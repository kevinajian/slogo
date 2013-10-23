package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;

public class MouseFocus extends MouseAdapter {
	private JMenu myMenu;

	public MouseFocus(JMenu menu) {
		myMenu = menu;
	}

	public void mousePressed(MouseEvent me) { 
		myMenu.revalidate();
	}

}
