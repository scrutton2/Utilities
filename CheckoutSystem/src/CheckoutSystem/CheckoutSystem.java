
package CheckoutSystem;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Locale;

class ShopItem{
	private String name;
	private float price;
	
	public ShopItem(String name,float price){
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}

class ShopInventory{
   HashMap<String, Float> InventoryList = new HashMap<String, Float>();

   public void buildOutStore() {
     addItems();
   }
   
   private void addItems(){
   		// could read this from a file
	   ShopItem aShopItem = new ShopItem("Apple", (float) 0.60);
	   InventoryList.put(aShopItem.getName(),aShopItem.getPrice());

	   ShopItem aShopItem2 = new ShopItem("Orange", (float) 0.25);
	   InventoryList.put(aShopItem2.getName(),aShopItem2.getPrice());
   }
}


public class CheckoutSystem {

	static ArrayList<String> lCart 	= new ArrayList<String>();	// Cart contents - names of store items in cart.
	
	// Return cost of items in cart in pence.
	//
	
	static float checkout(ShopInventory shopInv) {
		float sum = 0;
		String objectInCart;

		ListIterator<String> li = lCart.listIterator();
		while (li.hasNext()) {
			objectInCart = li.next();
			
			if (shopInv.InventoryList.containsKey(objectInCart)) {
				sum += shopInv.InventoryList.get(objectInCart);
			}
			
		}
		return sum;
	}

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
	
	static float checkout_discount_applied(ShopInventory shopInv) {
		float sum = 0;
		String objectInCart;

		boolean nextApplefree = false;
        int orangeGroupCount = 0;      // keep track of oranges counted up to 3

		ListIterator<String> li = lCart.listIterator();
		while (li.hasNext()) {
			objectInCart = li.next();
			
			if (shopInv.InventoryList.containsKey(objectInCart)) {

				if (objectInCart.equals("Apple")) {
					if (nextApplefree) {
					// no charge
						System.out.println("Discount - Buy one, get one free - Apple");
						nextApplefree = false;
					}
					else {
  					  sum += shopInv.InventoryList.get(objectInCart);
  					  nextApplefree = true; // buy one get one free
					}
				}
				
				if (objectInCart.equals("Orange")) {
  	 			    orangeGroupCount++;
                    if (orangeGroupCount<3) {
        				sum += shopInv.InventoryList.get(objectInCart);
                    }
                    else {
    			    	System.out.println("Discount - Get 3rd item free after buying 2 - Orange");
                    	orangeGroupCount = 0;
                    }
				}
			}			
		}
		return sum;
	}


	public static void addToCart(String ...s) {
		for (String a : s) {
			lCart.add(a);			// stores cart contents in a list
		}
	}
	
    public static void main(String[] args) {

    	// Build out the shop inventory
    	// 
    	ShopInventory shopInv = new ShopInventory();
    	shopInv.buildOutStore();

    	NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK);


    	// Add Items to cart
    	//
    	// Expected results:
    	// full pricing 
    	// apples(3) = 1.80 oranges (4) = 1.00 Total = 2.80
    	//
    	// discounted pricing
    	// apples(3) = 1.20 (1 free), oranges(4) = 0.75 (1 free) Total = 1.95
    	addToCart("Apple","Apple","Orange","Apple","Orange","Orange","Orange");

    	float sum = checkout(shopInv);
    	System.out.println("Full pricing. Price of cart contents: " + GBP.format(sum));
    		
    	System.out.println("\nDiscount applied.");
    	
    	float sum2 = checkout_discount_applied(shopInv);
    	System.out.println("Price of cart contents: " + GBP.format(sum2));
    		
    }
    
}
