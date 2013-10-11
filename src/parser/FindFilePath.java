package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Finds the file path given a string name of a class, nessesary
 * to instantiate a class from a string as class instantiation
 * requires the full package path name.
 * @author carlosreyes
 *
 */
public class FindFilePath {
	static private List<String> pathStringList = new ArrayList<String>();
	
	private String myInputString;
	
	public String getMyInputString() {
		return myInputString;
	}

	public FindFilePath(String inputString) {
		this.myInputString = inputString;
	}
	
	/**
	 * Calls all of the methods in this class.
	 * @return The path of the Class in a String
	 */
	public String makePath() {
		File currentDir = new File(System.getProperty("user.dir")+"/src/commands"); // current directory
		String classType = myInputString;
		displayDirectoryContents(currentDir, classType);
		return findStringAndCut();
		
	}
	
	/**
	 * Recursive function to search all possible directory paths.
	 * @param dir, the directory to be searched
	 * @param classType, the name of the class being searched for
	 */
	public void displayDirectoryContents(File dir, String classType) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					
					pathStringList.add(file.getCanonicalPath());
					displayDirectoryContents(file, classType);
				} else {
					pathStringList.add(file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Take all of the possible paths found.
	 * @return Formatted String representing the package path
	 */
	public String findStringAndCut() {
		String rawPath = null; 
		for (int i=0; i < pathStringList.size(); i++) {
			if(pathStringList.get(i).contains(myInputString)){
				rawPath = pathStringList.get(i);
				rawPath = rawPath.replaceAll( Pattern.quote("\\"), "." );
				rawPath = rawPath.replaceAll( Pattern.quote("/"), "." );
				rawPath = rawPath.replaceAll(Pattern.quote(".java"), "");
				rawPath = rawPath.replaceAll(Pattern.quote("*.src"), "");
			    rawPath = rawPath.substring(rawPath.lastIndexOf("src.") + 4);
				return rawPath;
			}
		}
		return rawPath;

	}
}