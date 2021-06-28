package Game.Views;

import Game.Logic.DotComGame;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;

public class GameView {
    private List<Button> buttons = new ArrayList<>();
    private Label statusOfCell = new Label("");
    private static final String alphabet = "abcdefg";
    private DotComGame game;

    public GameView() {
        this.game = new DotComGame();
        this.game.setUpGame();
    }

    public Parent getView() {
        // Creates the game layout, that will hold the Grid made of buttons
        BorderPane gameLayout = new BorderPane();

        // Creates the main grid necessary for this layout
        GridPane sinkDotComGrid = new GridPane();

        // Set the position of components in the game layout
        gameLayout.setCenter(sinkDotComGrid);
        gameLayout.setBottom(statusOfCell);

        // Set the design of components
        this.statusOfCell.setFont(Font.font("Monospaced", 25));
        sinkDotComGrid.setHgap(10);
        sinkDotComGrid.setVgap(10);
        sinkDotComGrid.setPadding(new Insets(10, 10, 10, 10));

        // Creates the buttons, and add them to the list, also assign the formatted text for each one, using 'getFormattedLetter' method
        for (int i = 0; i < 49; i++) {
            buttons.add(this.getButton(getFormattedLetter(i)));
        }

        // Get the buttons from list, and adds them to the grid layout
        int counter = 0;
        while (counter < 48) {
            for (int x = 0; x < 7; x++) {
                for (int y = 0; y < 7; y++) {
                    sinkDotComGrid.add(buttons.get(counter), y, x);
                    counter++;
                }
            }
        }

        return gameLayout;
    }

    public Button getButton(String position) {
        Button button = new Button("");
        button.setMinSize(120, 80);
        button.setFont(Font.font("Monospaced", 30));
        button.setText(position);                                   // set the formated text for every button/cell


        button.setOnMouseClicked((event) -> {
            //System.out.println(position.toLowerCase());           // only for checking the output in console

            if (!game.getStatus()) {                                //checks the user guesses, as long as the game status is false
                this.game.checkUserGuess(position.toLowerCase());   // position is equal to button.getText()
            }

            if (this.game.getTheResult().equals("hit")) {
                button.setText(game.getTheResult());
            } else if (this.game.getTheResult().contains("kill") || this.game.getTheResult().contains("All")) {     // here checks if the kill or finish message, is present
                button.setText("kill");                                                                             // and set only the 'kill' text to the button   (here is a small bug)
            } else {
                button.setText(game.getTheResult());
            }

            this.statusOfCell.setText(this.game.getTheResult());
        });
        return button;
    }

    public String getFormattedLetter(int number) {
        String temp = " ";
        int row = number / 7;
        int collumn = number % 7;

        temp = String.valueOf(this.alphabet.charAt(row));
        temp = temp.toUpperCase().concat(Integer.toString(collumn));

        return temp;
    }


}
