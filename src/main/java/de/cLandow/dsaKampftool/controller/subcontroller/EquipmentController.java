package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Gear;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EquipmentController implements RenderController {

    @FXML Circle deleteItemCircle;
    @FXML BorderPane equipmentContainer;
    @FXML ImageView equipmentImageView;
    private final SelectedGearBoxController selectedGearBoxController;
    private final String imagePath;
    private final String imagePathSet;
    private final SimpleBooleanProperty gearNotNullChecker;
    private Gear gear;
    private Tooltip newTooltip;
    private ChangeListener gearSetChecker;

    public EquipmentController(SelectedGearBoxController selectedGearBoxController, String imagePath, String imagePathSet){
        this.selectedGearBoxController = selectedGearBoxController;
        this.imagePath = imagePath;
        this.imagePathSet = imagePathSet;
        gearNotNullChecker = new SimpleBooleanProperty();
    }

    @Override
    public void init() {
        addlisteners();
        addToolTipp();
        setCircleButton();
    }

    @Override
    public void stop() {
        gearNotNullChecker.removeListener(gearSetChecker);
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

    private void setCircleButton() {
        deleteItemCircle.setVisible(false);
        deleteItemCircle.setDisable(true);
    }

    private void addlisteners() {
        gearNotNullChecker.set(false);
        gearSetChecker = (observable, oldValue, newValue) -> {
            if (gearNotNullChecker.getValue()) {
                deleteItemCircle.setDisable(false);
                deleteItemCircle.setVisible(true);
            } else {
                deleteItemCircle.setDisable(true);
                deleteItemCircle.setVisible(false);
            }
        };
        gearNotNullChecker.addListener(gearSetChecker);
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
        if(gear != null){
            this.gear = gear;
            gearNotNullChecker.set(true);
            addToolTipp();
        }
    }

    public void removeTooltip() {
        Tooltip.uninstall(equipmentImageView,newTooltip);
    }

    public void deleteThisItem(MouseEvent mouseEvent) {
        removeTooltip();
        changeIconToNotSetMode();
        gearNotNullChecker.set(false);
        setGear(null);
    }
}
