package com.adneom.test.quentin;

import java.util.ArrayList;
import java.util.Arrays;

import com.adneom.test.quentin.Solver;

/**
 * Entry point of the program. Solves the exemples of the subject. 
 * @author quentinbernet
 * @version 1.0.0
 */
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Exemples of the exercice. 
		 */
		ArrayList<Object> Test = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		
		Solver solver = new Solver(); 

		try {
			System.out.println(solver.partition(Test,2)); 	
		} catch (Exception e) {
			System.err.println(e);
		}
		
		try {
			System.out.println(solver.partition(Test,3)); 	
		} catch (Exception e) {
			System.err.println(e);
		}
		
		try {
			System.out.println(solver.partition(Test,1)); 	
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
