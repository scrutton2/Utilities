

//package com.mydeveloperplanet.jpmshello;

package com.javacodegeeks.maxProfit;

public class maxProfit {


    public static void main(String[] args) {
    	Integer[] StockPrices = {5,4,3,2,5,8,9,4,22,15};	// expect 2-> 22 = 20
    	System.out.println("Maximum profit = " + calcMaxProfit(StockPrices));

    	Integer[] StockPrices2 = {34,25,8,9,4,6,15};		// expect 4-> 15 = 11
    	System.out.println("Maximum profit = " + calcMaxProfit(StockPrices2));

    	Integer[] StockPrices3 = {35,4,3,2,5,8,9};			// expect 2-> 9 = 7
    	System.out.println("Maximum profit = " + calcMaxProfit(StockPrices3));

    	Integer[] StockPrices4 = {5,4,3,2,5,8,9,4,22};		// expect 2 -> 22 = 20
    	System.out.println("Maximum profit = " + calcMaxProfit(StockPrices4));

    	Integer[] StockPrices5 = {5,4,3,2,5,8,5,1,3};		// expect 2 -> 8 = 6
    	System.out.println("Maximum profit = " + calcMaxProfit(StockPrices5));

    }
    
    
    public static Integer calcMaxProfit(Integer[] prices){
    	Integer maxProfit = 0;
    	Integer profit = 0;
    	
    	for (int buyIndex=0;buyIndex<=prices.length-2;buyIndex++) {
    		for (int sellIndex = buyIndex + 1;sellIndex<=prices.length-1;sellIndex++) {
 
    			profit = prices[sellIndex] - prices[buyIndex];

    			if (profit > maxProfit)
    				maxProfit = profit;
    		}
    	}
    	
    	return maxProfit;
    }
    
    
    
}

