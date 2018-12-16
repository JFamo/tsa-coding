package TSACoding;

import java.util.Scanner;

public class Vowels {
	public static void main(String args[]){
        //Variables
        Scanner scan = new Scanner(System.in);
        String inputString, thisSubstring, longestSubstring = "";
        int longestLength = -1, n;
        
        //Input
        System.out.print("String: ");
        inputString = scan.nextLine();
        System.out.print("N: ");
        n = scan.nextInt();
        
        //Iterate Through String
        for(int startIndex = 0; startIndex < inputString.length() - 1; startIndex ++){
        	for(int endIndex = startIndex + 1; endIndex <= inputString.length(); endIndex ++){
        		thisSubstring = inputString.substring(startIndex, endIndex);
        		if(calculateVowels(thisSubstring) == n){
        			if(thisSubstring.length() > longestLength){
        				longestSubstring  = thisSubstring;
        				longestLength = thisSubstring.length();
        			}
        		}
        	}
        }
        
        //Output
        System.out.print("Longest substring: " + longestLength + ", " + longestSubstring);
        scan.close();
    }
	
	//Method to calculate unique vowels in a substring
	public static int calculateVowels(String str){
		int ecount = 0, acount = 0, icount = 0, ucount = 0, ocount = 0;
		for(int index = 0; index < str.length(); index ++){
			if(str.toLowerCase().charAt(index) == 'a'){
				acount ++;
			}
			if(str.toLowerCase().charAt(index) == 'e'){
				ecount ++;
			}
			if(str.toLowerCase().charAt(index) == 'i'){
				icount ++;
			}
			if(str.toLowerCase().charAt(index) == 'o'){
				ocount ++;
			}
			if(str.toLowerCase().charAt(index) == 'u'){
				ucount ++;
			}
		}
		int out = 0;
		if(acount > 0){
			out ++;
		}
		if(ecount > 0){
			out ++;
		}
		if(icount > 0){
			out ++;
		}
		if(ocount > 0){
			out ++;
		}
		if(ucount > 0){
			out ++;
		}
		return out;
	}
}
