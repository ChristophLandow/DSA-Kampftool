package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.subcontroller.AddGearPopupController;
import de.cLandow.dsaKampftool.controller.subcontroller.HealthAndEnduranceBoxController;
import de.cLandow.dsaKampftool.controller.subcontroller.SpecialAbilityPopupController;
import de.cLandow.dsaKampftool.model.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CharacterScreenController implements ScreenController{

    @FXML Label armor_encumbrance_rightArm_Label;
    @FXML Label armor_encumbrance_leftLeg_label;
    @FXML Label armor_encumbrance_tummy_label;
    @FXML Label armor_encumbrance_leftArm_label;
    @FXML Label armor_encumbrance_rightArm_label;
    @FXML Label armor_encumbrance_chest_label;
    @FXML Label armor_encumbrance_backside_label;
    @FXML Label armor_encumbrance_head_label;
    @FXML Button addSpecialAbilityButton;
    @FXML HBox healthAndEnduranceBox;

    private Parent characterScreenParent;
    private Character actualCharacter;
    private final HealthAndEnduranceBoxController healthAndEnduranceBoxController;
    private Stage popupStage;
    private final ArrayList<TextField> behinderungKoerperzonen = new ArrayList<>();

    public CharacterScreenController(Character actualCharacter) {
        this.actualCharacter = actualCharacter;
        this.healthAndEnduranceBoxController = new HealthAndEnduranceBoxController(this);
    }

    @Override
    public void init() {
        healthAndEnduranceBox.getChildren().add(healthAndEnduranceBoxController.render());
        healthAndEnduranceBoxController.init();
        setListenertoBehinderungsliste();

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/characterScreen.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        characterScreenParent = parent;
        return parent;
    }

    private void setListenertoBehinderungsliste(){
        for(TextField field : behinderungKoerperzonen){
            field.textProperty().addListener((observable, oldValue, newValue) -> {
                if(!field.getText().isEmpty()){
                    if(field.getText().length() > 2){
                        field.setText(field.getText().substring(0,2));
                    }
                    float testInput = 0;
                    try
                    {
                        testInput = Float.parseFloat(field.getText());

                    }
                    catch (NumberFormatException e)
                    {
                        field.clear();
                    }
                }
            });
        }
    }

    public Parent getCharacterScreenParent() {
        return this.characterScreenParent;
    }

    public int getSummBehinderung(){
        int result = 0;
        for(TextField field : behinderungKoerperzonen){
            if(field.getText().isEmpty()){
                result += 0;
            } else {
                result += Integer.parseInt(field.getText());
            }
        }
        return  result;
    }

    public void openAddSpecialAbilityPopup(ActionEvent actionEvent) {
        closePopup();
        popupStage = new Stage();
        popupStage.initModality(Modality.WINDOW_MODAL);
        SpecialAbilityPopupController specialAbilityPopupController = new SpecialAbilityPopupController(this);
        popupStage.setScene(new Scene(specialAbilityPopupController.render()));
        specialAbilityPopupController.init();
        popupStage.show();
    }

    public void closePopup(){
        if(popupStage != null){
            popupStage.close();
        }
    }

    public Stage getPopupStage(){
        return this.popupStage;
    }

    public Character getActualCharacter() {
        return actualCharacter;
    }

    public void openAddGearPopup(ActionEvent actionEvent) {
        closePopup();
        popupStage = new Stage();
        popupStage.initModality(Modality.WINDOW_MODAL);
        AddGearPopupController addGearPopupController = new AddGearPopupController(this);
        popupStage.setScene(new Scene(addGearPopupController.render()));
        addGearPopupController.init();
        popupStage.show();
    }

}
