package controller;

import org.junit.BeforeClass;

import com.insurrance.dao.ConfigInsuranceDAO;
import com.insurrance.model.LevelPrice;

public class ConfigInsurrance {

	private static ConfigInsuranceDAO dao;
	private static LevelPrice levelPrice;
	
	public ConfigInsurrance() {
	}

	@BeforeClass
	public void setup(){
		dao = new ConfigInsuranceDAO();
	}
	
//	@Test
//	public void testUpdateLevelPrice(){
//		LevelPrice levelPrice = new LevelPrice(5, "Mức 5", 321840, "Mức người thứ 5 trở đi trong hộ gia đình đóng");
//		LevelPrice actual = dao.updateLevePrice(levelPrice);
//	}
}
