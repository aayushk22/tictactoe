module com.example.tictactoeak {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tictactoeak to javafx.fxml;
    exports com.example.tictactoeak;
}