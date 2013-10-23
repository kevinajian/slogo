package multiple_turtles;

import model.Model;
import commands.Command;

public class AskWith extends Ask {
	private Command myExpression;
	
	public void setExpression(Command c) {
		myExpression = c;
	}
	
	public Command getExpression() {
		return myExpression;
	}
	
	@Override
	public double evaluate(Model m) {
		double ret = 0;
		double result = myExpression.evaluate(m);
		if (result == 1) {
			boolean active = m.getActive();
			m.setActive(true);
			for (int i=0; i<myCommandList.size()-1; i++) {
					ret = myCommandList.get(i).evaluate(m);					
			}
			m.setActive(active);
		}
		return ret;
	}
}
