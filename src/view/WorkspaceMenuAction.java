package view;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class WorkspaceMenuAction extends AbstractAction {
	private WorkspaceMenu myMenu;

	public WorkspaceMenuAction(WorkspaceMenu menu){
		super(ResourceBundle.getBundle("resources.English").getString("WorkspaceMenuHeader"));
		myMenu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myMenu.addAction();
	}

}
