import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author arghhjayy
 */
public class SomeTest {
	public int add(int a, int b){
		return a + b;
	}
	
	@Test
	public void addtest(){
		assertEquals(105, add(5, 5));
	}
}
