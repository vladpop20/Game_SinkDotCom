package Game;

import Game.Logic.DotComGame;
import Game.Views.GameView;
import Game.Views.InstructionsView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SinkDotComApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sink a Dot Com - Game");
        Label introMessage = new Label("Welcome to the - Deluxe version of Sink a Dot Com" +
                                          "\n\n\nYour goal is to sink three dot coms:" +
                                          "\napple.com, samsung.com, microsoft.com");
        introMessage.setFont(Font.font("Monospaced", 30));
        introMessage.setWrapText(true);

        // Creates the subviews ("layouts")
        InstructionsView instructionsView = new InstructionsView();

        //GameView gameView = new GameView(dotComGame);
        GameView gameView = new GameView();

        // Creates the 3 buttons for menu
        Button instructionsButton = new Button("Instructions");
        Button startButton = new Button("Start");
        Button introButton = new Button("Intro");

        // Creates the 2 layouts
        BorderPane layout = new BorderPane();
        HBox buttonsLayout = new HBox();

        // Adds the buttons to the menu layout
        buttonsLayout.getChildren().addAll(introButton, instructionsButton, startButton);
        buttonsLayout.setPadding(new Insets(10, 10, 10, 10));
        buttonsLayout.setSpacing(10);

        // Connects the subviews(layouts) with the buttons. Clicking menu buttons changes the subview.
        instructionsButton.setOnAction(event -> layout.setCenter(instructionsView.getView()));
        startButton.setOnAction(event -> layout.setCenter(gameView.getView()));
        introButton.setOnAction(event -> layout.setCenter(introMessage));

        // First set the top buttons, and show the intro view
        layout.setTop(buttonsLayout);
        layout.setCenter(introMessage);

        // Creates the main view and add the high level layout
        Scene firstView = new Scene(layout, 920, 800);

        // Shows the application
        primaryStage.setScene(firstView);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

