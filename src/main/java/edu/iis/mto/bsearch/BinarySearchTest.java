package edu.iis.mto.bsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	private BinarySearch binarySearch;
	
	private static void setUpBeforeClass(){
	}
	
	@Test
	public void LenghtEq1IsInSeq() {
		int[] seq = new int[1];
		int key = 5;
		seq[0] = key;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertTrue(searchResult.isFound());
	}
	
	@Test
	public void LenghtEq1IsNotInSeq() {
		int[] seq = new int[1];
		int key = 5;
		//seq[0] = 8;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertFalse(searchResult.isFound());
	}

}
