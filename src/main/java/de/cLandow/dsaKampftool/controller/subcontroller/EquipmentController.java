package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static de.cLandow.dsaKampftool.Constants.MAINWEAPON;
import static de.cLandow.dsaKampftool.Constants.MAINWEAPON_IMAGE;

public class EquipmentController implements RenderController {

    @FXML BorderPane equipmentContainer;
    @FXML ImageView equipmentImageView;

    public EquipmentController(String mainweapon){

    }
    @Override
    public void init() {
        addHoverEffekt();

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        return null;
    }

    private void addHoverEffekt() {
        //addBorderPaneEffect((ImageView) pane.getCenter());
        //addToolTipp((ImageView) pane.getCenter());
    }

    private void addBorderPaneEffect(ImageView view) {
        view.setOnMouseEntered((event) -> {

        });
    }
    private void addToolTipp(ImageView view) {
        Tooltip newTooltip = new Tooltip("test");
        Tooltip.install(view,newTooltip);
    }

    private void changeIconToSetMode(String item) {
        switch(item){
            case MAINWEAPON -> {
                equipmentImageView.setImage(loadImage(MAINWEAPON_IMAGE));
            }
        }
    }

    private Image loadImage(String path){
        FileInputStream input = null;
        try {
            input = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Image(input);
    }


}
