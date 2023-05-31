package ujetix.genericUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class Listener implements ITestListener
{

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result)
	{
		String testname = result.getMethod().getMethodName();
		System.out.println("----Listener is listening----");

		TakesScreenshot t=(TakesScreenshot) BaseClass.sdriver;
		File src = t.getScreenshotAs(OutputType.FILE);
		LocalDateTime localdatetime = LocalDateTime.now();
		String cdate = localdatetime.toString().replace(" ", "_").replace(":", "_");
		File dst = new File("./screenShots"+" "+testname+" "+cdate+".png");
		try 
		{
			FileUtils.copyFile(src, dst);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}





	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}


}
