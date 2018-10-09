

package com.javacodegeeks.base9;

public class base9conversion {

    public static void main(String[] args) {

        // some test values to test the code
        System.out.println ("7 in base 10 = " + base9(7L) + " in base 9");		// should be 7 (base 9)
        System.out.println ("11 in base 10 = " + base9(11L) + " in base 9");	// should be 12 (base 9)
        System.out.println("22 in base 10 = "  + base9(22L) + " in base 9");    // should be 24 (base 9)
        System.out.println("300 in base 10 = " + base9(300L) + " in base 9");    // should be 363 (base 9)
    }
    
    private static String base9(Long number_to_convert) {
    	
    	/*
    	 * Trying some numbers to figure out the algorithm 
    	 * 
    	 * eg. 11
		 *
		 * 11/9 = 1 remainder 2. So, you write down the remainder. Then you take the whole value and repeat operation.
		 * 1/9 = 0 remainder 1. So, you write down 1 in front of rest of number.
		 * = 12
	     *
		 * eg 22
		 * 22/9 = 2 remainder 4. So you write down the remainder. Then you take the whole value and repeat operation.
	     * 2/9 = 0 remainder 2. So you write done the remainder in front of rest of number
		 * = 24
		 * 
		 * eg 300
		 * 
		 * 300/9 = 33 remainder 3. So you write down the remainder (3). Then you take the whole value and repeat operation.
		 * 33 / 9 = 3 remainder 6. So, you write down the remainder 6. Then you take the whole value and repeat operation.
		 * 3 / 9 = 0 remainder 3. So, you write down 3.
		 * 	= 363
		 * 
		 * Easiest way to implement this is to build string and insert chars from left.
		 * 
    	 */

    	Long remainder = 0L;
    	Long multiple_of_base = 0L;
    	Long base = 9L; // may as well make this somewhat re-usable if we need to code for another base in future;
    	
    	StringBuilder op_string = new StringBuilder();
    	while (number_to_convert > 0) {
    		remainder = number_to_convert % base;
    		multiple_of_base = number_to_convert / base;
    		number_to_convert = multiple_of_base;			// This is the next value to examine and divide.
    		// Now we need to generate the o/p string
    		// We need to insert the remainder values in the left side of the string,
    		// as each time through the loop, we'll be going up a level of base (9);
    		op_string.insert(0, remainder.toString());
    	}
    		
    	return op_string.toString();
 	}
    
    
}

