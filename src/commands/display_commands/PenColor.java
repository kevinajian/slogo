package commands.display_commands;

import java.util.ArrayList;
import java.util.ResourceBundle;
import model.Model;
import commands.CommandZeroInput;

/**
 * Returns the index of the current pen color.
 * @author carlosreyes
 *
 */
public class PenColor extends CommandZeroInput {
	private ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	
	@Override
	public double evaluate(Model model) {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
		String lumpedColors = myResources.getString("Colors");
		String colors1[] = lumpedColors.split(" ");
		ArrayList<String> colors = new ArrayList<String>();	
		for(int i = 0; i<colors1.length-1;i++){
			colors.add(colors1[i]);
		}
		String currentColor = model.getPenColor();
		for(int i=0; i < colors.size(); i++){
			if(colors.get(0).equals(currentColor)){
				return i;
			}
		}
		return 0;
	}
}
