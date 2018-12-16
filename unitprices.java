package TSACoding;

import java.util.Scanner;
import java.util.ArrayList;

public class UnitPrice {
	public static void main(String args[]){
        //Variables
        Scanner scan = new Scanner(System.in);
        int numberOfItems,  cheapestIndex;
        double thisItemWeight, thisItemCost, cheapestPrice;
        double[] unitPrices;
        ArrayList<Integer> tieIndicies = new ArrayList<Integer>();
        boolean hasTie = false;
        
        //Input
        System.out.print("Number of items: ");
        numberOfItems = scan.nextInt();
        unitPrices = new double[numberOfItems];
        
        for(int index = 0; index < numberOfItems; index ++){
        	System.out.print("Weight" + (index + 1) + ": ");
        	thisItemWeight = scan.nextDouble();
        	System.out.print("Cost" + (index + 1) + ": ");
        	thisItemCost = scan.nextDouble();
        	
        	unitPrices[index] = thisItemCost / thisItemWeight;
        }
        
        //Find Cheapest
        cheapestIndex = 0;
        cheapestPrice = unitPrices[0];
        tieIndicies.add(0);
        for(int index = 1; index < numberOfItems; index ++){
        	if(unitPrices[index] == cheapestPrice){
        		hasTie = true;							//save it as a tie
        		tieIndicies.add(index);
        	}
        	else if(unitPrices[index] < cheapestPrice){
        		cheapestIndex = index;					//record the new lowest price
        		cheapestPrice = unitPrices[index];
        		hasTie = false;							//reset my tie-tracking if I find something lower	
        		tieIndicies.clear();
        	}
        }
        
        //Output
        if(hasTie){
        	System.out.print("Answer: items ");
        	for(int tieIndex = 0; tieIndex < tieIndicies.size(); tieIndex ++){
        		System.out.print(tieIndicies.get(tieIndex) + 1);
        		if(tieIndex < tieIndicies.size() - 1){
        			System.out.print(" and ");
        		}
        	}
        	System.out.printf(" are the cheapest at " + "%.2f per ounce", cheapestPrice);
        }else{
        	System.out.printf("Answer: item " + (cheapestIndex + 1) + " is the cheapest at " + "%.2f per ounce", cheapestPrice);
        }
        scan.close();
    }
}
