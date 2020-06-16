package de.bruxxen.MyGourmet.Controller;

import java.util.Calendar;
import java.util.Date;

public class MyGourmetUtil {
	public static int getAge(Date birthday) {
		if(birthday != null) {
			Calendar birthCal = Calendar.getInstance();
			birthCal.setTime(birthday);
			Calendar today = Calendar.getInstance();
			
			int age = today.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
			if(today.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) age--;
			return age;
		}
		else {
			return 0;
		}
		
	}

}
