package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Armor;
import de.cLandow.dsaKampftool.model.Gear;
import de.cLandow.dsaKampftool.model.Shield;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import static de.cLandow.dsaKampftool.Constants.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;

public class SelectedGearBoxController implements RenderController {

    @FXML HBox mainWeaponHBox;
    @FXML HBox sideWeaponHBox;
    @FXML HBox shieldHBox;
    @FXML HBox helmetHBox;
    @FXML HBox torsoHBox;
    @FXML HBox rightArmHBox;
    @FXML HBox leftArmHBox;
    @FXML HBox tummyHBox;
    @FXML HBox rightLegHBox;
    @FXML HBox leftLegHBox;
    private final AddGearPopupController addGearPopupController;
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

    private ArrayList<EquipmentController> equipmentControllers = new ArrayList<>();


    private Weapon_closeCombat mainWeapon;
    private Weapon_closeCombat sideWeapon;
    private Shield shield;


    public SelectedGearBoxController(AddGearPopupController addGearPopupController){
        this.addGearPopupController = addGearPopupController;
        this.mainWeaponBoxController = new EquipmentController(MAINWEAPON);
        equipmentControllers.add(mainWeaponBoxController);
        this.sideWeaponBoxController = new EquipmentController(SIDEWEAPON);
        equipmentControllers.add(sideWeaponBoxController);
        this.shildBoxController = new EquipmentController(SHIELD);
        equipmentControllers.add(shildBoxController);
        this.headBoxController = new EquipmentController(HEAD);
        equipmentControllers.add(headBoxController);
        this.torsoBoxController = new EquipmentController(TORSO);
        equipmentControllers.add(torsoBoxController);
        this.tummyBoxController = new EquipmentController(TUMMY);
        equipmentControllers.add(tummyBoxController);
        this.leftArmBoxController = new EquipmentController(LEFT_ARM);
        equipmentControllers.add(leftArmBoxController);
        this.rightArmBoxController = new EquipmentController(RIGHT_ARM);
        equipmentControllers.add(rightArmBoxController);
        this.leftLegBoxController = new EquipmentController(LEFT_LEG);
        equipmentControllers.add(leftLegBoxController);
        this.rightLegBoxController = new EquipmentController(RIGHT_LEG);
        equipmentControllers.add(rightLegBoxController);
    }

    @Override
    public void init() {
        mainWeaponHBox.getChildren().add(mainWeaponBoxController.render());
        sideWeaponHBox.getChildren().add(sideWeaponBoxController.render());
        shieldHBox.getChildren().add(shildBoxController.render());
        helmetHBox.getChildren().add(headBoxController.render());
        torsoHBox.getChildren().add(torsoBoxController.render());
        tummyHBox.getChildren().add(tummyBoxController.render());
        leftArmHBox.getChildren().add(leftArmBoxController.render());
        rightArmHBox.getChildren().add(rightArmBoxController.render());
        leftLegHBox.getChildren().add(leftLegBoxController.render());
        rightLegHBox.getChildren().add(rightLegBoxController.render());
        for (EquipmentController controller : equipmentControllers){
            controller.init();
        }
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
        mainWeaponBoxController.setGear(mainWeapon);
        mainWeaponBoxController.changeIconToSetMode();
    }


    public void setArmor(Armor armor) {
        for(String zone : armor.getZone()){

        }
    }
}
