package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {

	private String driverUrl = "C:\\Users\\Quoc Cuong\\Downloads\\test_selenium\\chromedriver.exe";
	
	public TestDriver(){
		
	}
	
	public ChromeDriver getDriver(){
		System.setProperty("webdriver.chrome.driver", driverUrl);
		return new ChromeDriver();
	}
}
