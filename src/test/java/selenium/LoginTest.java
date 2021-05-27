package selenium;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends TestDriver{

	ChromeDriver driver = getDriver();
	
	@Test
	public void testTitleLogin(){
		driver.get("http://localhost:8080/bao-hiem-y-te/dang-nhap");
		String title = driver.getTitle();
		String expected = "Đăng nhập";
		driver.close();
		assertEquals(expected, title);
	}

	@Test
	public void testLoginWithUsernamePasswordSuccess(){
		driver.get("http://localhost:8080/bao-hiem-y-te/dang-nhap");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		String expected = "Xin chào, Admin";
		String fullName = driver.findElement(By.xpath("/html/body/div/div/div[2]/ul/li/a")).getText();
		driver.close();
		assertEquals(expected, fullName);
	}
	
	@Test
	public void testLoginWithUsernameInvalid(){ // kiểm tra không nhập username
		driver.get("http://localhost:8080/bao-hiem-y-te/dang-nhap");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		assertEquals("Đăng nhập", driver.getTitle());
		driver.close();
	}
	
	@Test
	public void testLoginWithPassInvalid(){ // kiểm tra không nhập password
		driver.get("http://localhost:8080/bao-hiem-y-te/dang-nhap");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		assertEquals("Đăng nhập", driver.getTitle());
		driver.close();
	}
	
	@Test
	public void testLoginWithUserPassInvalid(){ // kiểm tra không nhập username, password
		driver.get("http://localhost:8080/bao-hiem-y-te/dang-nhap");
		driver.findElement(By.id("btnLogin")).click();
		assertEquals("Đăng nhập", driver.getTitle());
		driver.close();
	}
	
	@Test
	public void testLoginWithUsernameIncorrect(){ // kiểm tra sai username
		driver.get("http://localhost:8080/bao-hiem-y-te/dang-nhap");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("abc");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		String expected = "Username or Password is invalid";
		String message = driver.findElement(By.xpath("/html/body/div/div/div/div")).getText();
		driver.close();
		assertEquals(expected, message);
	}
	
	@Test
	public void testLoginWithPasswordeIncorrect(){ // kiểm tra sai password
		driver.get("http://localhost:8080/bao-hiem-y-te/dang-nhap");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("123");
		driver.findElement(By.id("btnLogin")).click();
		String expected = "Username or Password is invalid";
		String message = driver.findElement(By.xpath("/html/body/div/div/div/div")).getText();
		driver.close();
		assertEquals(expected, message);
	}
	
	@Test
	public void testLoginWithUserPasswordeIncorrect(){ // kiểm tra sai username, password
		driver.get("http://localhost:8080/bao-hiem-y-te/dang-nhap");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("123");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("123");
		driver.findElement(By.id("btnLogin")).click();
		String expected = "Username or Password is invalid";
		String message = driver.findElement(By.xpath("/html/body/div/div/div/div")).getText();
		driver.close();
		assertEquals(expected, message);
	}
}
