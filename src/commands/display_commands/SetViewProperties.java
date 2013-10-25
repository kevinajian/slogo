package commands.display_commands;

import java.util.ArrayList;
import java.util.ResourceBundle;

import model.Model;
import commands.CommandOneInput;

/**
 * Takes care of porting arrays generated
 * from properties file to arraylists for more flexibility.
 * @author carlosreyes
 *
 */
public class SetViewProperties extends CommandOneInput {
	protected ResourceBundle myResources;
	protected static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	
	/**
	 * Pulls resource into array, and ports this to arrayList
	 * @param model
	 * @return ArrayList
	 */
	protected ArrayList<String> handleSet(Model model) {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		String resourceArray = myResources.getString("Colors");
		String colors1[] = resourceArray.split(" ");
		ArrayList<String> colors = new ArrayList<String>();
		for(int i = 0; i<colors1.length-1;i++){
			colors.add(colors1[i]);
		}
		return colors;
	}
	
}
