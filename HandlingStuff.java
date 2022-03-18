import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Activity{
  String string1;
  String string2;
  String operator;

  public Activity(String field1, String field2, String operator) {
    this.string1 = field1;
    this.string2 = field2;
    this.operator = operator;
  }

}



public class Source {
  
  public String handleException(Activity a) {
	try {
	    if (a.string1.equals(null) || a.string2.equals(null))
		throw new NullPointerException("Null values found");
	    if (!a.operator.equals("+") && !a.operator.equals("-"))
		throw new Exception(a.operator);
	    return "No Exception Found";
	} catch (NullPointerException npe) {
	    return "Null values found";
	} catch (Exception e) {
	    return a.operator;
	}
    }

    public String doOperation(Activity a) {
	String output = new String();
	switch (a.operator) {
	case "+":
	    output = a.string1+a.string2;
	    break;
	case "-":
		output  = a.string1;
	    output = output.replaceAll(a.string2, "");
	    break;
	default:
	    break;
	}
	return output;
    }
  
	public static void main(String args[] ) throws Exception {
    //Write your own main to check the program...
   
	}
}
