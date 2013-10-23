package slogoGame;

import jgame.JGColor;
import jgame.impl.*;
import jgame.JGFont;
import jgame.JGObject;
import jgame.JGPoint;
import jgame.platform.JGEngine;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import view.View;

@SuppressWarnings("serial")
public class TurtleGame extends JGEngine implements Constants{
	private JGColor myPenColor;
	//private JGColor myBackgroundColor;
	private Map<String,JGColor> colorMap = new HashMap<String,JGColor>();
	private Turtle squirt;
	public Grid g;
	//private HoldLines lines;
	public boolean toggleGrid;
	private ArrayList<Action> myActionList = new ArrayList<Action>();
	//private DatedAction myCurrentAction;
	private int myActionIndex;
	private View myView;
	private ArrayList<ArrayList<Action>> myWorkspaces = new ArrayList<ArrayList<Action>>();
	private boolean redoing;
	//private ArrayList<Integer> myIndices = new ArrayList<Integer>();
	/*	public TurtleGame() {initEngineApplet();}

	public void initCanvas() { 
		initEngineApplet();
		setCanvasSettings(80,30,16,16,JGColor.blue,JGColor.blue,null); 
	}*/

	public TurtleGame() {initEngine(DEFAULT_WIDTH, DEFAULT_HEIGHT);}

	public void initCanvas() {
		initEngineApplet();
		//setScalingPreferences(1,1,0,0,0,0);   ???
		setCanvasSettings(DEFAULT_WIDTH/DEFAULT_TILE_SIZE,
				DEFAULT_HEIGHT/DEFAULT_TILE_SIZE,DEFAULT_TILE_SIZE,
				DEFAULT_TILE_SIZE,JGColor.blue,JGColor.white,null); 
	}

	public TurtleGame(JGPoint size) {initEngine(size.x,size.y);}

	public void initGame() {
		setFrameRate(45,2);
		setCursor(null);
		defineImages();
		squirt = new Turtle("turtle", 50, this);
		//lines = new HoldLines("lines", 51, this);
		/*		g = new Grid("grid", 69, this);
		toggleGrid = true;*/
		//double[] turtleStart = {0.0,0.0,0.0};
		//myCurrentAction = new DatedAction(turtleStart,squirt);
		myActionIndex = -1;
		redoing = false;
		//myIndices.add(myActionIndex);
		myWorkspaces.add(myActionList);
		colorMap.put("Blue", JGColor.blue);
		colorMap.put("Red", JGColor.red);
		colorMap.put("White", JGColor.white);
		colorMap.put("Black", JGColor.black);		
		setGameState("Title");
	}

	public void setView(View view){
		myView = view;
	}

	public void addInputAction(String string){
		addAction(new ActionInput(this,string));
	}

	public void setTurtleImage(String image){
		if(image.equals("Star")){
			squirt.changeImage("star");
		}
		else{
			JFileChooser myChooser = new JFileChooser(System.getProperties().getProperty("user.dir"));
			try {
				int response = myChooser.showOpenDialog(null);
				if (response == JFileChooser.APPROVE_OPTION) {
					new FileReader(myChooser.getSelectedFile());
				}
			}
			catch (IOException io) {
				System.out.println("exploded -- no file");
			}
		}
	}

	public void setBackground(String color){
		addAction(new ActionBackground(this,color));
	}

	public void setBackgroundColor(String color){
		JGColor colorBG = getJGColor(color);
		if (colorBG == null)
			return;
		setBGColor(colorBG);
		setBGImage(null);
	}

	public void setGrid(Boolean gridOn){
		addAction(new ActionGrid(this,gridOn));
	}

	public void toggleGrid(Boolean gridOn){
		g.toggle(gridOn);
		//System.out.println("grid toggled");
	}

	public void setPenColor(String color){
		addAction(new ActionPen(this,color));
	}

	public void setPen(String color){
		JGColor colorBG = getJGColor(color);
		if (colorBG == null)
			return;
		myPenColor = colorBG;
	}

	public JGColor getPenColor(){
		return myPenColor;
	}

	private double myPenSize;

	public void setPenSize(double size){
		this.myPenSize = size;
	}
	public double getPenSize() {
		return myPenSize;
	}

	private JGColor getJGColor(String color){
		if (colorMap.containsKey(color)){
			return colorMap.get(color);
		}
		else {
			new JColorChooser();
			Color myColor = JColorChooser.showDialog(this, "Background Color", new Color(0));
			if (myColor == null)
				return null;
			return new JGColor(myColor.getRed(), myColor.getGreen(), myColor.getBlue());
		}
	}

	public void defineImages(){
		for (int i=0; i < 36; i++) {
			defineImage("turtle"+i, "-",0,"../resources/turtle"+i+".png","-");
		}
		defineImage("star","-",0,"../resources/Star.png","-");
	}

	public void startTitle() {
		//removeObjects(null,0);
		g = new Grid("grid", 69, this);
		//toggleGrid = true;
	}

	public void paintFrameTitle() {
		//squirt.paint();
		/*		if (toggleGrid)
			g.paint();*/
	}


	public void doFrameTitle() {
		if (getKey(' ')){
			clearKey(' ');
			undo();
		}
		if (getKey('D')){
			clearKey('D');
		}
		if (getMouseButton(1)) {
			//System.out.println(this.countObjects("turtle", 50));
			//onClickAction();
		}
	}

	private void undo(){
		restoreDefaults();
		redoing = true;
		for(int i = 0; i < myActionIndex; i++){
			myActionList.get(i).redo();
		}
		redoing = false;
		if (myActionIndex > -1)
			myActionIndex--;	
	}

	private void onClickAction() {
		clearMouseButton(1);

		int mouseX = getMouseX() - pfWidth()/2;
		int mouseY = -(getMouseY() - pfHeight()/2);

		try {
			sendString("OnClick" + " " +  mouseX + " " + mouseY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void drawTurtle(double[] turtlePosition){
		//addAction(new ActionDrawTurtle(this,turtlePosition));
		drawTurtleActually(turtlePosition);
	}

	public void drawTurtleActually(double[] turtlePosition){
		//squirt.setPos(turtlePosition[0],turtlePosition[1]);
		//squirt.rotate(turtlePosition[2]);
		Turtle newTurts = new Turtle("turtle", 50, this);				
		newTurts.setPos(turtlePosition[0], turtlePosition[1]);
		newTurts.rotate(turtlePosition[2]);
	}

	public void drawLine(double[] currentLine){
		new Line(currentLine[0],currentLine[1],currentLine[2],currentLine[3],this);

	}

	public void sendString(String input) throws Exception{
		myView.sendString(input);
	}

	private void cleanActionList(){
		//System.out.println("boop");
		while (myActionList.size() > myActionIndex + 1)
			myActionList.remove(myActionIndex + 1); 
	}

	private void addAction(Action action){
		if (!redoing){
			cleanActionList();
			myActionList.add(action);
			myActionIndex++;
		}
		action.redo();
	}

	public void clearLines(){
		removeObjects("line",0);
	}

	public void clearTurtles(){
		removeObjects("turtle", 0);
	}

	private void restoreDefaults(){
		try {
			myView.resetModel();
		} catch (Exception e) {
		}
		clearLines();
		clearTurtles();
		squirt = new Turtle("turtle",50,this);
		setBackgroundColor("White");
		toggleGrid(true);
		setPen("Black");		
	}

	public void setWorkspace(int index){
		restoreDefaults();
		cleanActionList();
		//System.out.println("pre switch size: " + myActionList.size());
		if (myWorkspaces.size() > index){
			myActionList = myWorkspaces.get(index);
		}
		else {
			myActionList = new ArrayList<Action>();
			myWorkspaces.add(myActionList);
		}
		//System.out.println("post switch size: " + myActionList.size());
		myActionIndex = myActionList.size() - 1;
		redoing = true;
		for (Action action : myActionList){
			action.redo();
		}
		redoing = false;
	}

	public ArrayList<Action> getActionList()
	{
		return myActionList;
	}
}
