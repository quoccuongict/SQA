package selenium;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReportTest extends TestDriver{

	ChromeDriver driver = getDriver();

	@Test
	public void testReportMedicalAddress(){
		driver.get("http://localhost:8080/bao-hiem-y-te/report-insurrance?type=medicalAddress&address=");
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("Hà Đông");
		driver.findElement(By.id("btnSearch")).click();
		String expectedQuantity = "3";
		String expectedTotal = "1845980.0 VNĐ";
		String quantity = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[1]/label[2]")).getText();
		String total = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[2]/label[2]")).getText();
		assertEquals(expectedQuantity, quantity);
		assertEquals(expectedTotal, total);
		driver.close();
	}
	
	@Test
	public void testReportMedicalAddressReturnNull(){
		driver.get("http://localhost:8080/bao-hiem-y-te/report-insurrance?type=medicalAddress&address=");
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("Thanh Hóa");
		driver.findElement(By.id("btnSearch")).click();
		String expectedQuantity = "0";
		String expectedTotal = "0.0 VNĐ";
		String quantity = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[1]/label[2]")).getText();
		String total = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[2]/label[2]")).getText();
		assertEquals(expectedQuantity, quantity);
		assertEquals(expectedTotal, total);
		driver.close();
	}
	
	@Test
	public void testReportByMonthReturnNull(){
		driver.get("http://localhost:8080/bao-hiem-y-te/report-insurrance?type=month&month=&year=");
		WebElement month = driver.findElement(By.name("month"));
		month.sendKeys("1");
		WebElement year = driver.findElement(By.name("year"));
		year.sendKeys("2020");
		driver.findElement(By.id("btnSearch")).click();
		String expectedQuantity = "0";
		String expectedTotal = "0.0 VNĐ";
		String quantity = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[1]/label[2]")).getText();
		String total = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[2]/label[2]")).getText();
		assertEquals(expectedQuantity, quantity);
		assertEquals(expectedTotal, total);
		driver.close();
	}
	
	@Test
	public void testReportByMonth(){
		driver.get("http://localhost:8080/bao-hiem-y-te/report-insurrance?type=month&month=&year=");
		WebElement month = driver.findElement(By.name("month"));
		month.sendKeys("1");
		WebElement year = driver.findElement(By.name("year"));
		year.sendKeys("2021");
		driver.findElement(By.id("btnSearch")).click();
		String expectedQuantity = "4";
		String expectedTotal = "2882760.0 VNĐ";
		String quantity = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[1]/label[2]")).getText();
		String total = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[2]/label[2]")).getText();
		assertEquals(expectedQuantity, quantity);
		assertEquals(expectedTotal, total);
		driver.close();
	}
	
	@Test
	public void testReportByYear(){
		driver.get("http://localhost:8080/bao-hiem-y-te/report-insurrance?type=year&year=");
		WebElement year = driver.findElement(By.name("year"));
		year.sendKeys("2021");
		driver.findElement(By.id("btnSearch")).click();
		String expectedQuantity = "5";
		String expectedTotal = "3682760.0 VNĐ";
		String quantity = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[1]/label[2]")).getText();
		String total = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[2]/label[2]")).getText();
		assertEquals(expectedQuantity, quantity);
		assertEquals(expectedTotal, total);
		driver.close();
	}
	
	@Test
	public void testReportByYearreturnNull(){
		driver.get("http://localhost:8080/bao-hiem-y-te/report-insurrance?type=year&year=");
		WebElement year = driver.findElement(By.name("year"));
		year.sendKeys("2019");
		driver.findElement(By.id("btnSearch")).click();
		String expectedQuantity = "0";
		String expectedTotal = "0.0 VNĐ";
		String quantity = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[1]/label[2]")).getText();
		String total = driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/div/div/div[3]/div/div[2]/label[2]")).getText();
		assertEquals(expectedQuantity, quantity);
		assertEquals(expectedTotal, total);
		driver.close();
	}
}
