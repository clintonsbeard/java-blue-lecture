package com.techelevator;

/*
 * Create a Triangle Classifier with the following method: 
 * 	String classify(int length1, int length2, int length3)
 * 
 * This method accepts three numeric values each representing the length of one
 * side of a triangle. It returns the Triangle type, "scalene", "isosceles", or "equilateral",
 * where the return value corresponds to the actual type of the triangle.
 * 
 * If the lengths of the sides cannot correspond to a real triangle, then return "invalid"
 */

/* Given an input of 3 integers, which are lengths of the sides of a triangle
 * Classifies the triangle as scalene, isosceles, equilateral, invalid
 * Scalene - no sides equal
 * Isosceles - two sides equal
 * Equilateral - all sides equal
 * Invalid - not a triangle  (sum of any two sides must be greater than the third)
 */

public class KataTriangle {
	
	public String classifyTriangle(int length1, int length2, int length3) {
	
		if (!isTriangle(length1, length2, length3)) {
			return "Invalid";
		}
		if (isScalene(length1, length2, length3)) {
			return "Scalene";
		}
		if (isEquilateral(length1, length2, length3)) {
			return "Equilateral";
		}
		if (isIsosceles(length1, length2, length3)) {
			return "Isosceles";
		}
		return null;
	}
	
	public boolean isTriangle(int length1, int length2, int length3) {
		
		if (length1 < 1 || length2 < 1 || length3 < 1) {
			return false;
		}
		if (length1 + length2 < length3 ||
			length1 + length3 < length2 ||
			length2 + length3 < length1) {
			return false;
		}
		return true;
	}
	
	public boolean isScalene(int length1, int length2, int length3) {
		
		if (length1 != length2 &&
			length1 != length3 &&
			length2 != length3) {
			return true;
			}
		return false;
	}
	
	public boolean isEquilateral(int length1, int length2, int length3) {
		
		if (length1 == length2 &&
			length1 == length3) {
			return true;
		}
		return false;
	}
	
	public boolean isIsosceles(int length1, int length2, int length3) {
		
		if (length1 == length2 ||
			length1 == length3 ||
			length2 == length3) {
			return true;
			}
		return false;
	}
	
}