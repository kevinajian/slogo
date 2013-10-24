package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;
import slogoGame.TurtleGame;
import controller.Controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import jgame.*;
import jgame.platform.JGEngine;

@SuppressWarnings("serial")
public class View extends JFrame{
	
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    private static final String USER_DIR = "user.dir";
    private ResourceBundle myResources;
    private TextInput myTextInput;
    private TurtleGame myTurtleGame;
	private Controller myController;
    private JFileChooser myChooser;
    private TurtleState myInfo;
	private JGEngine myEngine;

    public TurtleGame getMyTurtleGame() {
		return myTurtleGame;
	}

	public void setMyTurtleGame(TurtleGame myTurtleGame) {
		this.myTurtleGame = myTurtleGame;
	}

    public View ()
    {
        setTitle("Turtle View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        myTurtleGame = new TurtleGame(new JGPoint(800,600));
        myTurtleGame.setView(this);
		JTextArea myDoneCommands = new JTextArea(18,18);
		JTextArea myOutput = new JTextArea(18,18);
		
        myInfo = new TurtleState(new JScrollPane(myDoneCommands),new JScrollPane(myOutput), this, myDoneCommands, myOutput);
        myTextInput = new TextInput(this, myInfo);
        getContentPane().add(myInfo, BorderLayout.EAST);
        getContentPane().add(myTextInput, BorderLayout.SOUTH);
        getContentPane().add(myTurtleGame, BorderLayout.CENTER);
        setJMenuBar(makeMenus());
        pack();
        setVisible(true);
    }
    
    private JMenuBar makeMenus() {
        JMenuBar result = new JMenuBar();
        result.add(makeFileMenu());
        result.add(makeHelpMenu());
        result.add(new BackgroundMenu(myResources.getString("BackgroundMenu"), myTurtleGame));
        result.add(new PenColorMenu(myResources.getString("PenMenu"), myTurtleGame));
        result.add(new GridMenu(myResources.getString("GridMenu"), myTurtleGame));
        result.add(new TurtleMenu(myResources.getString("TurtleMenu"), myTurtleGame));
        result.add(new WorkspaceMenu(myResources.getString("WorkspaceMenu"), myTurtleGame));
        result.add(new TurtleToggleMenu(myResources.getString("BorderMenu"), myTurtleGame));
        return result;
	}
    
    private JMenu makeHelpMenu() {
		JMenu result = new JMenu(myResources.getString("HelpMenu"));
        result.add(new AbstractAction(myResources.getString("HelpCommand")) {
            public void actionPerformed (ActionEvent e) {
            	String helpPage = "http://www.cs.duke.edu/courses/fall13/compsci308/assign/03_slogo/commands.php";
            	URI myNewLocation = null;
            	java.awt.Desktop myNewBrowserDesktop = java.awt.Desktop.getDesktop();
            	try {
					myNewLocation = new java.net.URI(helpPage);
				} catch (URISyntaxException e1) {
					helpPage = "www.google.com";
				}
				try {
					myNewBrowserDesktop.browse(myNewLocation);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });

        JMenu helpLanguages = new JMenu(myResources.getString("HelpLanguages"));
        
//        ArrayList<String> langList = new ArrayList<String>();
//        langList.add("HelpEnglish");
//        langList.add("HelpSpanish");
//        langList.add("HelpPortuguese");
//        
//        for(String language : langList){
//        	//helpLanguages.add(new JMenuItem(myResources.getString(language)));
//            helpLanguages.add(new AbstractAction(myResources.getString(language)) {
//    			@Override
//    			public void actionPerformed(ActionEvent e) {
//    				myController.getMyModel().setMyLanguage("src/parser/" + myResources.getString(language) + ".properties");
//    			}
//            	
//            	
//            });
//        }
//        
//        
//        JMenuItem helpEnglish = new JMenuItem(myResources.getString("HelpEnglish"));
//        JMenuItem helpSpanish = new JMenuItem(myResources.getString("HelpSpanish"));
//        JMenuItem helpPortuguese = new JMenuItem(myResources.getString("HelpPortuguese"));
//        helpLanguages.add(helpEnglish);
//        helpLanguages.add(helpSpanish);
//        helpLanguages.add(helpPortuguese);

        helpLanguages.add(new AbstractAction(myResources.getString("HelpEnglish")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				myController.getModelController().setLanguage("src/parser/" + myResources.getString("HelpEnglish") + ".properties");
			}
        });
        helpLanguages.add(new AbstractAction(myResources.getString("HelpSpanish")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				myController.getModelController().setLanguage("src/parser/" + myResources.getString("HelpSpanish") + ".properties");
			}	
        });
        helpLanguages.add(new AbstractAction(myResources.getString("HelpPortuguese")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				myController.getModelController().setLanguage("src/parser/" + myResources.getString("HelpSpanish") + ".properties");
			}
        });
        result.add(helpLanguages);
        result.addMouseListener(new MouseFocus(result));
		return result;	
	}

	protected JMenu makeFileMenu () {
        JMenu result = new JMenu(myResources.getString("FileMenu"));
        result.add(new AbstractAction(myResources.getString("SaveMenu")) {
            public void actionPerformed(ActionEvent e) 
            {
            	ArrayList<String> myList = myTurtleGame.getStringArray();
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("src/"));
                int retrival = chooser.showSaveDialog(null);
                if (retrival == JFileChooser.APPROVE_OPTION) {
                    try {
                        FileOutputStream fout = new FileOutputStream(chooser.getSelectedFile()+".txt");
                        ObjectOutputStream oos = new ObjectOutputStream(fout);
                        oos.writeObject(myList);
                        oos.close();
                        fout.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }   
        });
        result.add(new AbstractAction(myResources.getString("OpenCommand")) {
            public void actionPerformed (ActionEvent e) {
            	JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("src/"));
                int retrival = chooser.showSaveDialog(null);
                if (retrival == JFileChooser.APPROVE_OPTION) {
                    try {
                        myTurtleGame.setPreferences(chooser.getSelectedFile()+"");
                    }
                    catch (Exception err){
                    	
                    }
                }
            	//THIS WAS ISSUE WITH SERIALIZATION AND STRANGE VOLATILEIMAGE ERROR
                /*try {
                    int response = myChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) 
                    {
                        new FileReader(myChooser.getSelectedFile());
                        System.out.println("unserializing list");
                        try {
                            FileInputStream fin = new FileInputStream("list.txt");
                            ObjectInputStream ois = new ObjectInputStream(fin);
                            ArrayList<Action> list = (ArrayList) ois.readObject();
                            for (Action a : list){
                                System.out.println(a);
                            }
                            ois.close();
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                catch (IOException io) {
                    showError(io.toString());
                }*/    
            }
        });
        result.add(new JSeparator());
        result.add(new AbstractAction(myResources.getString("QuitCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });
        result.addMouseListener(new MouseFocus(result));
        return result;
    }

	public void setController(Controller controller){
    	myController = controller;
    }
    
	public void sendString(String string) throws Exception {
		myController.processInput(string);
	}
	
	public Controller getController(){
		return myController;
	}

    /**
	* Display any string message in a popup error dialog.
	*
	* @param message message to display
	*/
    public void showError (String message) {
    	//System.out.println("WE SHOWIN ERRS UP IN HUR");
        JOptionPane.showMessageDialog(this, message, myResources.getString("ErrorTitle"), JOptionPane.ERROR_MESSAGE);
    }
    
    public void addGameAction(String string){
    	myTurtleGame.makeInputAction(string);
    }

	public void drawTurtle(double[] turtlePosition) {
		myTurtleGame.drawTurtle(turtlePosition);
	}
	
	public void drawLine(double[] currentLine){
		myTurtleGame.drawLine(currentLine);
	}

	public void clearLines() {
		myTurtleGame.clearLines();
	}
	
	public void clearTurtles() {
		myTurtleGame.clearTurtles();
	}
	
	public void clearBoxes() {
		myTurtleGame.clearBoxes();
	}
	
	public void resetModel(){
		myController.resetModels();
	}

	public void display(String input) {  //used for current turtle information only!  variables, user def cmds, etc.
		myInfo.addTurtleStatsText(input);
	}

	public void drawBox(double[] boxPosition) {
		myTurtleGame.drawBox(boxPosition);
	}
	
	public Map<String, String> getCustomCommandMap() {
		return myController.getCustomCommandMap();
	}
}
