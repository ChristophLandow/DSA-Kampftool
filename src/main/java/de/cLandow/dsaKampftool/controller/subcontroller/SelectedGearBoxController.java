package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class SelectedGearBoxController implements RenderController {


    @FXML ImageView helmetImageView;
    @FXML ImageView torsoArmorImageView;
    @FXML ImageView tummyImageView;
    @FXML ImageView leftLegImageView;
    @FXML ImageView rightLegImageView;
    @FXML ImageView leftArmImageView;
    @FXML ImageView rightArmImageView;

    public SelectedGearBoxController(){

    }

    @Override
    public void init() {
        addHoverEffekt(helmetImageView);
        addHoverEffekt(torsoArmorImageView);
        addHoverEffekt(tummyImageView);
        addHoverEffekt(leftLegImageView);
        addHoverEffekt(rightLegImageView);
        addHoverEffekt(leftArmImageView);
        addHoverEffekt(rightArmImageView);
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/selectedGearBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    private void addHoverEffekt(ImageView imageView) {

    }
}
