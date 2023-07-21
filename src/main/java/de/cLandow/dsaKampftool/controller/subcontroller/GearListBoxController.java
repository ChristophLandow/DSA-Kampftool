package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Armor;
import de.cLandow.dsaKampftool.model.Gear;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import static de.cLandow.dsaKampftool.Constants.*;
import de.cLandow.dsaKampftool.services.ReadFileService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import java.io.IOException;


public class GearListBoxController implements RenderController {

    @FXML ChoiceBox<String> gearGroupChoiceBox;
    @FXML ChoiceBox<String> gearSubGroupChoiceBox;
    @FXML ListView<Gear> gearListView;

    private final AddGearPopupController addGearPopupController;

    private ObservableList<Weapon_closeCombat> weaponObservableList= FXCollections.observableArrayList();
    private ObservableList<Armor> armorObservableList = FXCollections.observableArrayList();
    private ObservableList<Weapon_closeCombat> twoHandedImpactWeapons = FXCollections.observableArrayList();

    private ObservableList<Weapon_closeCombat> bastardswords = FXCollections.observableArrayList();
    private ObservableList<Weapon_closeCombat> fencingWeapons = FXCollections.observableArrayList();
    private ObservableList<Weapon_closeCombat> daggers = FXCollections.observableArrayList();

    private ObservableList<Weapon_closeCombat> impactWeapons = FXCollections.observableArrayList();
    private ObservableList<Armor> clothesArmor = FXCollections.observableArrayList();
    private ObservableList<Armor> clothArmor = FXCollections.observableArrayList();

    public GearListBoxController(AddGearPopupController addGearPopupController){
        this.addGearPopupController = addGearPopupController;
    }

    @Override
    public void init() {
        loadGearGroupChoiceBox();
        loadGearLists();
        gearListView.setCellFactory(gearListView -> new GearListItemController(this));
        gearSubGroupChoiceBox.setDisable(true);
        loadGearChoiceBoxListener();
        loadGearSubGroupBoxListeners();

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/gearListBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public void loadGearLists(){
        ReadFileService readFileService = new ReadFileService(this);
        //load Weapons
        weaponObservableList = readFileService.loadWeapons();
        armorObservableList = readFileService.loadArmor();
    }

    // ChoiceBox filler

    private void loadGearGroupChoiceBox() {
        gearGroupChoiceBox.getItems().add(WEAPON);
        gearGroupChoiceBox.getItems().add(ARMOR);
    }

    private void loadSubGroupBox_WeaponGroups() {
        gearSubGroupChoiceBox.getItems().add(SHOWALL);
        gearSubGroupChoiceBox.getItems().add(BASTARDSWORDS);
        gearSubGroupChoiceBox.getItems().add(TWO_HANDED_IMPACT_WEAPON);
        gearSubGroupChoiceBox.getItems().add(DAGGERS);
        gearSubGroupChoiceBox.getItems().add(FENCING_WEAPONS);
        gearSubGroupChoiceBox.getItems().add(IMPACT_WEAPONS);
    }

    private void loadSubGroupBox_Armor() {
        gearSubGroupChoiceBox.getItems().add(CLOTHES);
        gearSubGroupChoiceBox.getItems().add(CLOTARMOR);
    }

    //choiceBoxListener

    public void loadGearChoiceBoxListener() {
        gearGroupChoiceBox.setOnAction(event -> {
            gearSubGroupChoiceBox.getItems().clear();
            gearSubGroupChoiceBox.setValue("  ");
            gearListView.getItems().clear();
            if(gearGroupChoiceBox.getValue() != null){
                switch (gearGroupChoiceBox.getValue()) {
                    case WEAPON -> {
                        gearSubGroupChoiceBox.setDisable(false);
                        loadSubGroupBox_WeaponGroups();
                    }
                    case ARMOR -> {
                        gearSubGroupChoiceBox.setDisable(false);
                        loadSubGroupBox_Armor();
                    }
                    default -> {
                    }
                }
            }
        });
    }


    public void loadGearSubGroupBoxListeners() {
        gearSubGroupChoiceBox.setOnAction(event -> {
            gearListView.getItems().clear();
            if(gearSubGroupChoiceBox.getValue() != null){
                switch (gearSubGroupChoiceBox.getValue()) {
                    //Weapon Cases
                    case DAGGERS:
                        fillSubList_Daggers();
                        break;
                    case FENCING_WEAPONS:
                        fillSubList_FencingWeapons();
                        break;
                    case TWO_HANDED_IMPACT_WEAPON:
                        fillSubList_TwoHandedImpactWeapons();
                        break;
                    case BASTARDSWORDS:
                        fillSubList_Bastardswords();
                        break;
                    case IMPACT_WEAPONS:
                        filSubList_ImpactWeapons();
                        break;
                    //ArmorCases
                    case CLOTHES:
                        filSubList_Clothes();
                        break;
                    case CLOTARMOR:
                        filSubList_ClotheArmor();
                        break;
                    default:
                        fillSubList_AllGear();
                }
            }
        });
    }

    //Weapon List Setter
    public void setDoubleClickedGearToEquipment(Gear gear){
        addGearPopupController.addGearFromListToEquipment(gear);
    }

    public void setDaggers(ObservableList<Weapon_closeCombat> daggers) {
        this.daggers = daggers;
    }

    public void setFencingWeapons(ObservableList<Weapon_closeCombat> fencingWeapons) {
        this.fencingWeapons = fencingWeapons;
    }

    public void setTwoHandedImpactWeapons(ObservableList<Weapon_closeCombat> twoHandedImpactWeapons) {
        this.twoHandedImpactWeapons = twoHandedImpactWeapons;
    }

    public void setBastardswords(ObservableList<Weapon_closeCombat> bastardswords) {
        this.bastardswords = bastardswords;
    }

    public void setImpactWeapons(ObservableList<Weapon_closeCombat> impactWeapons) {
        this.impactWeapons = impactWeapons;
    }

    //Armor List Setter

    public void setClothes(ObservableList<Armor> temporaryArmorLIst) {
        this.clothesArmor = temporaryArmorLIst;
    }

    public void setClothArmor(ObservableList<Armor> temporaryArmorLIst) {
        this.clothArmor = temporaryArmorLIst;
    }

    //list filler

    public void fillSubList_AllGear(){
        ObservableList<Gear> allGearList = FXCollections.observableArrayList();
        allGearList.addAll(weaponObservableList);
        allGearList.addAll(armorObservableList);
        gearListView.setItems(allGearList);
    }

    public void filSubList_ImpactWeapons(){
        gearListView.setItems(castWeaponListToGearList(impactWeapons));
    }

    public void fillSubList_Daggers(){
        gearListView.setItems(castWeaponListToGearList(daggers));
    }

    public void fillSubList_FencingWeapons(){
        gearListView.setItems(castWeaponListToGearList(fencingWeapons));
    }

    public void fillSubList_TwoHandedImpactWeapons(){
        gearListView.setItems(castWeaponListToGearList(twoHandedImpactWeapons));
    }

    public void fillSubList_Bastardswords(){
        gearListView.setItems(castWeaponListToGearList(bastardswords));
    }

    private void filSubList_ClotheArmor() {
        gearListView.setItems(castArmorListToGearList(clothArmor));
    }

    private void filSubList_Clothes() {
        gearListView.setItems(castArmorListToGearList(clothesArmor));
    }

    private ObservableList<Gear> castWeaponListToGearList(ObservableList<Weapon_closeCombat> weaponList){
        ObservableList<Gear> gearList = FXCollections.observableArrayList();
        gearList.addAll(weaponList);
        return gearList;
    }

    private ObservableList<Gear> castArmorListToGearList(ObservableList<Armor> armorList){
        ObservableList<Gear> gearList = FXCollections.observableArrayList();
        gearList.addAll(armorList);
        return gearList;
    }




}
