package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsuranceTest extends TestDriver{

	ChromeDriver driver = getDriver();
	
	@Test
	public void testAddInsurrance() throws InterruptedException{
		driver.get("http://localhost:8080/bao-hiem-y-te/config-insurrance?type=list");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[1]/div/div/div/a/span/i")).click();
		WebElement typeLevel = driver.findElement(By.name("typeLevel"));
		typeLevel.sendKeys("Mức 6");
		Thread.sleep(1000);
		WebElement price = driver.findElement(By.name("price"));
		price.sendKeys("198000");
		Thread.sleep(1000);
		WebElement description = driver.findElement(By.name("description"));
		description.sendKeys("Mức đóng từ người thứ 6 trở đi trong gia đình");
		Thread.sleep(1000);
		driver.findElement(By.id("btnAddOrUpdateNew")).click();
		String expected = "Insert success!!!";
		String message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div")).getText();
		assertEquals(message, expected);
		driver.close();
	}
	
	@Test
	public void testUpdateInsurrance() throws InterruptedException{
		driver.get("http://localhost:8080/bao-hiem-y-te/config-insurrance?type=list");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr[6]/td[4]/a/i")).click();
		Thread.sleep(1000);
		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("200000");
		Thread.sleep(1000);
		driver.findElement(By.id("btnAddOrUpdateNew")).click();
		String expected = "Update success!!!";
		String message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div")).getText();
		assertEquals(message, expected);
		driver.close();
	}
	
	@Test
	public void testDeleteInsurrance() throws InterruptedException{
		driver.get("http://localhost:8080/bao-hiem-y-te/config-insurrance?type=list");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[6]/td[5]/a/i")).click();
		Thread.sleep(2000);
		String expected = "Delete success!!!";
		String message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[2]/div/div[1]")).getText();
		assertEquals(message, expected);
		driver.close();
	}
}
