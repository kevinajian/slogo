package commands.math;

import model.MathModel;
import commands.Command;
import commands.CommandOneInput;

public abstract class MathOneInput extends CommandOneInput {

	public abstract double evaluate(MathModel model);
}