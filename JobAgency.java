import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class CompanyJobRepository {

	static String qual[] = { "B.E", "M.S", "PhD"};
	static ArrayList<String> qualification = new ArrayList<String>(Arrays.asList(qual));

	public static String getJobPrediction(int age, String highestQualification) throws NotEligibleException{	
		if(age<19)
			throw new NotEligibleException("You are underage for any job");
		else {
			if(!qualification.contains(highestQualification))
					throw new NotEligibleException("We do not have any job that matches your qualifications");
			else if(age>=21 && highestQualification.equals("B.E"))
				return "We have openings for junior developer";
			else if(age>=26 && !highestQualification.equals("B.E"))
				return "We have openings for senior developer";
			else
				return "Sorry we have no openings for now";
		}
	}

}

public class Source {

	public String searchForJob(int age, String highestQualification) throws NotEligibleException {
		if(age<=0 || age>=200)
			throw new NotEligibleException("The age entered is not typical for a human being");
		return CompanyJobRepository.getJobPrediction(age, highestQualification);
	}

	public static void main(String args[] )  {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	}
}
class NotEligibleException extends Exception {
	public NotEligibleException(String message) {
		super(message);
	}
}
