package Game.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class InstructionsView {

    public InstructionsView(){

    }

    public Parent getView() {
        VBox instructionLayout = new VBox();

        Label instructionText1 = new Label("Sink all the computer's Dot Coms in the fewest number of guesses. You'll need to choose 3 cells, where you suspect the Dot Coms live.");
        Label instructionText2 = new Label("Depending on the choice made, you will see a result marked with X, if the cell was hit, or vice versa, a message will be displayed marking that you missed the correct cell.");
        Label instructionText3 = new Label("If you hit all 3 cells that make up the Dot Coms, which can be placed horizontally or vertically, you will see the message that you have finished that Dot Com");
        instructionText1.setWrapText(true);
        instructionText2.setWrapText(true);
        instructionText3.setWrapText(true);
        instructionText1.setFont(Font.font("Monospaced", 20));
        instructionText2.setFont(Font.font("Monospaced", 20));
        instructionText3.setFont(Font.font("Monospaced", 20));

        instructionLayout.getChildren().addAll(instructionText1, instructionText2, instructionText3);
        instructionLayout.setSpacing(10);
        instructionLayout.setPadding(new Insets(10, 10, 10, 10));
        instructionLayout.setAlignment(Pos.CENTER);

        return instructionLayout;
    }

}
