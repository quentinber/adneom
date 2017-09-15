package com.adneom.test.quentin;

import java.util.ArrayList; 
/**
 * Class that solves the following problem: 
 * Write a function "partition" that takes one parameter "list" and one parameter "size" which returns a list containing multiple sublists with
 * a maximum of "size" elements 
 * @author quentin bernet
 * @version 1.0.0
 */
class Solver {
	/**
	 * List to explode according to the size 
	 */
	private ArrayList<Object> list ; 
	/**
	 * Size of the several sublists which will compose the solution 
	 */
	private Integer size ; 
	/**
	 * Final list containing the sublists representing the solution 
	 */
	private ArrayList<ArrayList<Object>> solution; 
	
	/**
	 * Constructor of the solver 
	 */
	public Solver() {
	}
	/**
	 * Solver catching the exceptions and calling 
	 * the recursive algorithm that updates the solution 
 	 * @param list list to explode according to the size 
	 * @param size max size of the several sublists which will compose the solution 
	 * @throws Exception if list is null or list is empty or size is negative 
	 * @return updated solution
	 */
	public ArrayList<ArrayList<Object>> partition(ArrayList<Object> list,Integer size) throws Exception {
		this.list = list ; 
		this.size = size ; 
		solution = new ArrayList<ArrayList<Object>>(); 
		
		/*
		 * Test multiple cases that could break the recursive loop
		 * if list == null, the subList function can throw an exception 
		 */
		if(this.list == null) {
			throw new Exception("List cannot be null"); 
		}
		/*
		 * Test multiple cases that could break the recursive loop
		 * if list.size() == 0 , the subList function can throw an exception 
		 */
		if(this.list.size() == 0) {
			throw new Exception ("List cannot be empty"); 
		}
		/*
		 * Test multiple cases that could break the recursive loop
		 * if size <= 0, the subList function can throw an exception 
		 */
		if(this.size <= 0) {
			throw new Exception("Size shall be strictly greater than 0");
		}
		recursiveAlgorithm(0,this.size); 	
		return this.solution ; 
	}
	/**
	 * Solves and updates the private variable solution by dividing the given list to multiple sublists with "size" size 
	 * @param lowerBound start index of the next sublist (at start, it equals 0) 
	 * @param upperBound end index of the next sublist (at start, it equals size)
	 */
	private void recursiveAlgorithm(Integer lowerBound, Integer upperBound) {
		/*
		 * terminal condition. 
		 * if upperBound is greater than the size of the list, then the last sublist will start at the lowerBound and will end at the size list minus 1
		 */
		if (upperBound >= this.list.size()) {
			this.solution.add(new ArrayList<Object>(this.list.subList(lowerBound,this.list.size()))); 
		}
		/*
		 * recursive loop call
		 * add the sublist which starts at the lowerBound and ends at the upperBound to the global solution 
		 * and call back the recursiveAlgorithm function with lowerBound = upperBound and upperBound = upperBound + size 
		 */
		else {
			ArrayList<Object> subList = new ArrayList<Object>(this.list.subList(lowerBound, upperBound)) ;
			this.solution.add(subList); 
			recursiveAlgorithm(upperBound,upperBound+this.size); 
		}
	}
	
}
