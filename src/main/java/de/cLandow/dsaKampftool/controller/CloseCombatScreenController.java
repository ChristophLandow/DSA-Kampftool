package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CloseCombatScreenController implements ScreenController {

    @FXML CheckBox kampfreflexeBox;
    @FXML CheckBox linkhandBox;
    @FXML CheckBox kampfgespuehrBox;
    @FXML CheckBox beengtBox;
    @FXML CheckBox schwertmeisterBox;
    @FXML CheckBox beidhaendigKaempfenEinsBox;
    @FXML CheckBox beidhaendigKaempfenZweiBox;
    @FXML CheckBox ausweichenEinsBox;
    @FXML CheckBox ausweichenZweiBox;
    @FXML CheckBox falscheHandBox;
    @FXML CheckBox ausweichenDreiBox;
    @FXML CheckBox waffenmeisterBox;
    @FXML RadioButton sternenlichtRadioButton;
    @FXML RadioButton mondlichtRadioButton;
    @FXML RadioButton dunkelheitRadioButton;
    @FXML RadioButton knietiefRadioButton;
    @FXML RadioButton huefttiefRadioButton;
    @FXML RadioButton schultertiefRadioButton;
    @FXML RadioButton unterWasserRadioButton;

    private Parent combatScreenParent;

    public CloseCombatScreenController(){

    }

    @Override
    public void init() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/closeCombatSetup.fxml"));
        loader.setControllerFactory(c->this);
        final Parent closeCombatScreenParent;
        try {
            closeCombatScreenParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        combatScreenParent = closeCombatScreenParent;
        return closeCombatScreenParent;
    }

    public Parent getCombatScreenParent(){
        return this.combatScreenParent;
    }


}
