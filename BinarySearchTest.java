import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
	@Test
	public void test() throws Exception{
		int[] s = new int[33];
		for(int i = 0; i < 33; i++){
			s[i] = 2 * i;
		}
		for(int i = 0; i < 33; i++){
			Assert.assertTrue(BinarySearch.binarySearch(i*2, s) == i);
			Throwable t = null;
			try{
				BinarySearch.binarySearch(i*2+1, s);
			}catch(Exception ex){
				t = ex;
			}
			
			Assert.assertNotNull(t);
			Assert.assertTrue(t instanceof Exception);
		}
	}
	
	@Test
	public void test1(){
		int[] s = new int[33];
		for(int i = 0; i < 33; i++){
			s[i] = 2 * i;
		}
		Throwable t = null;
		try{
			BinarySearch.binarySearch(-1, s);
		}catch(Exception ex){
			t = ex;
		}
		
		Assert.assertNotNull(t);
		Assert.assertTrue(t instanceof Exception);
	}
}
