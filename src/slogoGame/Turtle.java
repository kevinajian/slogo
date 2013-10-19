package slogoGame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jgame.*;
import jgame.platform.JGEngine;

public class Turtle extends JGObject implements Constants{
	private JGEngine myEngine;
	private String myImage;
	private String myName;
	private boolean amCustom;
	public Turtle(String name, int collisionid, JGEngine tgame) {
		super(name, false, 0, 0, collisionid, null);
		myEngine = tgame;
		myName = "turtle";
		myImage = myName+0;
		amCustom = false;
	}
	
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private double thickness = 5;

	public void paint()
	{
		myEngine.drawLine(x1, y1, x2, y2, thickness, JGColor.black);
		myEngine.drawImage(x, y, myImage);
	}
	public void rotate(double degree){
		if(amCustom)
			return;
		degree = Math.floor(degree/10);
		myImage = myName+ (int)degree;
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
		int width;
		int height;
		BufferedImage bimg = null;
		try {
			bimg = ImageIO.read(new File("src/resources/turtle0.png"));
			width = bimg.getWidth();
			height = bimg.getHeight();
		} catch (IOException e) {
			width = DEFAULT_IMAGE_WIDTH2;
			height = DEFAULT_IMAGE_HEIGHT2;
			
		}			
		this.x = x + DEFAULT_WIDTH/2 - width/2;
		this.y = -y + DEFAULT_HEIGHT/2 - height/2;
	}
	
	public void drawPath(double[] currentLine) {
		x1 = pfwidth/2 + currentLine[0];
		y1 = pfheight/2 + -currentLine[1];
		x2 = pfwidth/2 + currentLine[2];
		y2 = pfheight/2 + -currentLine[3];
	}
}