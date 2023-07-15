package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
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
import javafx.scene.control.SelectionMode;
import java.io.IOException;
import java.util.ArrayList;

public class GearListBoxController implements RenderController {

    @FXML
    ChoiceBox<String> gearGroupChoiceBox;
    @FXML
    ListView<Gear> gearListView;

    private AddGearPopupController addGearPopupController;

    private ObservableList<Weapon_closeCombat> weaponObservableList= FXCollections.observableArrayList();
    private ObservableList<Weapon_closeCombat> closeCombatWeaponList = FXCollections.observableArrayList();
    private ObservableList<Weapon_closeCombat> twoHandedImpactWeapons = FXCollections.observableArrayList();

    private ObservableList<Weapon_closeCombat> bastardswords = FXCollections.observableArrayList();
    private ObservableList<Weapon_closeCombat> fencingWeapons = FXCollections.observableArrayList();
    private ObservableList<Weapon_closeCombat> daggers = FXCollections.observableArrayList();

    private ObservableList<Weapon_closeCombat> impactWeapons = FXCollections.observableArrayList();

    public GearListBoxController(AddGearPopupController addGearPopupController){
        this.addGearPopupController = addGearPopupController;
    }

    @Override
    public void init() {
        loadGearGroupChoiceBox();
        loadGearLists();
        gearListView.setCellFactory(gearListView -> new GearListItemController(this));
        /*Make listview to select multiple values*/
        gearListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        loadGearChoiceBoxListener();
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
        weaponObservableList = readFileService.loadGear(WEAPON_FILEPATH);
        fillListWithAllCloseCombatWeapons();
    }

    private void loadGearGroupChoiceBox() {
        gearGroupChoiceBox.getItems().add(SHOWALL);
        gearGroupChoiceBox.getItems().add(BASTARDSWORDS);
        gearGroupChoiceBox.getItems().add(TWO_HANDED_IMPACT_WEAPON);
        gearGroupChoiceBox.getItems().add(DAGGERS);
        gearGroupChoiceBox.getItems().add(FENCING_WEAPONS);
        gearGroupChoiceBox.getItems().add(IMPACT_WEAPONS);
    }

    public void loadGearChoiceBoxListener(){
        gearGroupChoiceBox.setOnAction(event -> {
            gearListView.getItems().clear();
            switch(gearGroupChoiceBox.getValue()) {
                case DAGGERS:
                    fillListWithAllDaggers();
                    break;
                case FENCING_WEAPONS:
                    fillListWithAllFencingWeapons();
                    break;
                case TWO_HANDED_IMPACT_WEAPON:
                    fillListWithAllTwoHandedImpactWeapons();
                    break;
                case BASTARDSWORDS:
                    fillListWithAllBastardswords();
                    break;
                case IMPACT_WEAPONS:
                    fillListWithImpactWeapons();
                    break;
                default:
                    fillListWithAllCloseCombatWeapons();
            }
        });
    }

    public Weapon_closeCombat fromNameToWeapon(String name){
        for (Weapon_closeCombat ccw : closeCombatWeaponList){
            if(name.equals(ccw.getName())){
                return ccw;
            }
        }
        return null;
    }

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

    public void fillListWithAllCloseCombatWeapons(){
        gearListView.setItems(castGearListToWeaponList(weaponObservableList));
    }

    public void fillListWithImpactWeapons(){
        gearListView.setItems(castGearListToWeaponList(impactWeapons));
    }

    public void fillListWithAllDaggers(){
        gearListView.setItems(castGearListToWeaponList(daggers));
    }

    public void fillListWithAllFencingWeapons(){
        gearListView.setItems(castGearListToWeaponList(fencingWeapons));
    }

    public void fillListWithAllTwoHandedImpactWeapons(){
        gearListView.setItems(castGearListToWeaponList(twoHandedImpactWeapons));
    }

    public void fillListWithAllBastardswords(){
        gearListView.setItems(castGearListToWeaponList(bastardswords));
    }

    private ObservableList<Gear> castGearListToWeaponList(ObservableList<Weapon_closeCombat> weaponList){
        ObservableList<Gear> gearList = FXCollections.observableArrayList();
        gearList.addAll(weaponList);
        return gearList;
    }

}
