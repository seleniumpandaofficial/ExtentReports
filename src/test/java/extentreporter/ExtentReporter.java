package extentreporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	
	public static ExtentReports generateExtentReport() throws IOException {
	
	//Step 1: Create the Object of ExtentReports Class
	ExtentReports extentReport = new ExtentReports();
	//There are multiple types of Reporters under ExtentReports. Go to https://extentreports.com
	//Docs > Version 5 > Java
	//Getting Started > Reporters
	//ExtentSparkReporter - this is free, so we will use this
	
	//Step 2: Create the object of File class and in the constructor pass the path of the file
	File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreport.html");
	
	//Step 3: Create the Object of ExtentSparkReporter and pass the File reference in the constructor
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
	
	//Step 4: Using the sparkReporter reference we can do lot of configurations
	//         Show the example in the website A Complete Example > online here
	
	 sparkReporter.config().setTheme(Theme.DARK);
	 sparkReporter.config().setReportName("RediffTN Results Report");
	 sparkReporter.config().setDocumentTitle("RediffTNReport");
	 sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	 
	 extentReport.attachReporter(sparkReporter);
	 
	 //Step 5: Let's say you want to display additional information about the Automation Results in the Extent Report
	 //        Create a Demonstration Class and choose main method and System.getProperties().list(System.out);
	 
	 Properties prop = new Properties();
	 FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\config.properties");
	 prop.load(ip);
	 extentReport.setSystemInfo("Application Url", prop.getProperty("url"));
	 extentReport.setSystemInfo("BrowserName", prop.getProperty("browserName"));
	 extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
	 extentReport.setSystemInfo("Operating System", System.getProperty("user.name"));
	 extentReport.setSystemInfo("Operating System", System.getProperty("java.version"));
	 
	 
	 //Step 6 - Return the extentReport
	 return extentReport;
	 
	 //Step 7 - We have to call the method generateExtentReport() and take some action in the MyListener Class

}
}