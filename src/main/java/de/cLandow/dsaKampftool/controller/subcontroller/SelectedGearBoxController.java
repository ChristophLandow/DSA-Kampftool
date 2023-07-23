package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Armor;
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
    @FXML HBox chestHBox;
    @FXML HBox backsideHBox;
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
    private final EquipmentController chestBoxController;
    private final EquipmentController backsideBoxController;
    private final EquipmentController tummyBoxController;
    private final EquipmentController leftArmBoxController;
    private final EquipmentController rightArmBoxController;
    private final EquipmentController leftLegBoxController;
    private final EquipmentController rightLegBoxController;

    private final ArrayList<EquipmentController> equipmentControllers = new ArrayList<>();


    private Weapon_closeCombat mainWeapon;
    private Weapon_closeCombat sideWeapon;
    private Shield shield;


    public SelectedGearBoxController(AddGearPopupController addGearPopupController){
        this.addGearPopupController = addGearPopupController;
        this.mainWeaponBoxController = new EquipmentController(MAINWEAPON_IMAGE_PATH, MAINWEAPON_SET_IMAGE_PATH);
        equipmentControllers.add(mainWeaponBoxController);
        this.sideWeaponBoxController = new EquipmentController(SIDEWEAPON_IMAGE_PATH, SIDEWEAPON_SET_IMAGE_PATH);
        equipmentControllers.add(sideWeaponBoxController);
        this.shildBoxController = new EquipmentController(SHIELD_IMAGE_PATH, SHIELD_SET_IMAGE_PATH);
        equipmentControllers.add(shildBoxController);
        this.headBoxController = new EquipmentController(HELMET_IMAGE_PATH, HELMET_SET_IMAGE_PATH);
        equipmentControllers.add(headBoxController);
        this.chestBoxController = new EquipmentController(BREASTPLATE_IMAGE_PATH, BACKSIDEPLATE_SET_IMAGE_PATH);
        equipmentControllers.add(chestBoxController);
        this.backsideBoxController = new EquipmentController(BACKSIDEPLATE_IMAGE_PATH, BACKSIDEPLATE_SET_IMAGE_PATH);
        equipmentControllers.add(chestBoxController);
        this.tummyBoxController = new EquipmentController(TUMMYPLATE_IMAGE_PATH, TUMMYPLATE_SET_IMAGE_PATH);
        equipmentControllers.add(tummyBoxController);
        this.leftArmBoxController = new EquipmentController(LEFTGLOVE_IMAGE_PATH, LEFTGLOVE_SET_IMAGE_PATH);
        equipmentControllers.add(leftArmBoxController);
        this.rightArmBoxController = new EquipmentController(RIGHTGLOVE_IMAGE_PATH, RIGHTGLOVE_SET_IMAGE_PATH);
        equipmentControllers.add(rightArmBoxController);
        this.leftLegBoxController = new EquipmentController(LEFTBOOT_IMAGE_PATH, LEFTBOOT_SET_IMAGE_PATH);
        equipmentControllers.add(leftLegBoxController);
        this.rightLegBoxController = new EquipmentController(RIGHTBOOT_IMAGE_PATH, RIGHTBOOT_SET_IMAGE_PATH);
        equipmentControllers.add(rightLegBoxController);
    }

    @Override
    public void init() {
        mainWeaponHBox.getChildren().add(mainWeaponBoxController.render());
        sideWeaponHBox.getChildren().add(sideWeaponBoxController.render());
        shieldHBox.getChildren().add(shildBoxController.render());
        helmetHBox.getChildren().add(headBoxController.render());
        chestHBox.getChildren().add(chestBoxController.render());
        backsideHBox.getChildren().add(backsideBoxController.render());
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
            switch (zone) {
                case HEAD_ARMOR -> {
                    clearBox(headBoxController);
                    headBoxController.changeIconToSetMode();
                    headBoxController.setGear(armor);
                }
                case CHEST_ARMOR -> {
                    clearBox(chestBoxController);
                    chestBoxController.changeIconToSetMode();
                    chestBoxController.setGear(armor);
                }
                case BACKSIDE_ARMOR -> {
                    clearBox(backsideBoxController);
                    backsideBoxController.changeIconToSetMode();
                    backsideBoxController.setGear(armor);
                }
                case TUMMY_ARMOR -> {
                    clearBox(tummyBoxController);
                    tummyBoxController.changeIconToSetMode();
                    tummyBoxController.setGear(armor);
                }
                case LEFTARM_ARMOR -> {
                    clearBox(leftArmBoxController);
                    leftArmBoxController.changeIconToSetMode();
                    leftArmBoxController.setGear(armor);
                }
                case RIGHTARM_ARMOR -> {
                    clearBox(rightArmBoxController);
                    rightArmBoxController.changeIconToSetMode();
                    rightArmBoxController.setGear(armor);
                }
                case LEFTLEG_ARMOR -> {
                    clearBox(leftLegBoxController);
                    leftLegBoxController.changeIconToSetMode();
                    leftLegBoxController.setGear(armor);
                }
                case RIGHTLEG_ARMOR -> {
                    clearBox(rightLegBoxController);
                    rightLegBoxController.changeIconToSetMode();
                    rightLegBoxController.setGear(armor);
                }
                default -> {
                    System.out.println("Unidentified Gear Class");
                }
            }
        }
    }

    private void clearBox(EquipmentController controller){
        controller.changeIconToSetMode();
        controller.removeTooltip();
    }
}
