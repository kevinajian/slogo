package parser;

import java.util.List;
import java.util.ArrayList;

public class Constants {
	public static final List<String> FORWARD_CMD = new ArrayList<String>(){{add("FORWARD"); add("FD");}};
	public static final List<String> BACK_CMD = new ArrayList<String>(){{add("BACK"); add("BK");}};
	public static final List<String> LEFT_CMD = new ArrayList<String>(){{add("LEFT"); add("LT");}};
	public static final List<String> RIGHT_CMD = new ArrayList<String>(){{add("RIGHT"); add("RT");}};
	public static final List<String> SETHEADING_CMD = new ArrayList<String>(){{add("SETHEADING"); add("SETH");}};
	public static final List<String> TOWARDS = new ArrayList<String>(){{add("TOWARDS");}};
	public static final List<String> SET_CMD = new ArrayList<String>(){{add("SETXY"); add("GOTO");}};
	public static final List<String> PENDOWN_CMD = new ArrayList<String>(){{add("PENDOWN"); add("PD");}};
	public static final List<String> PENUP_CMD = new ArrayList<String>(){{add("PENUP"); add("PU");}};
	public static final List<String> SHOWTURTLE_CMD = new ArrayList<String>(){{add("SHOWTURTLE"); add("ST");}};
	public static final List<String> HIDETURTLE_CMD = new String[]{"HIDETURTLE", "FD")}};
	public static final List<String> HOME_CMD = new String[]{"HOME")}};
	public static final List<String> CLEARSCREEN_CMD = new String[]{"CLEARSCREEN", "CS")}};
	public static final List<String> XCOR_QRY = new String[]{"XCOR")}};
	public static final List<String> YCOR_QRY = new String[]{"YCOR")}};
	public static final List<String> HEADING_QRY = new String[]{"HEADING")}};
	public static final List<String> PENDOWN_QRY = new String[]{"PENDOWN?", "PENDOWNP")}};
	public static final List<String> SHOWING_QRY = new String[]{"SHOWING?", "SHOWINGP")}};
	public static final List<String> SUM_OP = new String[]{add("SUM"); add("+");}}; 
	public static final List<String> DIFFERENCE_OP = new String[]{"DIFFERENCE"); add("-");}};
	public static final List<String> PRODUCT = new String[]{"PRODUCT"); add("*");}};
	public static final List<String> QUOTIENT = new String[]{"QUOTIENT"); add("/");}};
	public static final List<String> REMAINDER = new String[]{"REMAINDER"); add("%");}};
	public static final List<String> MINUS = new String[]{"MINUS"); add("~");}};
	public static final List<String> RANDOM = new String[]{"RANDOM")}};
	public static final List<String> SIN_OP = new String[]{"SIN")}};
	public static final List<String> COS_OP = new String[]{"COS")}};
	public static final List<String> TAN_OP = new String[]{"TAN")}};
	public static final List<String> ATAN_OP = new String[]{"ATAN")}};
	public static final List<String> LOG_OP = new String[]{"LOG")}};
	public static final List<String> POW_OP = new String[]{"POW")}};
	public static final List<String> LESS_OP = new String[]{"LESS?", "LESSP")}};
	public static final List<String> GREATER_OP = new String[]{"GREATER?", "GREATERP")}};
	public static final List<String> EQUAL_OP = new String[]{"EQUAL?", "EQUALP")}};
	public static final List<String> NOTEQUAL_OP = new String[]{"NOTEQUAL?", "NOTEQUALP")}};
	public static final List<String> AND_OP = new String[]{"AND")}};
	public static final List<String> OR_OP = new String[]{"OR")}};
	public static final List<String> NOT_OP = new String[]{"NOT")}};
	public static final List<String> MAKE_CMD = new String[]{"MAKE", "SET")}};
	public static final List<String> REPEAT_CMD = new String[]{"REPEAT")}};
	public static final List<String> DOTIMES_CMD = new String[]{"DOTIMES")}};
	public static final List<String> FOR_CMD = new String[]{"FOR")}};
	public static final List<String> IF_CMD = new String[]{"IF")}};
	public static final List<String> IFELSE_CMD = new String[]{"IFELSE")}};
	public static final List<String> TO_CMD = new String[]{"TO")}};
	
	public static final double VARIABLE_DEFAULT = 0;
}