package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Shield;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import static de.cLandow.dsaKampftool.Constants.*;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SelectedGearBoxController implements RenderController {


    public HBox mainWeaponHBox;



    private final AddGearPopupController addGearPopupController;
    @FXML HBox sideWeaponHBox;
    @FXML HBox shieldHBox;
    @FXML HBox helmetHBox;
    @FXML HBox torsoHBox;
    @FXML HBox rightArmHBox;
    @FXML HBox leftArmHBox;
    @FXML HBox tummyHBox;
    @FXML HBox rightLegHBox;
    @FXML HBox leftLegHBox;

    private final EquipmentController mainWeaponBoxController;
    private final EquipmentController sideWeaponBoxController;
    private final EquipmentController shildBoxController;
    private final EquipmentController headBoxController;
    private final EquipmentController torsoBoxController;
    private final EquipmentController tummyBoxController;
    private final EquipmentController leftArmBoxController;
    private final EquipmentController rightArmBoxController;
    private final EquipmentController leftLegBoxController;
    private final EquipmentController rightLegBoxController;


    private Weapon_closeCombat mainWeapon;
    private Weapon_closeCombat sideWeapon;
    private Shield shield;


    public SelectedGearBoxController(AddGearPopupController addGearPopupController){
        this.addGearPopupController = addGearPopupController;
        this.mainWeaponBoxController = new EquipmentController(MAINWEAPON);
        this.sideWeaponBoxController = new EquipmentController(SIDEWEAPON);
        this.shildBoxController = new EquipmentController(SHIELD);
        this.headBoxController = new EquipmentController(HEAD);
        this.torsoBoxController = new EquipmentController(TORSO);
        this.tummyBoxController = new EquipmentController(TUMMY);
        this.leftArmBoxController = new EquipmentController(LEFT_ARM);
        this.rightArmBoxController = new EquipmentController(RIGHT_ARM);
        this.leftLegBoxController = new EquipmentController(LEFT_LEG);
        this.rightLegBoxController = new EquipmentController(RIGHT_LEG);
    }

    @Override
    public void init() {

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

    public void setMainWeapon(Weapon_closeCombat mainWeapon) {
        this.mainWeapon = mainWeapon;
        //changeIconToSetMode(MAINWEAPON);
    }

    public Weapon_closeCombat getMainWeapon(){
        return this.mainWeapon;
    }


}
