package TSACoding;

import java.util.Scanner;
import java.util.ArrayList;

public class Palindrome {
	public static void main(String args[]){
        //Variables
        Scanner scan = new Scanner(System.in);
        String inputString, thisSubstring;
        int palindromeCount = 0;
        ArrayList<String> palindromes = new ArrayList<String>();
        
        //Input
        System.out.print("String: ");
        inputString = scan.nextLine();
        
        //Iterate Through String
        for(int startIndex = 0; startIndex < inputString.length() - 2; startIndex ++){
        	for(int endIndex = startIndex + 2; endIndex <= inputString.length(); endIndex ++){
        		thisSubstring = inputString.substring(startIndex, endIndex);
        		if(checkPalindrome(thisSubstring)){
        			palindromes.add(thisSubstring);
        			palindromeCount ++;
        		}
        	}
        }
        
        //Output
        System.out.println("Count: " + palindromeCount);
        if(palindromeCount <= 0){
        	System.out.print("No palindrome substrings found");
        }
        else{
        	System.out.print("Substrings:");
        }
        for(int q = 0; q < palindromes.size(); q ++){
        for(int i = 0; i < palindromes.size()-1; i ++){
        	if(palindromes.get(i).length() == palindromes.get(i+1).length()){
        		if(palindromes.get(i).compareTo(palindromes.get(i+1)) > 0){
        			String temp = palindromes.get(i+1);
        			palindromes.set(i+1, palindromes.get(i));
        			palindromes.set(i, temp);
        		}
        	}
        	else{
        		if(palindromes.get(i).length() > palindromes.get(i+1).length()){
        			String temp = palindromes.get(i+1);
        			palindromes.set(i+1, palindromes.get(i));
        			palindromes.set(i, temp);
        		}
        			
        	}
        }
        }
        for(String palindrome : palindromes){
    		System.out.print(" " + palindrome);
    	}
        scan.close();
    }
	
	public static boolean checkPalindrome(String str){
	    int indexOne = 0;
	    int indexTwo = str.length() - 1;
	    while (indexTwo > indexOne) {
	        if (str.charAt(indexOne) != str.charAt(indexTwo)) {
	            return false;
	        }
	        ++indexOne;
	        --indexTwo;
	    }
	    return true;
	}

}
