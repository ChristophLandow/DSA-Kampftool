package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.scene.Parent;

public class SelectedCharacteristicsBoxController implements RenderController {

    private final AddCharacteristicsPopupController addCharacteristicsPopupController;

    public SelectedCharacteristicsBoxController(AddCharacteristicsPopupController addCharacteristicsPopupController){
        this.addCharacteristicsPopupController = addCharacteristicsPopupController;
    }

    @Override
    public void init() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        return null;
    }
}
