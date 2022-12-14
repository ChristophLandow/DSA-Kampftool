package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.services.PrefService;
import static de.cLandow.dsaKampftool.Constants.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import java.io.IOException;


public class CloseCombatScreenController implements ScreenController {

    @FXML CheckBox kampfreflexeBox;
    @FXML CheckBox kampfgespuehrBox;
    @FXML CheckBox beengtBox;
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
    private final PrefService prefService;
    private final SetupScreenController setupScreenController;
    private Parent combatScreenParent;
    private int atCounter;
    private int paCounter;
    private int iniCounter;

    public CloseCombatScreenController(PrefService prefService, SetupScreenController setupScreenController){
        this.prefService = prefService;
        this.setupScreenController = setupScreenController;
    }

    @Override
    public void init() {
        kampfreflexeBox.setSelected(setupScreenController.getActualCharacter().kampfreflexe());
        kampfgespuehrBox.setSelected(setupScreenController.getActualCharacter().kampfgespuehr());
        beengtBox.setSelected(setupScreenController.getActualCharacter().beengt());
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

    public int getAtCounter(){
        return atCounter;
    }

    public int getPaCounter() {
        return paCounter;
    }

    public int getIniCounter() {
        return iniCounter;
    }

    public Parent getCombatScreenParent(){
        return this.combatScreenParent;
    }


    public void setKampfreflexeBox(ActionEvent actionEvent) {
        prefService.saveBox(KAMPFREFLEXE ,kampfreflexeBox.isSelected());
    }

    public void setKampfgespuehrBox(ActionEvent actionEvent) {
        prefService.saveBox(KAMPFGESPUEHR, kampfgespuehrBox.isSelected());
    }

    public void setBeengtBox(ActionEvent actionEvent) {
        prefService.saveBox(BEENGT, beengtBox.isSelected());
    }
}
