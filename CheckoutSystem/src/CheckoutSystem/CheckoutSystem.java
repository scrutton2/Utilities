
package CheckoutSystem;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

public class CheckoutSystem {

	static ArrayList<String> lCart 	= new ArrayList<String>();

	
	// Return cost of items in cart in pence.
	static float checkout() {
		float sum = 0;
		String objectInCart;
		
		ListIterator<String> li = lCart.listIterator();
		while (li.hasNext()) {
			objectInCart = li.next();
			if (objectInCart.equals("Apple"))
					sum += .60;
			if (objectInCart.equals("Orange"))
					sum += .25;
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

    	addToCart("Apple","Apple","Orange","Apple");

    	float sum = checkout();

    	NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK);
    	
    	System.out.println("Price of cart contents: " + GBP.format(sum));
    		
    	System.out.println("objects checked out");

    }
    
}
