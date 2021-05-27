package model;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.insurrance.model.Customer;

public class CustomerTest {

private static Customer customer;
    
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        customer = new Customer();
    }
    
    @Before
    public void setUp() {
        customer.setId(1);
        customer.setFullName("Hồ Quốc Cường");
        customer.setAddress("Hà Đông");
        customer.setDateOfBirth(Timestamp.valueOf("1999-12-11 00:00:00"));
        customer.setGender("Male");
    }
    
    @Test
    public void testGetId() {
        int expected = 1;
        int actual = customer.getId();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSetId() {
        int id = 1;
        customer.setId(id);
    }
    
    @Test
    public void testGetDateOfBirth(){
        Timestamp expected = Timestamp.valueOf("1999-12-11 00:00:00");
        Timestamp actual = customer.getDateOfBirth();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSetDateOfBirth() {
        Timestamp dateOfBirth = Timestamp.valueOf("1999-12-11 00:00:00");
        customer.setDateOfBirth(dateOfBirth);
    }
    
    @Test
    public void testGetFullName(){
        String expected = "Hồ Quốc Cường";
        String actual = customer.getFullName();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSetFullName() {
        String fullName = "Hồ Quốc Cường";
        customer.setFullName(fullName);
    }
    
    @Test
    public void testGetAddress(){
    	String expected = "Hà Đông";
    	String actual = customer.getAddress();
    	assertEquals(expected, actual);
    }
    @Test
    public void testSetAddress(){
    	String address = "Hà Đông";
    	customer.setAddress(address);
    }
    
    @Test
    public void testGetGender(){
    	String expected = "Male";
    	String actual = customer.getGender();
    	assertEquals(expected, actual);
    }
    
    @Test
    public void testSetGender(){
    	String gender = "Male";
    	customer.setGender(gender);
    }

}
