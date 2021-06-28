package Game.Logic;

import java.util.ArrayList;

public class DotCom {
    public ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> cellLocations) {         // A setter method that update the DotCom's location
        locationCells = cellLocations;                                      // (Random location provided by GameHelper placeDotCom() method.)
    }

    public String checkYourself(String userInput) {
        String result = "miss";
                                                                            // The ArrayList indexOf() method in action! If the user guess is one
        int index = locationCells.indexOf(userInput);                       // of the entries in the ArrayList, indexOf will return its ArrayList location.
                                                                            // If not, indexOf will return -1.
        if (index >= 0) {
            locationCells.remove(index);                                    // Using ArrayList's remove() method to dele an entry.

            if (locationCells.isEmpty()) {                                  // Using the isEmpty() method to see if all of the location have been guessed.
                result = "kill";
            } else {
                result = "hit";
            }
        }

        return result;                                                      // Return 'miss' or 'hit' or 'kill'.
    }

    public void setName(String dotName) {
        this.name = dotName;
    }

    public String getName() {
        return name;
    }
}
