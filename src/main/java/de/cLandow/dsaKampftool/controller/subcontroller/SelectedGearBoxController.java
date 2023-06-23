package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

public class SelectedGearBoxController implements RenderController {

    @FXML ImageView helmetImageView;
    @FXML ImageView torsoArmorImageView;
    @FXML ImageView tummyImageView;
    @FXML ImageView leftLegImageView;
    @FXML ImageView tightLegImageView;
    @FXML ImageView leftArmImageView;
    @FXML ImageView rightArmImageView;

    public SelectedGearBoxController(){

    }

    @Override
    public void init() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        return null;
    }
}
