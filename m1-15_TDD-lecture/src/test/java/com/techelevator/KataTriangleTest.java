package com.techelevator;

import org.junit.*;

public class KataTriangleTest {

	private KataTriangle target;
	
	@Before
	public void setup() {
		target = new KataTriangle();
	}
	
	@Test
	public void invalid_when_sum_of_first_and_second_sides_are_less_than_third() {
		String type = target.classifyTriangle(1, 1, 3);
		Assert.assertEquals("Invalid", type);
	}
	
	@Test
	public void invalid_when_sum_of_first_and_third_sides_are_less_than_second() {
		String type = target.classifyTriangle(1, 3, 1);
		Assert.assertEquals("Invalid", type);
	}
	
	@Test
	public void invalid_when_sum_of_second_and_third_sides_are_less_than_first() {
		String type = target.classifyTriangle(3, 1, 1);
		Assert.assertEquals("Invalid", type);
	}
	
	@Test
	public void invalid_when_one_or_more_sides_is_negative() {
		String type = target.classifyTriangle(-1, -2, -3);
		Assert.assertEquals("Invalid", type);
	}
	
	@Test
	public void invalid_when_one_or_more_sides_is_zero() {
		String type = target.classifyTriangle(0, 1, 1);
		Assert.assertEquals("Invalid", type);
	}
	
	@Test
	public void scalene_when_all_sides_are_different() {
		String type = target.classifyTriangle(2, 3, 4);
		Assert.assertEquals("Scalene", type);
	}
	
	@Test
	public void equilateral_when_all_sides_are_the_same() {
		String type = target.classifyTriangle(3, 3, 3);
		Assert.assertEquals("Equilateral", type);
	}
	
	@Test
	public void isosceles_when_first_and_second_sides_are_equal_() {
		String type = target.classifyTriangle(2, 2, 3);
		Assert.assertEquals("Isosceles", type);
	}
	
	@Test
	public void isosceles_when_first_and_third_sides_are_equal() {
		String type = target.classifyTriangle(2, 3, 2);
		Assert.assertEquals("Isosceles", type);
	}
	
	@Test
	public void isosceles_when_second_and_third_sides_are_equal() {
		String type = target.classifyTriangle(3, 2, 2);
		Assert.assertEquals("Isosceles", type);
	}
}