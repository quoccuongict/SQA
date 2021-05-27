package model;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.insurrance.model.Customer;
import com.insurrance.model.Insurance;
import com.insurrance.model.LevelPrice;
import com.insurrance.model.ReportMedicalAddress;

public class ReportTest {

	private ReportMedicalAddress report;
	
	public ReportTest(){
		report = new ReportMedicalAddress();
	}
	
	@BeforeClass
    public static void setUpClass() {
		
	}
	
	@Before
	public void setup(){
		report.setType("medicalAddress");
	}
	
	@Test
	public void testGetQuantity_Return0(){
		List<Insurance> insurances = new ArrayList<>();
		report.setInsurances(insurances);
		report.setQuantity(insurances);
		report.setTotal(insurances);
		int expected = 0;
		int actual  = report.getQuantity();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetTotal_Return0(){
		List<Insurance> insurances = new ArrayList<>();
		report.setInsurances(insurances);
		report.setQuantity(insurances);
		report.setTotal(insurances);
		float expected = 0f;
		float actual = report.getTotal();
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testGetQuantity_ReturnInt(){
		List<Insurance> insurances = new ArrayList<>();
		
		insurances.add(new Insurance(1, "HD12345", "Hà Đông", new Customer("Nguyễn Văn B"),new LevelPrice("Mức 1", 800000.0f, "Mức người thứ nhất trong hộ gia đình đóng")));
		insurances.add(new Insurance(4, "HD23433", "Hà Đông", new Customer("Nguyễn Minh"),new LevelPrice("Mức 2", 563220.0f, "Mức người thứ 2 trong hộ gia đình đóng")));
		insurances.add(new Insurance(8, "HD93943", "Hà Đông", new Customer("Nguyễn Anh"),new LevelPrice("Mức 3", 563220.0f, "Mức người thứ 3 trong hộ gia đình đóng")));
		
		report.setInsurances(insurances);
		report.setQuantity(insurances);
		report.setTotal(insurances);
		int expected = 3;
		int actual  = report.getQuantity();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTotal_ReturnFloat(){
		List<Insurance> insurances = new ArrayList<>();
		
		insurances.add(new Insurance(1, "HD12345", "Hà Đông", new Customer("Nguyễn Văn B"),new LevelPrice("Mức 1", 800000.0f, "Mức người thứ nhất trong hộ gia đình đóng")));
		insurances.add(new Insurance(4, "HD23433", "Hà Đông", new Customer("Nguyễn Minh"),new LevelPrice("Mức 2", 563220.0f, "Mức người thứ 2 trong hộ gia đình đóng")));
		insurances.add(new Insurance(8, "HD93943", "Hà Đông", new Customer("Nguyễn Anh"),new LevelPrice("Mức 3", 482760.0f, "Mức người thứ 3 trong hộ gia đình đóng")));
		
		report.setInsurances(insurances);
		report.setQuantity(insurances);
		report.setTotal(insurances);
		float expected = 1845980.0f;
		float actual = report.getTotal();
		assertEquals(expected, actual, 0f);
	}
}
