public class KeyboardDistance{
    //main method takes arguments for keyboard layout and target string
    public static void main(String keyboard[], String target){
        int distance = 0;
        
        //loop through the characters of the target string
        for(int i = 0; i < target.length() - 1; i ++){
            //get the current character of the keyboard
            char thisChar = target.charAt(i);
            int[] thisPosition = findCharacter(keyboard, Character.toLowerCase(thisChar));
            
            //if the first character is uppercase
            if(Character.toUpperCase(thisChar) == thisChar && i == 0){
                int[] shiftPosition = findCharacter(keyboard, '^');
                distance += getDistance(shiftPosition[0],shiftPosition[1],thisPosition[0],thisPosition[1]);
            }
            
            //if the next character is uppercase and is not a space
            char nextChar = target.charAt(i+1);
            if(Character.toUpperCase(nextChar) == nextChar && nextChar != ' '){
                int[] shiftPosition = findCharacter(keyboard, '^');
                distance += getDistance(thisPosition[0],thisPosition[1],shiftPosition[0],shiftPosition[1]);
                int[] nextPosition = findCharacter(keyboard, Character.toLowerCase(nextChar));
                distance += getDistance(shiftPosition[0],shiftPosition[1],nextPosition[0],nextPosition[1]);
            }
            else{
                //if the next character is not uppercase
                int[] nextPosition = findCharacter(keyboard, Character.toLowerCase(nextChar));
                distance += getDistance(thisPosition[0],thisPosition[1],nextPosition[0],nextPosition[1]);
            }
        }
        
        //output
        System.out.println(distance);
    }
    
    //method to find the difference between two positions in a 2D array, given the rows and columns of the elements
    //return an integer with the distance between the two elements
    public static int getDistance(int row1,int col1,int row2,int col2){
        int dist = 0;
        while(col1 > col2){
            dist ++;
            col1 --;
        }
        while(col1 < col2){
            dist ++;
            col1 ++;
        }
        while(row1 < row2){
            dist ++;
            row1 ++;
        }
        while(row1 > row2){
            dist ++;
            row1 --;
        }
        return dist;
    }
    
    //method to find a character within a keyboard string array
    //return an integer array with index 0 = row and index 2 = column
    public static int[] findCharacter(String[] keyboard, char find){
        int out[] = new int[2];
        for(int i = 0; i < keyboard.length; i ++){
            String thisRow = keyboard[i];
            for(int q = 0; q < thisRow.length(); q ++){
                if(thisRow.charAt(q) == find){
                    out[0] = i;
                    out[1] = q;
                    return out;
                }
            }
        }
        return null;
    }
}
