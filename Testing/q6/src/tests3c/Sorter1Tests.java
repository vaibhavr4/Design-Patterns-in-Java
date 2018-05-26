package tests3c;

import static org.junit.Assert.*;

import org.junit.Test;

import sorters.Cities;
import sorters.Sorter1;
import sorters.Sorter;
/**
 * to unit test Sorter1(quick sort)
 * @author VAIBHAV
 *
 */

public class Sorter1Tests {

	private static <T extends Comparable<T>> Sorter<T> createSorter(){
	      return new Sorter1<>();
	    }
	 
	  /**
	   * sort a list with a null element
	   */
		  @Test
		  public void testNull(){ 
		    Sorter<Integer> sorter = createSorter();
		    Integer[] numbers = {8,1,5,3,4,null };
		    Integer[] sorted =  { null,1,3,4,5,8 };
		    sorter.sort(numbers); 

		    assertArrayEquals(numbers, sorted);
		  }
		  
		 
		  /**
		   * sort a list with a null element
		   */
		  @Test
		  public void testNullbegin(){ 
		    Sorter<Integer> sorter = createSorter();
		    Integer[] numbers = {null,1,5,3,4,8 };
		    Integer[] sorted =  { null,1,3,4,5,8 };
		    sorter.sort(numbers); 

		    assertArrayEquals(numbers, sorted);
		  }
		  
		
		/**
		 *  sort a list with a null element 
		 */
		  @Test
		  public void testNullmid(){ 
		    Sorter<Integer> sorter = createSorter();
		    Integer[] numbers = {1,5,null,4,8 };
		    Integer[] sorted =  { null,1,4,5,8 };
		    sorter.sort(numbers); 

		    assertArrayEquals(numbers, sorted);
		  }
		  
		  /**
		   * sort a list with a null element
		   */
		  
		  @Test
		  public void testNullonly(){ 
		    Sorter<Integer> sorter = createSorter();
		    Integer[] numbers = {null,null,null };
		    Integer[] sorted =  { null,null,null };
		    sorter.sort(numbers); 

		    assertArrayEquals(numbers, sorted);
		  }
	 
	   /**
	    * sort a list with ints
	    */
	  @Test
	  public void testints(){
	    Sorter<Integer> sorter = createSorter();
	    Integer[] integers = { 12, 1, 5, 34 };
	    sorter.sort(integers);
	    Integer[] sortedList = { 1, 5, 12, 34 };
	    assertArrayEquals(integers, sortedList);
	  }
	  

		/**
		 * sort a list with duplicate  Integer elements
		 */
		  @Test
		  public void testDuplicateIntElements() {
			  Sorter<Integer> sorter = createSorter();
			    Integer[] integers = { 5, 12, 5, 1, 5 };
			    sorter.sort(integers);
			    Integer[] sortedList = { 1, 5, 5, 5, 12 };
			    assertArrayEquals(integers, sortedList);
		  }
		
		  /**
		   *  sort a list with sortedList Integer elements
		   */
		  
		  @Test
		  public void testSortedIntElements(){
			  Sorter<Integer> sorter = createSorter();
			    Integer[] integers = { 1, 5, 12, 34 };
			    sorter.sort(integers);
			    Integer[] sortedList = { 1, 5, 12, 34 };
			    assertArrayEquals(integers, sortedList);
		  }
		  
		  
	  /**
	   *  sort a list with reverse sortedList Integer elements
	   */
	  
	  @Test
	  public void testReverseSortedIntElements(){
		  Sorter<Integer> sorter = createSorter();
		    Integer[] integers = { 34, 12, 5, 1};
		    sorter.sort(integers);
		    Integer[] sortedList = { 1, 5, 12, 34 };
		    assertArrayEquals(integers, sortedList);
	  }
	
	  /**
	   * sort negative integers
	   */
	  @Test
	  public void testNegativeInt() {
		  	Sorter<Integer> sorter = createSorter();
		    Integer[] integers = { -34, -5, -12, -10};
		    sorter.sort(integers);
		    Integer[] sortedList = { -34, -12, -10, -5 };
		    assertArrayEquals(integers, sortedList); 
	  }
	  
	  
	  /**
	   *  sort a very Large list
	   */
	  @Test
	  public void testLargeSetOfIntegers() {
		  Sorter<Integer> sorter = createSorter();
		  int largeValue = 10000000;
		  Integer[] value = new Integer[largeValue];
		  Integer[] sortedList = new Integer[largeValue];
		  for(int i=0;i<largeValue;i++) {
			  sortedList[i]=((i+1)-10)+30;
			  value[i]=(((largeValue-i)-10)+30);
		  }
		  sorter.sort(value);
		  assertArrayEquals(value, sortedList);
	  }
	  
	  /**
	   *  sort a list with one integer element
	   */
	  
	  @Test
	  public void testSingleInt(){
	    Sorter<Integer> sorter = createSorter();
	    Integer[] single = { 17 };
	    sorter.sort(single);
	    Integer[] sortedList = { 17 };
	    assertArrayEquals(single, sortedList);
	  }
	 
	  /**
	   *  sort an empty list (of integer)
	   */
	  
	  @Test
	  public void testEmptyInt(){
	    Sorter<Integer> sorter = createSorter();
	    Integer[] empty = {  };
	    sorter.sort(empty);
	    Integer[] sortedList = {  };
	    assertArrayEquals(empty, sortedList);
	  }
	  
/**
*  sort a list with multiple String elements
*/
	  @Test
	  public void testMultipleElements(){
	    Sorter<String> sorter = createSorter();
	    String[] characters = { "vegeta", "goku", "gohan", "flash", "sherlock" };
	    sorter.sort(characters);
	    String[] sortedList = { "flash", "gohan", "goku", "sherlock", "vegeta" };
	    assertArrayEquals(characters, sortedList);
	  }
	  

	/**
	 * sort String and number inputs
	 */
	  @Test
	  public void testNumStringInput()
	  {
		  Sorter<String> sorter = createSorter();
		  String[] nullInput = {"abc","bcd","1","2"};
		  sorter.sort(nullInput);
		  String[] sortedList = {"1","2","abc","bcd"};
		  assertArrayEquals(nullInput,sortedList);
	  }
	  
	  /**
	   *  sort a list with duplicate String elements
	   */
	  
	  @Test
	  public void testDuplicateElements(){
	    Sorter<String> sorter = createSorter();
	    String[] characters = {"vegeta", "goku", "gohan", "goku", "goku"};
	    sorter.sort(characters);
	    String[] sortedList = { "gohan", "goku", "goku", "goku", "vegeta" };
	    assertArrayEquals(characters, sortedList);
	  }
		  
		/**
		 *  sort a list with one String element
		 */
		  
		  @Test
		  public void testSingleElement(){ 
		    Sorter<String> sorter = createSorter();
		    String[] characters = { "goku" };
		    sorter.sort(characters);
		    String[] sortedListList = { "goku" };
		    assertArrayEquals(characters, sortedListList);
		  }
		  
		/**
		 * sort an empty list (of strings)
		 */
		  
		  @Test
		  public void testEmpty(){
		    Sorter<String> sorter = createSorter();
		    String[] empty = {  };
		    sorter.sort(empty);
		    String[] sortedListList = {  };
		    assertArrayEquals(empty, sortedListList);
		  }
	  
		  /**
		   * sort list containing elements of Byte type
		   */
		  
		  @Test
		  public void testByteElements(){
		    Sorter<Byte> sorter = createSorter();
		    Byte[] values = {1,24,8,3};
		    sorter.sort(values);
		    Byte[] sortedList = {1,3,8,24};
		    assertArrayEquals(values, sortedList);
		  }
		  
		  
		  /**
		   * sort list containing one element of a Byte type
		   */
		  
		  @Test
		  public void testSingleByteElements(){
		    Sorter<Byte> sorter = createSorter();
		    Byte[] value = {1};
		    sorter.sort(value);
		    Byte[] sortedList = {1};
		    assertArrayEquals(value, sortedList);
		  }
		  
		  /**
		   *  sort list containing elements of double type
		   */
		  
		  @Test
		  public void testDoubleElements(){
		    Sorter<Double> sorter = createSorter();
		    Double[] values = {21.09, 21.08, 21.086,21.0, 0.9};
		    sorter.sort(values);
		    Double[] sortedList = {0.9, 21.0, 21.08,21.086, 21.09};
		    assertArrayEquals(values, sortedList);
		  }
		  
		  /**
		   *  sort list containing duplicate elements of double type
		   */
		  
		  @Test
		  public void testDuplicateDoubleElements(){
		    Sorter<Double> sorter = createSorter();
		    Double[] values = {0.9, 2.5, 3.5,9.8, 0.9};
		    sorter.sort(values);
		    Double[] sortedList = {0.9, 0.9, 2.5, 3.5,9.8};
		    assertArrayEquals(values, sortedList);
		  }	
		  
		/**
		 * sort list containing elements of a user-defined type
		 */
		  
		  @Test
		  public void testUserDefinedType(){
		    Sorter<Cities> sorter = createSorter();
		    Cities[] city = { new Cities("Ames"),new Cities("Boston"),new Cities("Vegas"),new Cities("Newyork")};
		    sorter.sort(city);
		    Cities[] sortedList = {new Cities("Ames"),new Cities("Boston"),new Cities("Newyork"),new Cities("Vegas") };
		    assertArrayEquals(city, sortedList);
		  }
		  
		  /**
		   * sort list containing duplicate elements of a user-defined type
		   */
		  
		  @Test
		  public void testDuplicateUserDefinedType(){
		    Sorter<Cities> sorter = createSorter();
		    Cities[] city = {new Cities("Vegas"),new Cities("Boston"), new Cities("Ames"),new Cities("Boston")};
		    sorter.sort(city);
		    Cities[] sortedList = {new Cities("Ames"),new Cities("Boston"),new Cities("Boston"),new Cities("Vegas") };
		    assertArrayEquals(city, sortedList);
		  }

		  
		  /**
		   *  sort list containing sortedList elements of a user-defined type
		   */
		  
		  @Test
		  public void testSortedUserDefinedType(){
		    Sorter<Cities> sorter = createSorter();
		    Cities[] city = {new Cities("Ames"),new Cities("Boston"),new Cities("Newyork"),new Cities("Vegas") };
		    sorter.sort(city);
		    Cities[] sortedList = {new Cities("Ames"),new Cities("Boston"),new Cities("Newyork"),new Cities("Vegas") };
		    assertArrayEquals(city, sortedList);
		  }
		  
		  /**
		   *  sort list containing reverse sortedList elements of a user-defined type
		   */
		  
		  @Test
		  public void testReverseSortedUserDefinedType(){
		    Sorter<Cities> sorter = createSorter();
		    Cities[] city = {new Cities("Vegas"),new Cities("Newyork"), new Cities("Boston"),new Cities("Ames")};
		    sorter.sort(city);
		    Cities[] sortedList = {new Cities("Ames"),new Cities("Boston"),new Cities("Newyork"),new Cities("Vegas") };
		    assertArrayEquals(city, sortedList);
		  }
		
	
		/**
		 *  sort list containing one element of a user-defined type
		 */
		  
		  @Test
		  public void testOneUserDefinedType(){
		    Sorter<Cities> sorter = createSorter();
		    Cities[] city = { new Cities("Boston")};
		    sorter.sort(city);
		    Cities[] sortedList = {new Cities("Boston") };
		    assertArrayEquals(city, sortedList);
		  }
		  
		  
		  /**
		   *  sort list containing no element of a user-defined type
		   */
		  
		  @Test
		  public void testEmptyUserDefinedType(){
		    Sorter<Cities> sorter = createSorter();
		    Cities[] city = {};
		    sorter.sort(city);
		    Cities[] sortedList = {};
		    assertArrayEquals(city, sortedList);
		  }
	  

}
