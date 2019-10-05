

//package com.mydeveloperplanet.jpmshello;

package com.javacodegeeks.hello;

public class IntegerToHexString {

    public static void main(String[] args) {
    	  	    	
//       Integer test_value = 35; // 23 (2 * 16 + 3)
//       Integer test_value = 15; // F
//        Integer test_value = 31; // 1F
//      Integer test_value = 255;   // FF
      Integer test_value = 4079;  // FEF
        
        String hString = IntToHexString(test_value);

        System.out.print("Integer value " + test_value + " converted to hex string = " + hString);
        
    }

    // Use Java method which does this automatically.
    // I have listed this here, and would use this but the point of this exercise was
    // to explore ways to code this up without using a high level function
/*
    private static String IntToHexString(Integer test_value) {
		
		String hex_count_string = "";

		hex_count_string = Integer.toHexString(test_value);
		
		return hex_count_string;
	}
*/
    
	// Do it more manually as surely this was intent of exercise
	private static String IntToHexString(Integer test_value) {

// using an example value
//      Integer test_value = 255;   // FF
//			255 / 16 = 15 (F)
//			255 = (15*16) + F


		Integer hex_count;

		String op_string = "";

		String remainder_string = "";

		while (test_value > 16)
		{
			hex_count = test_value / 16;

			// Could use this...but we won't this time, as we are doing this using lower level code.
			// hex_count_string = Integer.toHexString(hex_count);

			if (hex_count <= 15)
				op_string += IToHString(hex_count);
			else
				op_string += IntToHexString(hex_count);	// Using recursion
				
	//		System.out.print(" op_string = " + op_string);

			test_value -= (hex_count *16);
		}

		Integer remainder = test_value % 16;

		remainder_string = IToHString(remainder);

		op_string += remainder_string;
		
		return op_string;
	}

	private static String IToHString(Integer IntVal) {

	String hex_count_string = "";
	if (IntVal <= 9)
		hex_count_string = IntVal.toString();
	else
		if (IntVal.equals(10))
			hex_count_string = "a";
		else
			if (IntVal.equals(11))
				hex_count_string = "b";
			else
				if (IntVal.equals(12))
					hex_count_string = "c";
				else
					if (IntVal.equals(13))
						hex_count_string = "d";
					else
						if (IntVal.equals(14))
							hex_count_string = "e";
						else
							if (IntVal.equals(15))
								hex_count_string = "f";
	return hex_count_string;
	}

}

