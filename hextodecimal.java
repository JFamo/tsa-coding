package TSACoding;

import java.util.Scanner;

public class Converter {
    public static void main(String args[]){
        //Variables
        Scanner scan = new Scanner(System.in);
        String hexidecimalInput;
        int decimalOutput = 0, thisPower, thisValue;
        
        //Input
        System.out.print("Enter hexadecimal number: ");
        hexidecimalInput = scan.nextLine();
        
        //Conversion
        hexidecimalInput = hexidecimalInput.substring(2);	//strip the 0x
        for(int index = 0; index < hexidecimalInput.length(); index ++){
        	
        	//Get the power of 16 at this position
        	thisPower = (int)Math.pow(16, hexidecimalInput.length() - index - 1);
        	
        	//Check for A-F
        	if(Character.isLetter(hexidecimalInput.charAt(index))){
        		thisValue = (int)hexidecimalInput.charAt(index) - 55;
        	}
        	else{
        		thisValue = Integer.parseInt(hexidecimalInput.substring(index, index + 1));
        	}
        	
        	//Multiply value by power, add to decimal
        	decimalOutput += thisValue * thisPower;
        }
        
        //Output
        System.out.print("In decimal: " + decimalOutput);
        scan.close();
    }
}
