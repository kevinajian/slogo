package slogoGame;

import jgame.*;
import jgame.platform.JGEngine;

public class Turtle extends JGObject implements Constants{
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
	@Override
	public void setPos(double x, double y){
		this.x = x + DEFAULT_WIDTH/2 - DEFAULT_IMAGE_WIDTH/2;
		this.y = y + DEFAULT_HEIGHT/2 - DEFAULT_IMAGE_HEIGHT/2;
	}
}