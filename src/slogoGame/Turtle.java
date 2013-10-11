package slogoGame;

import jgame.*;
import jgame.platform.JGEngine;

public class Turtle extends JGObject{
	private JGEngine myEngine;
	private String myImage;
	private String myName;
	private boolean amCustom;
	public Turtle(String name, int collisionid, JGEngine tgame) {
		super(name, false, tgame.getWidth(), tgame.getHeight(), collisionid, null);
		myEngine = tgame;
		myName = "turtle";
		myImage = myName+0;
		amCustom = false;
	}
	public void paint()
	{
		myEngine.drawImage(x, y, myImage);
	}
	public void rotate(double degree){
		if(amCustom)
			return;
		degree = degree/45;
		degree = Math.floor(degree);
		myImage = myName+(int)degree;
	}
	public void changeImage(String name){
		myName = name;
		myImage = name;
		amCustom = true;
	}
	public void restoreDefaultImage(){
		myName = "turtle";
		myImage = myName+0;
		amCustom = false;
	}
}