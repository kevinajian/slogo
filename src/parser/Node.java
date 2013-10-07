package parser;

import commands.Command;

public class Node {
	
	public Command getMyCommand() {
		return myCommand;
	}

	public void setMyCommand(Command myCommand) {
		this.myCommand = myCommand;
	}

	public Node getMyLeftChild() {
		return myLeftChild;
	}

	public void setMyLeftChild(Node myLeftChild) {
		this.myLeftChild = myLeftChild;
	}

	public Node getMyRightChild() {
		return myRightChild;
	}

	public void setMyRightChild(Node myRightChild) {
		this.myRightChild = myRightChild;
	}

	Command myCommand;
	Node myLeftChild;
	Node myRightChild;
	
	public Node(Command command, Node leftChild, Node rightChild){
		this.myCommand = command;
		this.myLeftChild = leftChild;
		this.myRightChild = rightChild;
	}
	
}
