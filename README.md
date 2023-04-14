# tictactoe
What the Application does?
- It is basically the virtual version of the famous tic tac toe game that we generally played on a sheet of paper. In this game we have a 3x3 grid, where in each box the players can either write an O or an X. There are two players in the game. One can only use Xs and the other can only use Os. If one of the player is able to write 3 consecutive Xs or Os in a row, or a column or even in one of the two diagonals, then that player wins the game. If the players fill all the boxes and even after filling all boxes none of the player is able to satisfy the winning condition, then we have a tie.

What are the technologies used? 
- Javafx and Java

What are the functionalities used for the UI?
1. First, for the overall layout, I have used Bordered Pane because it allows us to lay our inner layouts in the top, bottom and center. 
2. At the top, I have used it for title. For that I have used the Label functionality and used an image to be displayed instead of just text. The image is a cool font of Tic Tac Toe.
3. In the center, I have created a grid of buttons of 3x3 and for that I have used GridPane. At every box there is a button and when it is pressed it calls the function of clicking a button where the text of the button is set to X or O 
4. In the bottom I have created a scoreboard where the scores of player X and player O gets updated. If player X wins 1 is added to his score and similarly for O. For the scoreboard i have used HBox which is basically used to lay out its children in a single row.
5. When any player wins a game, an alert is popped up which displays the message that a player has won and that player's score is updated.

What is happening in the backend?
1. First of all whenever a button is clicked for the first time, i.e, the function buttonClicked() ensures that if it is player X's turn then the text of the button will be set to X or else the text will be set to O. If we already have a text on the button then clicking that button will not do anything.
2. After every button click the checkWinner() function will be called which will check the winning condition and pop an alert if any player has won or if the game has tied. For checking the winner every column in a single row will be checked, every row in a single column will be checked and then every diagonal will be checked.
3. The game can also be tied, which will happen if all the buttons have some text and none of the winning conditions are satisfied
4. If winning condition is satisfied, an alert will be popped up displaying the winner of the game, the scores will be updated and the board will be reset to default.
5. If there is a tie, then only the board needs to be reset and the alert will say that the game has tied. Scores wont be updated.
