package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.controller.subcontroller.GearListBoxController;
import de.cLandow.dsaKampftool.model.Armor;
import javafx.collections.ObservableList;
import org.xml.sax.helpers.DefaultHandler;

public class ArmorFileReadHandler extends DefaultHandler {

    private final GearListBoxController gearListBoxController;


    public ArmorFileReadHandler(GearListBoxController gearListBoxController) {
        this.gearListBoxController = gearListBoxController;
    }



    public ObservableList<Armor> getObservableArmorList() {
        return null;
    }
}
