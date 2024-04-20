package reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
 
	
	public ExtentSparkReporter sparkReporter;
	
	public File file;
	
	public ExtentReports extent;
	
	public ExtentTest extentTest;
	
	public void instantiateReport()
	{
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_hh_mm_ss");
		String timestamp =sdf.format(cal.getTime());
		System.out.println(timestamp);
		if(file == null || extent==null || sparkReporter==null)
		{
		file = new File(System.getProperty("user.dir")+"//reports//"+timestamp+".html");
		sparkReporter = new ExtentSparkReporter(file);
		extent = new ExtentReports();
		}
		sparkReporter = new ExtentSparkReporter(file);
		sparkReporter.config().setDocumentTitle("End To End Testing");
		sparkReporter.config().setReportName("Placing the order");
		
	
		extent.attachReporter(sparkReporter);
		
	}
}
