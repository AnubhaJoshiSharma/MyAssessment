package reusableMethods;

import com.relevantcodes.extentreports.ExtentReports;

public class Reports {
	
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path =("./")+"/TestReports/testreport.html";
		extent = new ExtentReports(Path,false);
		return extent;
	}

}
