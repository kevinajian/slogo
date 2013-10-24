package slogoGame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jgame.JGObject;
import jgame.platform.JGEngine;

public class HighlightBox extends Turtle{
	private String myName;
	public HighlightBox(String name, int collisionid, JGEngine tgame) {
		super(name, true, 0, 0, collisionid, "border");
		myName = name;
	}
	
	public void setPos(double x, double y){
		int width;
		int height;
		BufferedImage bimg = null;
		try {
			bimg = ImageIO.read(new File("src/resources/border.png"));
			width = bimg.getWidth();
			height = bimg.getHeight();
		} catch (IOException e) {
			width = DEFAULT_IMAGE_WIDTH2;
			height = DEFAULT_IMAGE_HEIGHT2;
			
		}			
		this.x = x + DEFAULT_WIDTH/2 - width/2;
		this.y = -y + DEFAULT_HEIGHT/2 - height/2;
	}
	
	public void toggle(Boolean borderOn)
	{
		if (borderOn){
			this.resume();
		}
		else{
			this.suspend();
		}
	}
}