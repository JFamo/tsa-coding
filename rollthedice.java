package TSACoding;

import java.util.Scanner;
import java.util.ArrayList;

public class RollTheDice {
	public static void main(String args[]){
        //Variables
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer[]> combinations = new ArrayList<Integer[]>();
        int numberOfDice, diceSum, numberOfCombos = 0;
        
        //Input
        System.out.print("Number of Dice: ");
        numberOfDice = scan.nextInt();
        System.out.print("Sum: ");
        diceSum = scan.nextInt();
        
        //Calculations
        if(numberOfDice == 1){
        	System.out.println("Number of possible combinations: 1");	//Escape case for one dice
        	System.out.print("Combinations: (" + diceSum + ")");
        }
        else{
        	for(int diceOneNumber = 1; diceOneNumber <= 6; diceOneNumber ++){
        		for(int diceTwoNumber = 1; diceTwoNumber <= 6; diceTwoNumber ++){
        			if(numberOfDice == 3){								//case for 3 dice
        				for(int diceThreeNumber = 1; diceThreeNumber <= 6; diceThreeNumber ++){
        					if(diceOneNumber + diceTwoNumber + diceThreeNumber == diceSum){	//case for 2 dice
    	            			Integer[] thisCombination = new Integer[3];
    	            			thisCombination[0] = diceOneNumber;
    	            			thisCombination[1] = diceTwoNumber;
    	            			thisCombination[2] = diceThreeNumber;
    	            			combinations.add(thisCombination);
    	            			numberOfCombos ++;
    	            		}
        				}
        			}else{
	            		if(diceOneNumber + diceTwoNumber == diceSum){	//case for 2 dice
	            			Integer[] thisCombination = new Integer[2];
	            			thisCombination[0] = diceOneNumber;
	            			thisCombination[1] = diceTwoNumber;
	            			combinations.add(thisCombination);
	            			numberOfCombos ++;
	            		}
        			}
            	}
        	}
        }
        
        //Output
        if(numberOfDice > 1){
	        System.out.println("Number of possible combinations: " + numberOfCombos);
	        System.out.print("Combinations:");
	        for(Integer[] combination : combinations){
	        	System.out.print(" (");
	        	for(int index = 0; index < combination.length; index ++){
	        		System.out.print(combination[index]);
	        		if(index < combination.length - 1){
	        			System.out.print(", ");
	        		}
	        	}
	        	System.out.print(")");
	        }
        }
        scan.close();
    }
}
