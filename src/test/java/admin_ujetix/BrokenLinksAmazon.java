package admin_ujetix;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksAmazon
{
	//
	public static void main(String[] args)
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		List<WebElement> all_links = driver.findElements(By.xpath("//a"));
		ArrayList<String> broken_links = new ArrayList<String>();
			for (int i = 0; i < all_links.size(); i++) 
			{
				//class
				String links = all_links.get(i).getAttribute("href");
				int statuscode = 0;
				try 
				{
					
					URL url = new URL(links);
					URLConnection urlconnection = url.openConnection();
					HttpURLConnection httpurlconnection = (HttpURLConnection)urlconnection;
					statuscode = httpurlconnection.getResponseCode();
					if (statuscode>=400) 
					{
						broken_links.add(links+"  "+statuscode);
					}

				}
				catch (Exception e) 
				{
					broken_links.add(links+"  "+statuscode);
				}
							}
		System.out.println(broken_links);
	}
}
