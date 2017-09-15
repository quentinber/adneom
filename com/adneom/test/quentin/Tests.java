package com.adneom.test.quentin;

import static org.junit.Assert.*;
import com.adneom.test.quentin.Solver;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class using JUNIT4 which contains 8 unit tests for the "partition" function 
 * @author quentinbernet
 * @version 1.0.0
 */
public class Tests {

	/**
	 * pairList 
	 * ArrayList that contains a pair number of elements
	 */
	private static ArrayList<Object> pairList ;
	/**
	 * impairList
	 * ArrayList that contains an impair number of elements 
	 */
	private static ArrayList<Object> impairList ;
	/**
	 * Solver
	 * instance of the Solver class
	 */
	private Solver solver = new Solver(); 
	/**
	 * Creates two different list for the tests. 
	 * pairList containing a pair number of elements
	 * impairList containing an impair number of elements
	 * @throws Exception raised by setUpBeforeClass
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pairList = new ArrayList<>(Arrays.asList(1,2,3,4));
		impairList = new ArrayList<>(Arrays.asList(1,2,3,4,5)); 
	}
	/**
	 * Test with list == null 
	 * must throw an Exception.
	 */
	@Test
	public void testListNull() {
		try {
			assertEquals(solver.partition(null, 1), new ArrayList<ArrayList<Object>>()) ;	
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	/**
	 * Test with empty list 
	 * must throw an Exception.
	 */
	@Test
	public void testListEmpty() {
		try {
			assertEquals(solver.partition(new ArrayList<>(), 1), new ArrayList<ArrayList<Object>>()) ;	
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	/**
	 * Test with negative gap 
	 * must throw an Exception.
	 */
	@Test
	public void testNegativeGap() {
		try {
			assertEquals(solver.partition(pairList, -2), new ArrayList<ArrayList<Object>>()) ;	
		} catch (Exception e) {
			System.err.println(e);
		}	
	}
	/**
	 * Test with a list containing a pair number of elements 
	 * and a pair gap.
	 */
	@Test
	public void testPairWithPairGap() {
		ArrayList<Object> sub1 = new ArrayList<>(Arrays.asList(1,2));  
		ArrayList<Object> sub2 = new ArrayList<>(Arrays.asList(3,4));
		ArrayList<ArrayList<Object>> expectedSolution = new ArrayList<>(Arrays.asList(sub1,sub2)); 

		try {
			assertEquals(solver.partition(pairList, 2),expectedSolution) ;	
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	/**
	 * Test with a list containing a pair number of elements
	 * and an impair gap.
	 */
	@Test
	public void testPairWithImpairGap() {
		ArrayList<Object> sub1 = new ArrayList<>(Arrays.asList(1,2,3));  
		ArrayList<Object> sub2 = new ArrayList<>(Arrays.asList(4));
		ArrayList<ArrayList<Object>> expectedSolution = new ArrayList<>(Arrays.asList(sub1,sub2)); 

		try {
			assertEquals(solver.partition(pairList, 3),expectedSolution) ;	
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	/**
	 * Test with a list containing a impair number of elements
	 * and a pair gap.
	 */
	@Test
	public void testImpairWithPairGap() {
		ArrayList<Object> sub1 = new ArrayList<>(Arrays.asList(1,2));  
		ArrayList<Object> sub2 = new ArrayList<>(Arrays.asList(3,4));
		ArrayList<Object> sub3 = new ArrayList<>(Arrays.asList(5));
		ArrayList<ArrayList<Object>> expectedSolution = new ArrayList<>(Arrays.asList(sub1,sub2,sub3)); 

		try {
			assertEquals(solver.partition(impairList, 2),expectedSolution) ;	
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	/**
	 * Test with a list containing a impair number of elements
	 * and an impair gap.
	 */
	@Test
	public void testImpairWithImpairGap() {
		ArrayList<Object> sub1 = new ArrayList<>(Arrays.asList(1,2,3));  
		ArrayList<Object> sub2 = new ArrayList<>(Arrays.asList(4,5));
		ArrayList<ArrayList<Object>> expectedSolution = new ArrayList<>(Arrays.asList(sub1,sub2)); 

		try {
			assertEquals(solver.partition(impairList,3),expectedSolution) ;	
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	/**
	 * Test with a gap greater than the list size. 
	 */
	@Test
	public void testWithHugeGap() {
		ArrayList<ArrayList<Object>> expectedSolution = new ArrayList<>(Arrays.asList(impairList)) ;  
		try {
			assertEquals(solver.partition(impairList,19),expectedSolution) ;	
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
