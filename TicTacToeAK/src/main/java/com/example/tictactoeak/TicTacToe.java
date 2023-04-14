package com.example.tictactoeak;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToe extends Application {
    private boolean playerXTurn = true;
    private Button buttons[][] = new Button[3][3];
    private Label playerXScoreLabel, playerOScoreLabel;
    private int playerXScore = 0, playerOScore = 0;
    private BorderPane createContent (){
        BorderPane root = new BorderPane();// border pane allows us to lay our layouts in the top, bottom, center, up and right
        root.setStyle("-fx-background-color: white;"); //setting the background color
        root.setPadding(new Insets(20)); // gives extra space to the pane from each border
        //Title
        Image ttt = new Image("C:\\Java Projects Acciojob\\TicTacToeAK\\src\\main\\preview@2x.png");
        ImageView tttIV = new ImageView(ttt);
        tttIV.setFitWidth(360);
        tttIV.setFitHeight(150);
        Label titleLabel = new Label("", tttIV); // setting tic tac toe font image as the title
        root.setTop(titleLabel);
        //Game Board
        GridPane gridPane = new GridPane(); // by using gridpane we will make a grid of buttons
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setPrefSize(120, 120); //setting button size
                button.setStyle("-fx-font-size: 28pt; -fx-font-weight: bold;");
                button.setOnAction(event->buttonClicked(button)); //enables an event and calls the button click function so when we press a button it will
                                                                    // change its text to X or O
                buttons[i][j] = button;
                gridPane.add(button, j, i); //adding the button to our gridpane, while adding to the gridpane column is added first
            }
        }

        root.setCenter(gridPane);

        //creating the scoreboard
        HBox scoreBoard = new HBox(20);
        playerXScoreLabel = new Label("Player X: 0");
        playerXScoreLabel.setStyle("-fx-font-size: 25pt; -fx-font-weight: bold;");
        playerOScoreLabel = new Label("Player O: 0");
        playerOScoreLabel.setStyle("-fx-font-size: 25pt; -fx-font-weight: bold;");
        scoreBoard.getChildren().addAll(playerXScoreLabel, playerOScoreLabel);
        root.setBottom(scoreBoard);
        return root;
    }

    private void buttonClicked(Button button) {
        //function to make the button as X or O when we click the button
        if (button.getText().equals("")) {
            if (playerXTurn) button.setText("X"); // if it is X's turn then set the button to X
            else button.setText("O");
            playerXTurn = !playerXTurn; // reversing the state of player X's turn
            checkWinner();
        }
        return;
    }

    private void checkWinner () {
        //checking row
        for (int row = 0; row< 3; row++) {
            if (buttons[row][0].getText().equals(buttons[row][1].getText()) && //checking if the text at the first col is same as the text on second col
                buttons[row][1].getText().equals(buttons[row][2].getText()) && //checking if the text at the second col is same as the text on third col
                !buttons[row][0].getText().isEmpty() // we dont want the text to be blank because all three could be blank as well
            ) {
                // we have a winner
                String winner = buttons[row][0].getText(); // the winner is the text contained in the button
                showWinnerDialog(winner); //calling the method to show the alert
                updateScore(winner); // calling function to update score board
                resetBoard(); // calling the method to reset the board to empty values
                return;
            }
        }
        //col
        for (int col = 0; col < 3; col++) {
            if (buttons[0][col].getText().equals(buttons[1][col].getText()) && //checking if the text at the first row is same as the text on second row
                    buttons[1][col].getText().equals(buttons[2][col].getText()) && //checking if the text at the second row is same as the text on third row
                    !buttons[0][col].getText().isEmpty() // we dont want the text to be blank because all three could be blank as well
            ) {
                // we have a winner
                String winner = buttons[0][col].getText(); // the winner is the text contained in the button
                showWinnerDialog(winner); //calling the method to show the alert
                updateScore(winner); // calling function to update score board
                resetBoard(); // calling the method to reset the board to empty values
                return;
            }
        }

        //diagonal(left to right)
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && //checking if the text at the first row is same as the text on second row
                buttons[1][1].getText().equals(buttons[2][2].getText()) && //checking if the text at the second row is same as the text on third row
                !buttons[0][0].getText().isEmpty() // we dont want the text to be blank because all three could be blank as well
        ) {
            // we have a winner
            String winner = buttons[0][0].getText(); // the winner is the text contained in the button
            showWinnerDialog(winner); //calling the method to show the alert
            updateScore(winner); // calling function to update score board
            resetBoard(); // calling the method to reset the board to empty values
            return;
        }
        // right to left diagonal
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) && //checking if the text at the first row is same as the text on second row
                buttons[1][1].getText().equals(buttons[2][0].getText()) && //checking if the text at the second row is same as the text on third row
                !buttons[0][2].getText().isEmpty() // we dont want the text to be blank because all three could be blank as well
        ) {
            // we have a winner
            String winner = buttons[0][2].getText(); // the winner is the text contained in the button
            showWinnerDialog(winner); //calling the method to show the alert
            updateScore(winner); // calling function to update score board
            resetBoard(); // calling the method to reset the board to empty values
            return;
        }

        //check for tie
        boolean tie = true;
        for (Button row[] : buttons) {// first we will check if we have any empty button
            for (Button btn: row) {
                if (btn.getText().isEmpty()) {
                    tie = false;
                    break;
                }
            }
        }

        if (tie) {
            resetBoard();
            showTieDialog();
        }
    }

    //function to update the scores on the scoreBoard
    private void updateScore(String winner) {
        if (winner.equals("X")) {
            playerXScore++;
            playerXScoreLabel.setText("Player X: " + playerXScore);
        }
        else {
            playerOScore++;
            playerOScoreLabel.setText("Player O: " + playerOScore);
        }
    }
    private void resetBoard() { // this method will reset the board to default values
        for (Button row[] : buttons) {
            for (Button btn: row) {
                btn.setText("");
            }
        }
    }

    private void showWinnerDialog (String winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //will open a small alert window which will inform us of the winner
        alert.setContentText("Congratulations " + winner + "! YOU WON");
        alert.setHeaderText("");
        alert.setTitle("HOORAY!! We Have A Winner");
        alert.showAndWait(); // method to show the alert
    }

    private void showTieDialog () {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //will open a small alert window which will inform us of the winner
        alert.setContentText("OOPS... You Tied! Please Try Again");
        alert.setHeaderText("");
        alert.setTitle("Tie");
        alert.showAndWait(); // method to show the alert
    }

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createContent());
        stage.setTitle("Tic Tac Toe");
        Image icon = new Image("C:\\Java Projects Acciojob\\TicTacToeAK\\src\\main\\Tic-Tac-Toe-Game.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}