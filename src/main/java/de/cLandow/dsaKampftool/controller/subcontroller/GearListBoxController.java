package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Armor;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import de.cLandow.dsaKampftool.model.Weapon_rangedCombat;
import de.cLandow.dsaKampftool.services.ReadFileService;
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
    ListView<String> gearListView;

    private ArrayList<Armor> armorList = new ArrayList<>();
    private ArrayList<Weapon_closeCombat> closeCombatWeaponList = new ArrayList<>();
    private ArrayList<Weapon_closeCombat> twoHandedImpactWeapons = new ArrayList<>();

    private ArrayList<Weapon_closeCombat> bastardswords = new ArrayList<>();
    private ArrayList<Weapon_closeCombat> fencingWeapons = new ArrayList<>();
    private ArrayList<Weapon_closeCombat> daggers = new ArrayList<>();
    private ArrayList<Weapon_rangedCombat> rangedCombatWeaponList = new ArrayList<>();

    public GearListBoxController(){

    }

    @Override
    public void init() {
        loadGearGroupChoiceBox();
        loadGearLists();
        loadListeners();
        /*Make listview to select multiple values*/
        gearListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
        closeCombatWeaponList = readFileService.loadGear();
        for(Weapon_closeCombat ccw : closeCombatWeaponList){
            gearListView.getItems().add(ccw.name());
        }
        System.out.println(daggers);
        System.out.println(fencingWeapons);
        System.out.println(twoHandedImpactWeapons);
        System.out.println(bastardswords);
    }

    private void loadListeners() {
        gearListView.setOnMouseClicked((event -> {
            if (gearListView.getSelectionModel().isEmpty()) {
                event.consume();
            }
            //gearListView.getSelectionModel().getSelectedItem();
        }));
    }

    private void loadGearGroupChoiceBox() {
        gearGroupChoiceBox.getItems().add("Zweihand-Hiebwaffen");
        gearGroupChoiceBox.getItems().add("Dolche");
        gearGroupChoiceBox.getItems().add("Fechtwaffen");
    }

    public Weapon_closeCombat fromNameToWeapon(String name){
        for (Weapon_closeCombat ccw : closeCombatWeaponList){
            if(name.equals(ccw.name())){
                return ccw;
            }
        }
        return null;
    }

    public void setDaggers(ArrayList<Weapon_closeCombat> daggers) {
        this.daggers = daggers;
    }

    public void setFencingWeapons(ArrayList<Weapon_closeCombat> fencingWeapons) {
        this.fencingWeapons = fencingWeapons;
    }

    public void setTwoHandedImpactWeapons(ArrayList<Weapon_closeCombat> twoHandedImpactWeapons) {
        this.twoHandedImpactWeapons = twoHandedImpactWeapons;
    }

    public void setBastardswords(ArrayList<Weapon_closeCombat> bastardswords) {
        this.bastardswords = bastardswords;
    }
}
