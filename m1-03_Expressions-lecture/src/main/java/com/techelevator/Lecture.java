package com.techelevator;

public class Lecture {
    /*
    1. This method is named returnNotOne and it returns an int. Change
    it so that it returns something other than a 1.
    */
    public int returnNotOne() {
<<<<<<< HEAD
        return 2;
=======
        return 1 + 1;
>>>>>>> 8baf4ef6f726ba34c25c1b2bc4a05892bfc87d4d
    }

    /*
    2. This method is named returnNotHalf and it returns a double. Change
    it so that it returns something other than a 0.5.
    */
    public double returnNotHalf() {
<<<<<<< HEAD
        double notHalf = 0.69359835093473598497487493759383859389483938404585494;
=======
    	double notHalf = 0.6;
>>>>>>> 8baf4ef6f726ba34c25c1b2bc4a05892bfc87d4d
        return notHalf;
    }

    /*
    3. This method needs to return a String. Fix it to return a valid String.
    */
    public String returnName() {
        return "null";
    }

    /*
    4. This method currently returns an int. Change it so that it returns a double.
    */
    public double returnDoubleOfTwo() {
        return 2.0;
    }

    /*
    5. This method should return the language that you're learning. Change
    it so that it does that.
    */
    public String returnNameOfLanguage() {
<<<<<<< HEAD
    	String nameOfLanguage = "Java";
        return nameOfLanguage;
=======
    	String nameOfLangauge = "Java";
        return nameOfLangauge;
>>>>>>> 8baf4ef6f726ba34c25c1b2bc4a05892bfc87d4d
    }

    /*
    6. This method uses an if statement to define what to return. Have it
    return true if the if statement passes.
    */
    public boolean returnTrueFromIf() {
        if(true) {
            return true;
        }

        return false;
    }

    /*
    7. This method uses an if to check to make sure that one is equal
    to one. Make sure it returns true when one equals one.
    */
    public boolean returnTrueWhenOneEqualsOne() {
        if(1 == 1) {
            return true;
        }

        return false;
    }

    /*
    8. This method checks a parameter passed to the method to see if it's
    greater than 5 and returns true if it is.
    */
    public boolean returnTrueWhenGreaterThanFive(int number) {
        if(number > 5) {
<<<<<<< HEAD
        	
        return true;

        } 
        
=======
        	return true;
        } 
>>>>>>> 8baf4ef6f726ba34c25c1b2bc4a05892bfc87d4d
        return false;
    }

    /*
    9. If you think about it, we really don't need the if statement above.
    How can we rewrite exercise 8 to have only one line of code?
    */
    public boolean returnTrueWhenGreaterThanFiveInOneLine(int number) {
        return number > 5; // What can we put here that returns a boolean that we want?
    }

    /*
    10. This method will take a number and do the following things to it:
    * If addThree is true, we'll add three to that number
    * If addFive is true, we'll add five to that number
    * We'll then return the result
    */
    public int returnNumberAfterAddThreeAndAddFive(int number, boolean addThree, boolean addFive) {
        if(addThree) {
            number = number + 3;
        }

        // We can't use an else here. They could both be true, so we have to check each one.

        if(addFive) {
<<<<<<< HEAD
            number = number + 5;
=======
            number += 5;
>>>>>>> 8baf4ef6f726ba34c25c1b2bc4a05892bfc87d4d
        }

        return number;
    }

    /*
    11. Write an if statement that returns "Fizz" if the parameter is 3 and returns an empty String for anything else.
    */
    public String returnFizzIfThree(int number) {
    	if (number == 3) {
<<<<<<< HEAD
    }
        return "Fizz";
=======
    		return "Fizz";
    	}
        return "";
>>>>>>> 8baf4ef6f726ba34c25c1b2bc4a05892bfc87d4d
    }

    /*
    12. Now write the above using the Ternary operator ?:. If you're not sure what this is, you can Google it.
    */
    public String returnFizzIfThreeUsingTernary(int number) {
        return number == 3 ? "Fizz" : "";
    }

    /*
    13. Write an if/else statement that returns "Fizz" if the parameter is 3, "Buzz" if the parameter is 5 and an empty String for anything else.
    */
    public String returnFizzOrBuzzOrNothing(int number) {
<<<<<<< HEAD
    	
=======
        
>>>>>>> 8baf4ef6f726ba34c25c1b2bc4a05892bfc87d4d
    	if (number == 3) {
    		return "Fizz";
    	} else if (number == 5) {
    		return "Buzz";
    	} else {
    		return "";
    	}
    	
    }

    /*
    14. Write an if statement that checks if the parameter number is either equal to or greater than 18. Return "Adult" if it is or "Minor" if it's not.
    */
    public String returnAdultOrMinor(int number) {
        if(number >= 18) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    15. Now, do it again with a different boolean operation.
    */
    public String returnAdultOrMinorAgain(int number) {
<<<<<<< HEAD
        if(number > 17) {
=======
        if(number > 17) {   //if (!(number < 18)
>>>>>>> 8baf4ef6f726ba34c25c1b2bc4a05892bfc87d4d
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    16. Return as above, but also return "Teen" if the number is between 13 and 17 inclusive.
    */
    public String returnAdultOrMinorOrTeen(int number) {            
        if(number >= 18) {
            return "Adult";
<<<<<<< HEAD
        } else if(number >= 13 && number < 18) {
=======
        } else if(number >= 13 && number <= 17) {
>>>>>>> 8baf4ef6f726ba34c25c1b2bc4a05892bfc87d4d
            return "Teen";
        } else {
            return "Minor";
        }
    }
        
}