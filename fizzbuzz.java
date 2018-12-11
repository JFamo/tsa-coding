import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        
        //Inp and Vars
        System.out.println("Enter string:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int maxlength = str.length() - 3;
        
        //Loop Str
        for(int index=0;index<maxlength;index++){
            if(str.substring(index, index + 4).toLowerCase().equals("fizz")){
                str = str.substring(0,index) + "fi3zz" + str.substring(index + 4, str.length());
                index++; maxlength++;
            }
            else if(str.substring(index, index + 4).toLowerCase().equals("buzz")){
                str = str.substring(0,index) + "5" + str.substring(index + 4, str.length());
                maxlength -= 3;
            }
        }
        
        //Output
        System.out.println(str);
    }
}
