package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CloseCombatScreenController implements ScreenController, Initializable {

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
    @FXML ChoiceBox<String> lichtBox;
    @FXML ChoiceBox<String> wasserBox;



    private final ArrayList<String> lichtverhaeltnisse = new ArrayList<>();
    private final ArrayList<String> wasserstand = new ArrayList<>();

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
        return closeCombatScreenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lichtverhaeltnisse.add("Mondlicht");
        lichtverhaeltnisse.add("Sternenlicht");
        lichtverhaeltnisse.add("totale Dunkelheit");
        wasserstand.add("knietief");
        wasserstand.add("hüfttief");
        wasserstand.add("schultertief");
        wasserstand.add("unter Wasser");
        lichtBox.getItems().addAll(lichtverhaeltnisse);
        wasserBox.getItems().addAll(wasserstand);
    }
}
