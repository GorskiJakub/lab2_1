package edu.iis.mto.bsearch;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
public class BinarySearchTest {

	private BinarySearch binarySearch;
	
	private static void setUpBeforeClass(){
	}
	
	@Test
	public void LengthEq1IsInSeq() {
		int[] seq = new int[1];
		int key = 5;
		seq[0] = key;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(true, is(searchResult.isFound()));
		
	}

	@Test
	public void LengthEq1IsNotInSeq() {
		int[] seq = new int[1];
		int key = 5;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(false, is(searchResult.isFound()));
	}
	
	@Test
	public void LengthGreaterThen1IsFirstElement() {
		int[] seq = {0,1,2,3,4,5};
		int key = 0;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(1, is(searchResult.getPosition()));
	}
	@Test
	public void LengthGreaterThen1IsLastElement() {
		int[] seq = {0,1,2,3,4,5};
		int key = 5;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(seq.length, is(searchResult.getPosition()));
	}
	@Test
	public void LengthGreaterThen1IsMiddleElementEven() {
		int[] seq = {0,1,2,3,4,5};
		int key = 2;
		int center = seq.length/2;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(center, is(searchResult.getPosition()));
	}
	@Test
	public void LengthGreaterThen1IsMiddleElementOdd() {
		int[] seq = {0,1,3,4,5};
		int key = 3;
		int center = seq.length/2;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(center+1, is(searchResult.getPosition()));
	}
	@Test
	public void LengthGreaterThen1IsNotInSeq() {
		int[] seq = {0,1,3,4,5};
		int key = 2;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(false, is(searchResult.isFound()));
	}
	public void LengthGreaterThen1IsInSeq() {
		int[] seq = {0,1,2,3,4,5};
		int key = 2;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(true, is(searchResult.isFound()));
	}
	@Test(expected = IllegalArgumentException.class)
	public void seqIsEqNull()
	{
		int[] seq = new int[0];
		BinarySearch.search(1, seq);
	}
	@Test(expected = IllegalArgumentException.class)
	public void seqIsNotSorted()
	{
		int[] seq = {6,4,8,3,2,8};
		BinarySearch.search(1, seq);
	}

}
