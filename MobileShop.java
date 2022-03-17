import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Mobile{
    
	HashMap<String, ArrayList<String>> mobiles = new HashMap<String, ArrayList<String>>();

	public String addMobile(String company, String model) {
		if(mobiles.containsKey(company))
			mobiles.get(company).add(model);
		else
			mobiles.put(company, new ArrayList<String>(Collections.nCopies(1, model)));
		return "model successfully added";
	}

	public ArrayList<String> getModels(String company) {
		if (mobiles.containsKey(company) && mobiles.get(company).size()>0)
			return mobiles.get(company);
		else
			return null;
    }

	public String buyMobile(String company, String model) {
		if (mobiles.containsKey(company) && mobiles.get(company).contains(model)) {
			mobiles.get(company).remove(model);
			return "mobile sold successfully";
		} else
			return "item not available";
    }


}
