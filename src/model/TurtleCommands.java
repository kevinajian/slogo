package model;

public interface TurtleCommands {
	State getCurrentState();
	double getOrientation();
	double getX();
	double getY();
	void addState(State state);
}
