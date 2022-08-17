package com.example.tictactoehomework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;


public class HelloController {
    private String symbol = "X";
    private int counter;
    @FXML
    private GridPane gridPane;


    @FXML
    public void onButtonClick(ActionEvent event) {
        List<String> buttonsTextArray = new ArrayList<>();
        if (event.getSource() instanceof Button) {
            Button button = (Button) event.getSource();
            if (button.getText() != null) {

                button.setText(symbol);
                symbol = "X".equals(symbol) ? "O" : "X";

                button.setDisable(true);

                for (Node node : gridPane.getChildren()) {
                    if (node instanceof Button) {
                        Button buttonCheck = (Button) node;
                        buttonsTextArray.add(buttonCheck.getText());
                    }
                }

                if (checkScore(buttonsTextArray, counter)) {
                    for (Node node : gridPane.getChildren()) {
                        if (node instanceof Button) {
                            Button buttonCheck = (Button) node;
                            buttonCheck.setDisable(false);
                            buttonCheck.setText("");
                            counter = 0;

                        }
                    }
                } else {
                    counter++;
                }
            }
        }
    }
    public static boolean checkScore(List<String> list, int counter) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("GAME OVER");

        if ("X".equals(list.get(0)) && "X".equals(list.get(1)) && "X".equals(list.get(2)) || "X".equals(list.get(3)) && "X".equals(list.get(4)) && "X".equals(list.get(5)) || "X".equals(list.get(6)) && "X".equals(list.get(7)) && "X".equals(list.get(8))) {
            alert.setHeaderText("X won!");
            alert.showAndWait();
            return true;
        } else if ("X".equals(list.get(0)) && "X".equals(list.get(3)) && "X".equals(list.get(6)) || "X".equals(list.get(1)) && "X".equals(list.get(4)) && "X".equals(list.get(7)) || "X".equals(list.get(2)) && "X".equals(list.get(5)) && "X".equals(list.get(8))) {
            alert.setHeaderText("X won!");
            alert.showAndWait();
            return true;
        } else if ("X".equals(list.get(0)) && "X".equals(list.get(4)) && "X".equals(list.get(8)) || "X".equals(list.get(2)) && "X".equals(list.get(4)) && "X".equals(list.get(6))) {
            alert.setHeaderText("X won!");
            alert.showAndWait();
            return true;
        } else if ("O".equals(list.get(0)) && "O".equals(list.get(1)) && "O".equals(list.get(2)) || "O".equals(list.get(3)) && "O".equals(list.get(4)) && "O".equals(list.get(5)) || "O".equals(list.get(6)) && "O".equals(list.get(7)) && "O".equals(list.get(8))) {
            alert.setHeaderText("O won!");
            alert.showAndWait();
            return true;
        } else if ("O".equals(list.get(0)) && "O".equals(list.get(3)) && "O".equals(list.get(6)) || "O".equals(list.get(1)) && "O".equals(list.get(4)) && "O".equals(list.get(7)) || "O".equals(list.get(2)) && "O".equals(list.get(5)) && "O".equals(list.get(8))) {
            alert.setHeaderText("O won!");
            alert.showAndWait();
            return true;
        } else if ("O".equals(list.get(0)) && "O".equals(list.get(4)) && "O".equals(list.get(8)) || "O".equals(list.get(2)) && "O".equals(list.get(4)) && "O".equals(list.get(6))) {
            alert.setHeaderText("O won!");
            alert.showAndWait();
            return true;
        }
        if (counter == 8) {
            alert.setHeaderText("It's a DRAW!");
            alert.showAndWait();
            return true;
        }
        return false;
    }
}