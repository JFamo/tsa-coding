//imports and package
package TSACoding;
import java.math.BigInteger;
import java.util.*;

public class Problem3 {

	public static void main(String[] args) {
		
		//init variables
		Scanner scan = new Scanner(System.in);
		int numberOfSocks = -1;
		
		//get input
		System.out.print("Enter the number of socks (as an integer): ");
		
		//try-catch statement for wrong data type
		try{
			numberOfSocks = scan.nextInt();
		}catch(InputMismatchException e){
			//do nothing
		}
		
		//only run if number of socks is positive
		if(numberOfSocks >= 0){
			//run program
			System.out.println("Number of different pairs: " + Combination(numberOfSocks,2));
		}
		else{
			System.out.println("Please enter an integer greater than or equal to 0");
		}
		//close scanner
		scan.close();
	}
	
	public static BigInteger Combination(int n, int k){
		//this method returns a combination of N items, K at a time
		
		BigInteger ret;
		ret = Factorial(n-k).multiply(Factorial(k));
		ret = Factorial(n).divide(ret);
		return ret;
		
	}
	
	public static BigInteger Factorial(int n){
		//this method returns the factorial of a BigInteger N
		
		BigInteger ret = BigInteger.valueOf(1); //return value, start at 1
		
		for(int i = n; i > 1; i --){ 
			ret = ret.multiply(BigInteger.valueOf(i)); //multiply by each number lower than the input
		}
		
		return ret; //return the final product
	}

}
