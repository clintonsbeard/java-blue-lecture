package com.techelevator.instructor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class FruitTreeTest {

	private FruitTree fruitTree;
	
	@Before
	public void setup() {
		// Runs Before every test
		fruitTree = new FruitTree("Apple", 20);
	}
	
	@After
	public void cleanup() {
		// Runs After every test
	}
	
	@Test
	public void fruit_tree_has_20_fruits_when_created() {
		// Arrange
		// Act
		int piecesOfFruitLeft = fruitTree.getPiecesOfFruitLeft();
		// Assert
		Assert.assertEquals(20, piecesOfFruitLeft);
	}
	
	@Test
	public void fruit_tree_starts_with_apples() {
		// Arrange
		// Act
		String typeOfFruit = fruitTree.getTypeOfFruit();
		//Assert
		Assert.assertEquals("Apple", typeOfFruit);
	}
	
	@Test
	public void no_fruit_picked_if_more_than_remaining_attempted() {
		// Arrange
		fruitTree.pickFruit(15);
		// Act
		boolean wasPicked = fruitTree.pickFruit(7);
		
		Assert.assertFalse("PickFruit returned TRUE", wasPicked);
		Assert.assertEquals("Wrong number of remaining fruit", 5, fruitTree.getPiecesOfFruitLeft());
	}
	
}
