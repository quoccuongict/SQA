package controller;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.insurrance.dao.UserDAO;
import com.insurrance.model.User;

public class LoginTest {

	private static UserDAO dao;
	private static User user;
	
	public LoginTest() {
	}

	@BeforeClass
	public static void setup(){
		user = new User(2, "hoquoccuong", "123456", "Hồ Quốc Cường", "ADMIN");
		dao = new UserDAO();
	}
	
	@Test
	public void loginWithUserInvalid(){ // không nhập username
		String username = "";
		String password = "123456";
		User expected = null;
		User actual = dao.checkLogin(username, password);
		assertEquals(expected, actual);
	}
	
	@Test
	public void loginWithPassInvalid(){ // không nhập password
		String username = "hoquoccuong";
		String password = "";
		User expected = null;
		User actual = dao.checkLogin(username, password);
		assertEquals(expected, actual);
	}
	
	@Test
	public void loginWithUserPassInvalid(){ // không nhập username, password
		String username = "";
		String password = "";
		User expected = null;
		User actual = dao.checkLogin(username, password);
		assertEquals(expected, actual);
	}
	
	@Test
	public void loginWithUserIncorrect(){ // nhập sai username
		String username = "cuong";
		String password = "123456";
		User expected = null;
		User actual = dao.checkLogin(username, password);
		assertEquals(expected, actual);
	}
	
	@Test
	public void loginWithPassIncorrect(){ //  nhập sai password
		String username = "hoquoccuong";
		String password = "admin";
		User expected = null;
		User actual = dao.checkLogin(username, password);
		assertEquals(expected, actual);
	}
	
	@Test
	public void loginWithUserAndPassIncorrect(){ // nhập sai username, password
		String username = "123";
		String password = "123";
		User expected = null;
		User actual = dao.checkLogin(username, password);
		assertEquals(expected, actual);
	}
	
	@Test
	public void loginWithUserAndPassCorrect(){ // nhập đúng username, password
		String username = "hoquoccuong";
		String password = "123456";
		User expected = new User(2, "hoquoccuong", "123456", "Hồ Quốc Cường", "ADMIN");
		User actual = dao.checkLogin(username, password);
		System.out.println(actual);
		assertEquals(expected, actual);
	}
}
