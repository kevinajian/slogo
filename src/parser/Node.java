package parser;

import commands.Command;

public class Node {
	
	public Command getMyCommand() {
		return myCommand;
	}

	public void setMyCommand(Command myCommand) {
		this.myCommand = myCommand;
	}

	Command myCommand;
	Node myLeftChild;
	Node myRightChild;
	Node myParent;
	double myValue;
	
	public Node(Command command, Node leftChild, Node rightChild, Node parent, double value){
		this.myCommand = command;
		this.myLeftChild = leftChild;
		this.myRightChild = rightChild;
		this.myParent = parent;
		this.myValue = value;
	}
	
}
