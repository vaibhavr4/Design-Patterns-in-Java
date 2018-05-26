package Bitvector.a;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @author VAIBHAV
 * Unit test for BitVector.
 */
public class BitVectorTests {

	/**
	 * used to test get and set method of BitVector class
	 */
	@Test
	public void testsetget()
    {
    	BitVector bv = new BitVector();
    	bv.set(2);
    	assertTrue(bv.get(2));
    	assertFalse(bv.get(3));
    	int arr[] = {34,36,4,32,5,7,64,99,155,200};
		for(int i=0;i<10;i++)
			bv.set(arr[i]);
		assertTrue(bv.get(32));
		assertTrue(bv.get(200));    	
    }
	 
	/**
     * method to test clear() of BitVector class
     */
	@Test
    public void testclear()
    {
    	BitVector bc = new BitVector();
    	int arr[] = {20,32,44,55,76};
    	for(int i=0;i<5;i++)
			bc.set(arr[i]);
    	assertTrue(bc.get(44));
    	bc.clear(44);
    	assertFalse(bc.get(44));
    	bc.clear(2);
    	assertFalse(bc.get(2));
    }
    
	/**
	 * method to test size() method of BitVector class
	 */
	@Test
    public void testsize()
    {
    	BitVector bs = new BitVector();
    	int arr[] = {20,32,44,55,76};
    	for(int i=0;i<5;i++)
			bs.set(arr[i]);
    	assertEquals(5,bs.size());
    	bs.set(1);
    	assertEquals(6,bs.size());
    	bs.clear(20);
    	assertEquals(5,bs.size());
    }
	
	/**
	 * method to test copy() of BitVector class
	 */
	@Test
	public void testcopy()
	{
		BitVector bc1 = new BitVector();
    	int arr[] = {20,32,44,55,76};
    	for(int i=0;i<5;i++)
			bc1.set(arr[i]);
    	BitVector bc2 = new BitVector();
    	assertEquals(5, bc1.size());
    	assertEquals(0,bc2.size());
    	bc2.copy(bc1);
    	assertEquals(5,bc2.size());
    	assertTrue(bc2.get(44));
    	assertTrue(bc2.get(76));
    	BitVector bc3 = new BitVector();
    	int arr2[] = {1,2,4};
    	for(int j=0; j<3; j++)
    		bc3.set(arr2[j]);
    	assertEquals(3,bc3.size());
    	bc3.copy(bc1);
    	assertEquals(8,bc3.size());
    	assertTrue(bc3.get(44));
    	BitVector bc4 = new BitVector();
    	int arr4[] = {22,33,45,56,77};
    	for(int i=0;i<5;i++)
			bc4.set(arr4[i]);
    	bc4.copy(bc1);
    	assertEquals(10,bc4.size());
    	
	}
	

}
