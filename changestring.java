//imports and package
package TSACoding;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem4 {
	
	public static void main(String args[]){
		
		//init vars
		String inputString = "";
		Scanner scan = new Scanner(System.in);
		
		//get input
		System.out.print("Input a String: ");
		
		try{ //try-catch for wrong data types
			inputString = scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Incorrect data type! Expected a String.");
		}
		
		//output
		System.out.printf("The value of the change is: " + "$%.2f",readChangeString(inputString));
		
		//close Scanner
		scan.close();
		
	}
	
	public static double readChangeString(String useString){
		//this method will read the string and return its total value
		
		double moneyValue = 0.00; //variable to store output
		
		for(int loopString = 0; loopString < useString.length(); loopString ++){ //iterate through the string

			moneyValue += getCharacterValue(useString.charAt(loopString)); //add the value of each character
			
		}
		
		return moneyValue; //return the string's monetary value
	}
	
	public static double getCharacterValue(char useChar){
		//this method will get the monetary value of a character
		
		useChar = Character.toUpperCase(useChar);
		
		switch(useChar){
		case 'P' :
			return 0.01; //if a penny, return 0.01
		case 'N' :
			return 0.05; //if a nickel, return 0.05
		case 'D' :
			return 0.10; //if a dime, return 0.10
		case 'Q' :
			return 0.25; //if a quarter, return 0.25
		}
		
		return 0.00; //error handling - if not any of the above then return 0, because it is not a coin and has no value
		
	}
}
