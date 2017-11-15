package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import edu.FormDto;

public class ChargeUtil {

	 public static Properties proper = new Properties();
	static{
		try {
			proper.load(Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream("Charge.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProper(String key){
		return proper.getProperty(key);
	}
	
}
