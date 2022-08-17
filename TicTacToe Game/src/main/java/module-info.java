module com.example.tictactoehomework {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tictactoehomework to javafx.fxml;
    exports com.example.tictactoehomework;
}