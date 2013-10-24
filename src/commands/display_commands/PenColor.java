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
public class PenColor extends SetViewProperties {
	
	PenColor() {
		this.myNumInputs = 0;
	}
	
	@Override
	public double evaluate(Model model) {
		ArrayList<String> colors = handleSet(model);
		String currentColor = model.getPenColor();
		for(int i=0; i < colors.size(); i++){
			if(colors.get(0).equals(currentColor)){
				return i;
			}
		}
		return 0;
	}
}
