

//package com.mydeveloperplanet.jpmshello;

package com.javacodegeeks.numberToString;

public class numberToString {

	static String units[] = {"","one","two","three","four","five","six","seven","eight","nine"};
	static String teens[] = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String decary[] = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	
    public static void main(String[] args) {
        System.out.println("0 = " + calcNumberToString(0));
        System.out.println("9 = " + calcNumberToString(9));
        System.out.println("10 = " + calcNumberToString(10));
        System.out.println("11 = " + calcNumberToString(11));
        System.out.println("20 = " + calcNumberToString(20));
        System.out.println("40 = " + calcNumberToString(40));
        System.out.println("51 = " + calcNumberToString(51));
        System.out.println("99 = " + calcNumberToString(99));
        System.out.println("100 = " + calcNumberToString(100));
        System.out.println("101 = " + calcNumberToString(101));
        System.out.println("119 = " + calcNumberToString(119));
        System.out.println("129 = " + calcNumberToString(129));
        System.out.println("578 = " + calcNumberToString(578));
        System.out.println("999 = " + calcNumberToString(999));
    }
    
    
    public static String calcNumberToString(int value){
    	String op = null;

    	if ((value < 0) || (value > 999))
    		op = "Invalid value";
    	else if (value == 0)
    		op = "zero";
    	else if (value <= 9)
   			op = units[value];
    	else if (value < 20)
   			op = teens[value-10];
    	else if (value < 100)
    		op = decary[(value / 10 - 1)] + " " + units[value % 10];
    	else {
    		op = units[value / 100] + " hundred ";
    		int remaining = value - ((value/100)*100);
        	if (remaining <= 9)
       			op += units[remaining];
        	else if (remaining < 20)
       			op += teens[remaining-10];
        	else if (remaining < 100)
        		op += decary[(remaining / 10 - 1)] + " " + units[remaining % 10];
    	}
    	
    	return op;
    }
    
    
    
}

