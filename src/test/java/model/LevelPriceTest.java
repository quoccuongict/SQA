package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.insurrance.model.LevelPrice;

public class LevelPriceTest {

	private static LevelPrice levelPrice;
	
	public LevelPriceTest() {
		
	}

	@BeforeClass
    public static void setUpClass() {
        levelPrice = new LevelPrice();
    }
    
    @Before
    public void setUp() {
        levelPrice.setId(1);
        levelPrice.setTypeLevel("Mức 1");
        levelPrice.setPrice(850600);
        levelPrice.setDescription("Mức người thứ 1 trong hộ gia đình đóng");
    }
    
    @Test
    public void testGetId() {
        int expected = 1;
        int actual = levelPrice.getId();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSetId() {
        int id = 1;
        levelPrice.setId(id);
    }
    
    @Test
    public void testGetTypeLevel() {
        String expected = "Mức 1";
        String actual = levelPrice.getTypeLevel();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSetTypeLevel() {
        String typeLevel = "Mức 1";
        levelPrice.setTypeLevel(typeLevel);
    }
    
    @Test
    public void testGetPrice() {
        float expected = 850600;
        float actual = levelPrice.getPrice();
        assertEquals(expected, actual, 0);
    }
    
    @Test
    public void testSetPrice() {
        float price = 850600;
        levelPrice.setPrice(price);;
    }
    
    @Test
    public void testGetDescription(){
    	String expected = "Mức người thứ 1 trong hộ gia đình đóng";
    	String actual = levelPrice.getDescription();
    	assertEquals(expected, actual);
    }
    
    @Test
    public void testSetDescription(){
    	String description = "Mức người thứ 1 trong hộ gia đình đóng";
    	levelPrice.setDescription(description);
    }
}
