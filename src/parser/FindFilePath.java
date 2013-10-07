package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FindFilePath {
	static private List<String> pathStringList = new ArrayList<String>();

	
	private String myInputString;
	
	public String getMyInputString() {
		return myInputString;
	}

	public void setMyInputString(String myInputString) {
		this.myInputString = myInputString;
	}

	public FindFilePath(String inputString) {
		this.myInputString = inputString;
	}
	
	public String makePath() {
		File currentDir = new File(System.getProperty("user.dir")+"/src/commands"); // current directory
		String classType = myInputString;
		displayDirectoryContents(currentDir, classType);
		System.out.println(findStringAndCut());
		return findStringAndCut();
		
	}
	
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
	
	public static String findStringAndCut() {
		String rawPath = null; 
		for (int i=0; i < pathStringList.size(); i++) {
			if(pathStringList.get(i).contains("Forward.java")){
				rawPath = pathStringList.get(i);
				rawPath = rawPath.replaceAll(Pattern.quote("/"),".");
				rawPath = rawPath.replaceAll(Pattern.quote(".java"), "");
				rawPath = rawPath.replaceAll(Pattern.quote("*.src"), "");
			    rawPath = rawPath.substring(rawPath.lastIndexOf("src.") + 4);
				return rawPath;
			}
		}
		return rawPath;

	}
}