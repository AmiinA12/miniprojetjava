package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HomeController {

    @FXML
    private Button lisvend;

    @FXML
    private Button ajouter;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private Button listempl;

    @FXML
    void onajouter(ActionEvent event) {
    	Main.mudaTela("addsalary");
    }

    @FXML
    void onlisteempl(ActionEvent event) {
    	Main.mudaTela("listemployees");
    }

    @FXML
    void onlistven(ActionEvent event) {
    	Main.mudaTela("listvendores");
    }

}

