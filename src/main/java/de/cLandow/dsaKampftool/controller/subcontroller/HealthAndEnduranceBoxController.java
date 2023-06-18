package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;

public class HealthAndEnduranceBoxController implements RenderController {

    @FXML Spinner<Integer> healthPointsCounter;
    @FXML Spinner<Integer> endurancePointsCounter;


    private final CharacterScreenController characterScreenController;
    private SpinnerValueFactory<Integer> healthSpinner;
    private SpinnerValueFactory<Integer> enduranceSpinner;

    private Boolean underHalfHealthPoints = false;
    private Boolean underOneThirdHelthPoints = false;
    private Boolean zeroEndurancePoints = false;




    public HealthAndEnduranceBoxController(CharacterScreenController characterScreenController){
        this.characterScreenController = characterScreenController;
        healthSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory((-characterScreenController.getActualCharacter().getLp()),1000,characterScreenController.getActualCharacter().getLp());
        enduranceSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,characterScreenController.getActualCharacter().getAup());
    }

    @Override
    public void init() {

        healthPointsCounter.setValueFactory(healthSpinner);
        endurancePointsCounter.setValueFactory(enduranceSpinner);

        healthSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue <= ( characterScreenController.getActualCharacter().getLp() / 2)){
                underHalfHealthPoints = true;
            } else if (newValue <= ( characterScreenController.getActualCharacter().getLp() / 3)) {
                underOneThirdHelthPoints = true;
            }
        });

        enduranceSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == 0){
                zeroEndurancePoints = true;
            }
        });

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/healthEnduranceBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }
}
