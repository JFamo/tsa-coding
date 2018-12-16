 /**
 * @author 2004-901
 * Program 2 - Letter Map
 * 4/19/2018
 *
 */
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class LetterMap {
    public static void main(String[][] letterMap){
    	
    	//variables
        ArrayList<String> paths = new ArrayList<String>();
        
        //try each possible value in the array
        for(int row = 0; row < letterMap.length; row ++){
            for(int col = 0; col < letterMap[row].length; col ++){
                HashMap usedMap = new HashMap<String, Boolean>();
                 for(int i = 0; i < letterMap.length; i ++){
                    for(int q = 0; q < letterMap[i].length; q ++){
                        String concat = i + "" + q;
                        usedMap.put(concat, false);
                    }
                }
                paths.add(bigPath(letterMap, "", row, col, usedMap));
            }
        }
        
        //print output
        System.out.println("Longest Paths for each Letter : ");
        int longestL = 0;
        String longestS = "";
        for(int i = paths.size() - 1; i >= 0; i --){
            System.out.println(paths.get(i));
            if(paths.get(i).length() > longestL){
                longestL = paths.get(i).length();
                longestS = paths.get(i);
            }
        }
        
        System.out.println("Longest Path : " + longestS);
    }
    
    public static String bigPath(String[][] letterMap, String thisPath, int row, int col, HashMap<String, Boolean> usedMap){
        thisPath = thisPath + "" + letterMap[row][col];
        String thisPos = row + "" + col;
        HashMap used = new HashMap<String, Boolean>();
                for(int i = 0; i < letterMap.length; i ++){
                    for(int q = 0; q < letterMap[i].length; q ++){
                        String concat = i + "" + q;
                        used.put(concat, usedMap.get(concat));
                    }
                }
        used.put(thisPos, true);
        String[] potentials = new String[4];
        potentials[0] = "";
        potentials[1] = "";
        potentials[2] = "";
        potentials[3] = "";
        
        //if i could move down
        if(row < letterMap.length - 1){
            //if it is a different letter
            if(!letterMap[row+1][col].equals(letterMap[row][col])){
                //if we have not used this already
                if(!(boolean)used.get((row+1) + "" + col)){
                    potentials[0] = bigPath(letterMap, thisPath, row+1, col, used);
                }
            }
        }
        //if i could move up
        if(row > 0){
            //if it is a different letter
            if(!letterMap[row-1][col].equals(letterMap[row][col])){
                //if we have not used this already
                if(!(boolean)used.get((row-1) + "" + col)){
                    potentials[1] = bigPath(letterMap, thisPath, row-1, col, used);
                }
            }
        }
        //if i could move right
        if(col < letterMap[row].length - 1){
            //if it is a different letter
            if(!letterMap[row][col+1].equals(letterMap[row][col])){
                //if we have not used this already
                if(!(boolean)used.get((row) + "" + (col+1))){
                    potentials[2] = bigPath(letterMap, thisPath, row, col+1, used);
                }
            }
        }
        //if i could move left
        if(col > 0){
            //if it is a different letter
            if(!letterMap[row][col-1].equals(letterMap[row][col])){
                //if we have not used this already
                if(!(boolean)used.get((row) + "" + (col-1))){
                    potentials[3] = bigPath(letterMap, thisPath, row, col-1, used);
                }
            }
        }
        
        //figure out which will result in the biggest path, continue with that
        if(potentials[0].equals("") && potentials[1].equals("") && potentials[2].equals("") && potentials[3].equals("")){
            used.put(thisPos, false);
            return thisPath;
        }
        else{
            int overrideLargest = -1;
            for(int uno = 0; uno < 4; uno ++){
               for(int dos = 0; dos < 4; dos ++){ 
                   if(uno != dos){
                       if(potentials[uno].length() == potentials[dos].length() && potentials[uno].length() > 0){
                           if(potentials[uno].compareTo(potentials[dos]) > 0){
                               overrideLargest = uno;
                            }
                            else{
                                overrideLargest = dos;
                            }
                        }
                    }
                }
            }
            if(overrideLargest >= 0){
                if(overrideLargest == 0){
                    return bigPath(letterMap, thisPath, row+1, col, used);
                }
                else if(overrideLargest == 1){
                    return bigPath(letterMap, thisPath, row-1, col, used);
                }else if(overrideLargest == 2){
                    return bigPath(letterMap, thisPath, row, col+1, used);
                }else{
                    return bigPath(letterMap, thisPath, row, col-1, used);
                }
            }
            else{
                int largest = Math.max(Math.max(potentials[3].length(),potentials[2].length()), Math.max(potentials[1].length(), potentials[0].length()));
                if(largest == potentials[0].length()){
                    return bigPath(letterMap, thisPath, row+1, col, used);
                }
                else if(largest == potentials[1].length()){
                    return bigPath(letterMap, thisPath, row-1, col, used);
                }
                else if(largest == potentials[2].length()){
                    return bigPath(letterMap, thisPath, row, col+1, used);
                }
                else{
                    return bigPath(letterMap, thisPath, row, col-1, used);
                }
            }
        }
    }
}
