import java.math.BigInteger;
import java.util.Scanner;

public class getPrime {
    public static void main(String args[]) {
        
        //Inp and Vars
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a Number : ");
        BigInteger bi = new BigInteger(scan.nextLine());
        
        System.out.println(bi.isProbablePrime(1));
        
    }
}
