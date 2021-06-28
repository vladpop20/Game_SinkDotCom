package Game.Logic;

import java.util.ArrayList;

public class DotComGame {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;
    private String theResult = "miss";
    private boolean gameStatus = false;

    public void setUpGame() {
        DotCom theFirstDot = new DotCom();
        DotCom theSecondDot = new DotCom();
        DotCom theThirdDot = new DotCom();
        theFirstDot.setName("apple.com");
        theSecondDot.setName("samsung.com");
        theThirdDot.setName("microsoft.com");

        dotComsList.add(theFirstDot);
        dotComsList.add(theSecondDot);
        dotComsList.add(theThirdDot);

        for (DotCom dotComSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComSet.setLocationCells(newLocation);

            //System.out.println("DotCom location at -> " + dotComSet.locationCells);               // only for checking the output in console
        }
    }

    public void checkUserGuess(String userGuess) {                          // This 'userGuess' String, we get the user guess by reading the text assigned to the button
        numOfGuesses++;

        for (DotCom dotComToTest : this.dotComsList) {                      // Repeat will all DotComs in the list
            String name = dotComToTest.getName();
            setTheResult(dotComToTest.checkYourself(userGuess));            // Ask the DotCom to check the userGuess, loking for a 'hit' or 'kill' in return.

            if (getTheResult().equals("hit")) {
                break;
            } else if (getTheResult().equals("kill")) {
                setTheResult(getTheResult().concat("\nOuch! You sunk " + name + "   :("));
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        if (this.dotComsList.isEmpty()) {
            setTheResult(finishGame());
        }
    }

    public void setTheResult(String result) {
        this.theResult = result;
    }

    public String getTheResult() {
        return this.theResult;
    }

    public String finishGame() {
        String finish = "All Dot Coms are dead!";

        if (numOfGuesses <= 18) {
            finish = finish.concat("\nIt only took you " + numOfGuesses + " guesses.\nYou got out before your options sank.");
        } else {
            finish = finish.concat("\nTook you long enough. It was about time -> " + numOfGuesses + " guesses.");
        }
        this.setStatus(true);
        return finish;
    }

    public void setStatus(boolean state) {
        this.gameStatus = state;
    }

    public boolean getStatus() {
        return this.gameStatus;
    }
}
