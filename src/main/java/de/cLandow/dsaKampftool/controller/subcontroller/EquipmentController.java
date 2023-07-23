package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Gear;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static de.cLandow.dsaKampftool.Constants.*;

public class EquipmentController implements RenderController {


    @FXML BorderPane equipmentContainer;
    @FXML ImageView equipmentImageView;

    private final String imagePath;
    private final String imagePathSet;
    private Gear gear;
    private Tooltip newTooltip;

    public EquipmentController(String imagePath, String imagePathSet){
        this.imagePath = imagePath;
        this.imagePathSet = imagePathSet;
    }

    @Override
    public void init() {
       addToolTipp();

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/equipmentContainer.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    private void addToolTipp() {
        if((this.gear != null) && (gear.getName() != null)){
            newTooltip = new Tooltip(gear.getName());
        } else {
            newTooltip = new Tooltip("Leer");
        }
        Tooltip.install(equipmentImageView,newTooltip);
    }

    public void changeIconToSetMode() {
        equipmentImageView.setImage(loadImage(true));
    }

    public void changeIconToNotSetMode() {
        equipmentImageView.setImage(loadImage(false));
    }

    private Image loadImage(Boolean state){
        FileInputStream input = null;
        try {
            if(state){
                input = new FileInputStream(imagePathSet);
            } else {
                input = new FileInputStream(imagePath);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Image(input);
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
        addToolTipp();
    }

    public void setEmptyImage(){
        equipmentImageView.setImage(null);
    }

    public void removeTooltip() {
        Tooltip.uninstall(equipmentImageView,newTooltip);
    }

    public void deleteThisItem(MouseEvent mouseEvent) {
        setEmptyImage();
    }
}
