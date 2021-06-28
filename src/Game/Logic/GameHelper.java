package Game.Logic;

import java.util.ArrayList;

public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public ArrayList<String> placeDotCom(int comSize) {                 // line 13
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize];       // holds 'f6' type coords
        String temp = null;                                // temporary String for concat
        int[] coords = new int[comSize];                   // current candidate coords
        int attempts = 0;                                  // current attempts counter
        boolean success = false;                           // flag = found a good location ?
        int location = 0;                                  // current starting location

        comCount++;                                        // nth dot com to place
        int incr = 1;                                      // set horizontal increment
        if ((comCount % 2) == 1) {                         // if odd dot com  (place vertically)
            incr = gridLength;                               // set vertical increment
        }

        while (!success & attempts++ < 200) {             // main search loop  (28)
            location = (int) (Math.random() * gridSize);      // get random starting point
            // System.out.print(" try " + location);		   // code testing point  (( X X ))
            int x = 0;                                        // nth position in dotcom to place
            success = true;                                 // assume success
            while (success && x < comSize) {                // look for adjacent unused spots
                if (grid[location] == 0) {                    // if not already used
                    coords[x] = location;                      // save location
                    x++;
                    location += incr;                          // try 'next' adjacent
                    if (location >= gridSize) {                 // out of bounds - 'bottom'
                        success = false;                         // failure
                    }
                    if (x > 0 & (location % gridLength == 0)) {  // out of bounds - right edge
                        success = false;                         // failure
                    }
                } else {                                      // found already used location
                    // System.out.print(" used " + location);  // code testing point  (( X X ))
                    success = false;                          // failure
                }
            }
        }                                                   // end while

        int x = 0;                                          // turn good location into alpha coords
        int row = 0;
        int column = 0;
        System.out.println("\n");
        while (x < comSize) {
            grid[coords[x]] = 1;                              // mark master grid pts. as 'used'
            row = (int) (coords[x] / gridLength);             // get row value
            column = coords[x] % gridLength;                  // get numeric column value
            temp = String.valueOf(alphabet.charAt(row));      // convert to alpha

            alphaCells.add(temp.concat(Integer.toString(column)));
            x++;

            //System.out.print("  coord "+ x +" = " + alphaCells.get(x-1));  // code testing point  (( XX ))

        }
        System.out.println("\n");

        return alphaCells;
    }
}
