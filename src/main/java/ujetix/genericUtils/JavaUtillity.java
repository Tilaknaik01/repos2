package ujetix.genericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtillity
{
	/**
	 * 
	 * to get the random number 
	 * @param index
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int randomnumber = random.nextInt(2000);
		return randomnumber;
	}
	
	/**
	 * 
	 * to get the date in the required format
	 * @return
	 */
	public String currentSystemDateInFormat()
	{
		Date d1 = new Date();
		String d2 = d1.toString();
		String[] d = d2.split(" ");
		String dte = d[2];
		String week = d[0];
		String month = d[1];
		String year = d[5];
		String date = month+" "+week+" "+dte+" "+year;
		return date;
	}
	
	/**
	 * @return 
	 * 
	 * to get the current date
	 */
	public String currentSystemDate()
	{
		Date d1 = new Date();
		String d2 = d1.toString();
		return d2;
	}
}














