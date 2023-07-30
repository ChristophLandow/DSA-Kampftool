package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.model.Characteristic;
import de.cLandow.dsaKampftool.model.Gear;
import javafx.scene.control.ListCell;

public class CharacteristicsListItemController extends ListCell<Characteristic> {
    private final CharacteristicsListBoxController characteristicsListBoxController;

    public CharacteristicsListItemController(CharacteristicsListBoxController characteristicsListBoxController) {
        this.characteristicsListBoxController = characteristicsListBoxController;
    }
}
