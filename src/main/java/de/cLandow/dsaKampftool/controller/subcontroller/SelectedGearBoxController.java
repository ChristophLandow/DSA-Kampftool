package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class SelectedGearBoxController implements RenderController {


    @FXML BorderPane shieldBorderPane;
    @FXML BorderPane mainWeaponBorderPane;
    @FXML BorderPane sideWeaponBorderPane;
    @FXML BorderPane headBorderPane;
    @FXML BorderPane torsoBorderPAne;
    @FXML BorderPane leftArmBorderPane;
    @FXML BorderPane tummyBorderPane;
    @FXML BorderPane leftLegBorderPane;
    @FXML BorderPane rightLegBorderPane;
    @FXML BorderPane rightArmBorderPane;

    @FXML ImageView rightLegImageView;
    @FXML ImageView shieldImageView;
    @FXML ImageView sideWeaponImageView;
    @FXML ImageView mainWeaponImageView;
    @FXML ImageView helmetImageView;
    @FXML ImageView torsoArmorImageView;
    @FXML ImageView tummyImageView;
    @FXML ImageView leftLegImageView;
    @FXML ImageView leftArmImageView;
    @FXML ImageView rightArmImageView;

    private final AddGearPopupController addGearPopupController;


    public SelectedGearBoxController(AddGearPopupController addGearPopupController){
        this.addGearPopupController = addGearPopupController;
    }

    @Override
    public void init() {
        addHoverEffekt(headBorderPane);
        addHoverEffekt(torsoBorderPAne);
        addHoverEffekt(tummyBorderPane);
        addHoverEffekt(leftLegBorderPane);
        addHoverEffekt(rightLegBorderPane);
        addHoverEffekt(leftArmBorderPane);
        addHoverEffekt(rightArmBorderPane);
        addHoverEffekt(shieldBorderPane);
        addHoverEffekt(mainWeaponBorderPane);
        addHoverEffekt(sideWeaponBorderPane);
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

    private void addHoverEffekt(BorderPane pane) {
        addBorderPaneEffect((ImageView) pane.getCenter());
        addToolTipp((ImageView) pane.getCenter());
    }

    private void addBorderPaneEffect(ImageView view) {
        view.setOnMouseEntered((event) -> {



        });
    }

    private void addToolTipp(ImageView view) {
        Tooltip newTooltip = new Tooltip("test");
        Tooltip.install(view,newTooltip);
    }

}
