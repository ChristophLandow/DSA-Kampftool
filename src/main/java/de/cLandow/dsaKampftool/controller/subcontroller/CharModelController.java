package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.util.ArrayList;

public class CharModelController implements RenderController {

    @FXML ToggleButton rightLeg_toggleButton_1;
    @FXML ToggleButton rightLeg_toggleButton_2;
    @FXML ToggleButton rightLeg_toggleButton_3;
    @FXML ToggleButton leftLeg_toggleButton_1;
    @FXML ToggleButton leftLeg_toggleButton_2;
    @FXML ToggleButton leftLeg_toggleButton_3;
    @FXML ToggleButton rightArm_toggleButton_1;
    @FXML ToggleButton rightArm_toggleButton_2;
    @FXML ToggleButton rightArm_toggleButton_3;
    @FXML ToggleButton tummy_toggleButton_1;
    @FXML ToggleButton tummy_toggleButton_2;
    @FXML ToggleButton tummy_toggleButton_3;
    @FXML ToggleButton leftArm_toggleButton_1;
    @FXML ToggleButton leftArm_toggleButton_2;
    @FXML ToggleButton leftArm_toggleButton_3;
    @FXML ToggleButton chest_toggleButton_1;
    @FXML ToggleButton chest_toggleButton_2;
    @FXML ToggleButton chest_toggleButton_3;
    @FXML ToggleButton head_toggleButton_1;
    @FXML ToggleButton head_toggleButton_2;
    @FXML ToggleButton head_toggleButton_3;

    @FXML Label armor_encumbrance_rightArm_Label;
    @FXML Label armor_encumbrance_leftLeg_label;
    @FXML Label armor_encumbrance_tummy_label;
    @FXML Label armor_encumbrance_leftArm_label;
    @FXML Label armor_encumbrance_rightArm_label;
    @FXML Label armor_encumbrance_chest_label;
    @FXML Label armor_encumbrance_backside_label;
    @FXML Label armor_encumbrance_head_label;

    private final CharacterScreenController characterScreenController;
    private final ToggleGroup rightArmToggleGroup = new ToggleGroup();
    private final ToggleGroup leftArmToggleGroup= new ToggleGroup();
    private final ToggleGroup rightLegToggleGroup = new ToggleGroup();
    private final ToggleGroup leftLegToggleGroup = new ToggleGroup();
    private final ToggleGroup tummyToggleGroup = new ToggleGroup();
    private final ToggleGroup chestToggleGroup = new ToggleGroup();
    private final ToggleGroup headToggleGroup = new ToggleGroup();

    private final ArrayList<ToggleGroup> toggleGroupList = new ArrayList<>();


    public CharModelController(CharacterScreenController characterScreenController){
        this.characterScreenController = characterScreenController;
    }

    @Override
    public void init() {
        addToggleGroups();

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/characterModelBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    private void addToggleGroups() {
        rightArmToggleGroup.getToggles().add(rightArm_toggleButton_1);
        rightArmToggleGroup.getToggles().add(rightArm_toggleButton_2);
        rightArmToggleGroup.getToggles().add(rightArm_toggleButton_3);
        toggleGroupList.add(rightArmToggleGroup);

        leftArmToggleGroup.getToggles().add(leftArm_toggleButton_1);
        leftArmToggleGroup.getToggles().add(leftArm_toggleButton_2);
        leftArmToggleGroup.getToggles().add(leftArm_toggleButton_3);
        toggleGroupList.add(leftArmToggleGroup);

        rightLegToggleGroup.getToggles().add(rightLeg_toggleButton_1);
        rightLegToggleGroup.getToggles().add(rightLeg_toggleButton_2);
        rightLegToggleGroup.getToggles().add(rightLeg_toggleButton_3);
        toggleGroupList.add(rightLegToggleGroup);

        leftLegToggleGroup.getToggles().add(leftLeg_toggleButton_1);
        leftLegToggleGroup.getToggles().add(leftLeg_toggleButton_2);
        leftLegToggleGroup.getToggles().add(leftLeg_toggleButton_3);
        toggleGroupList.add(leftLegToggleGroup);

        tummyToggleGroup.getToggles().add(tummy_toggleButton_1);
        tummyToggleGroup.getToggles().add(tummy_toggleButton_2);
        tummyToggleGroup.getToggles().add(tummy_toggleButton_3);
        toggleGroupList.add(tummyToggleGroup);

        chestToggleGroup.getToggles().add(chest_toggleButton_1);
        chestToggleGroup.getToggles().add(chest_toggleButton_2);
        chestToggleGroup.getToggles().add(chest_toggleButton_3);
        toggleGroupList.add(chestToggleGroup);

        headToggleGroup.getToggles().add(head_toggleButton_1);
        headToggleGroup.getToggles().add(head_toggleButton_2);
        headToggleGroup.getToggles().add(head_toggleButton_3);
        toggleGroupList.add(headToggleGroup);
    }
}
