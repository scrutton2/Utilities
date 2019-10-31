
package CheckoutSystem;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Locale;

public class CheckoutSystem {

	static ArrayList<String> lCart 	= new ArrayList<String>();

	
	// Return cost of items in cart in pence.
	//
	// Now implementing simple offers logic: 
	// The shop decides to introduce two new offers 
	// - buy one, get one free on Apples
	// - 3 for the price of 2 on Oranges 
    //
	// I will implement this strictly as it says, you buy one, you get next one free
	// not half price like some supermarkets do on single items. Same concept for 3 for 2 also.
	//
	
	static float checkout() {
		float sum = 0;
		String objectInCart;

		boolean nextApplefree = false;
        int orangeGroupCount = 0;      // keep track of oranges counted up to 3

		ListIterator<String> li = lCart.listIterator();
		while (li.hasNext()) {
			objectInCart = li.next();
			if (objectInCart.equals("Apple")) {
				if (nextApplefree) {
					// no charge
			    	System.out.println("Buy one, get one free - Apple");
					nextApplefree = false;
				}
				else {
		 			  sum += .60;
					  nextApplefree = true; // buy one get one free
				}
			}
			if (objectInCart.equals("Orange")) {
  	 			    orangeGroupCount++;
                    if (orangeGroupCount<3) {
     					sum += .25;
                    }
                    else {
    			    	System.out.println("Get 3rd item free after buying 2 - Orange");
                    	orangeGroupCount = 0;
                    }
			}
		}
		return sum;
	}


	public static void addToCart(String ...s) {
		for (String a : s) {
			lCart.add(a);
		}
	}
	
    public static void main(String[] args) {

    	System.out.println("Start of program");

// Testing the logic
//    	addToCart("Apple","Apple","Apple"); // apples(3) = 1.20 (1 free)
//    	addToCart("Orange","Orange","Orange","Orange"); // 0.75 (1 free)
//    	addToCart("Orange","Orange","Orange","Orange","Orange","Orange"); // 1.00
//    	addToCart("Orange","Orange","Orange","Orange","Orange","Orange","Orange"); // 1.25
 
    	addToCart("Apple","Apple","Orange","Apple","Orange","Orange","Orange"); // apples(3) = 1.20 (1 free), oranges(4) = 0.75 (1 free) = 1.95

    	float sum = checkout();

    	NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK);
    	
    	System.out.println("Price of cart contents: " + GBP.format(sum));
    		
    	System.out.println("objects checked out");

    }
    
}
