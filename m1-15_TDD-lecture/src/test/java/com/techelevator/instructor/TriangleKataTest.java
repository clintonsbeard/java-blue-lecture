package com.techelevator.instructor;

import org.junit.*;

public class TriangleKataTest {

	private KataTriangle target;
	
	@Before
	public void setup() {
		target = new KataTriangle();
	}
	
	@Test
	public void invalid_when_the_sum_of_1st_and_2nd_are_less_than_3rd() {
		String type = target.classify(1, 1, 3);
		Assert.assertEquals("invalid", type);
	}
	
	@Test
	public void invalid_when_the_sum_1st_and_3rd_are_less_than_2nd() {
		String type = target.classify(1, 3, 1);
		Assert.assertEquals("invalid", type);
	}
	
	@Test
	public void invalid_when_the_sum_of_2nd_and_3rd_are_less_than_1st() {
		String type = target.classify(3, 1, 1);
		Assert.assertEquals("invalid", type);
	}
	
	@Test
	public void identifies_scalene_with_sum_of_2_sides_equal_to_third() {
		String type = target.classify(1, 2, 3);
		Assert.assertEquals("scalene", type);
	}
	
	@Test
	public void identifies_scalene_with_sum_of_2_sides_greater_than_third() {
		String type = target.classify(4, 1, 3);
		Assert.assertEquals("scalene", type);
	}
	
	@Test
	public void identifies_isosceles_sides_1_and_2_equal() {
		String type = target.classify(2, 2, 3);
		Assert.assertEquals("isosceles", type);
	}
	
	@Test
	public void identifies_isosceles_sides_1_and_3_equal() {
		String type = target.classify(2, 3, 2);
		Assert.assertEquals("isosceles", type);
	}
	
	@Test
	public void identifies_isosceles_sides_2_and_3_equal() {
		String type = target.classify(3, 2, 2);
		Assert.assertEquals("isosceles", type);
	}
	
	@Test
	public void identifies_equilateral() {
		String type = target.classify(2, 2, 2);
		Assert.assertEquals("equilateral", type);
	}
	
	@Test
	public void handles_negative_sides() {
		String type = target.classify(-1, -3, -2);
		Assert.assertEquals("invalid", type);
	}
	
	@Test
	public void handles_zero_sides() {
		String type = target.classify(0, 1, 1);
		Assert.assertEquals("invalid", type);
	}
	
}
