package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.subcontroller.SpecialAbilityController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class CharacterScreenController implements ScreenController{

    @FXML TextField behinderungBeinRechtsBox;
    @FXML TextField behinderungKopfBox;
    @FXML TextField behinderungBeinLinksBox;
    @FXML TextField behinderungBauchBox;
    @FXML TextField behinderungBrustBox;
    @FXML TextField behinderungRueckenBox;
    @FXML TextField behinderungArmRechtsBox;
    @FXML TextField behinderungArmLinksBox;
    @FXML ChoiceBox<String> specialAbilityChoiceBox;
    @FXML Text warnungText;

    private Parent characterScreenParent;

    private SpecialAbilityController specialAbilityController;
    private final ArrayList<TextField> behinderungKoerperzonen = new ArrayList<>();

    public CharacterScreenController() {
        loadSpecialAblilitys();
    }

    @Override
    public void init() {
        behinderungKoerperzonen.add(behinderungArmLinksBox);
        behinderungKoerperzonen.add(behinderungArmRechtsBox);
        behinderungKoerperzonen.add(behinderungBeinLinksBox);
        behinderungKoerperzonen.add(behinderungBeinRechtsBox);
        behinderungKoerperzonen.add(behinderungKopfBox);
        behinderungKoerperzonen.add(behinderungBrustBox);
        behinderungKoerperzonen.add(behinderungRueckenBox);
        behinderungKoerperzonen.add(behinderungBauchBox);
        setListenertoBehinderungsliste();
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/characterScreen.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        characterScreenParent = parent;
        return parent;
    }

    private void setListenertoBehinderungsliste(){
        for(TextField field : behinderungKoerperzonen){
            field.textProperty().addListener((observable, oldValue, newValue) -> {
                if(!field.getText().isEmpty()){
                    if(field.getText().length() > 2){
                        field.setText(field.getText().substring(0,2));
                    }
                    float testInput = 0;
                    try
                    {
                        testInput = Float.parseFloat(field.getText());
                        warnungText.setVisible(false);

                    }
                    catch (NumberFormatException e)
                    {
                        field.clear();
                        warnungText.setVisible(true);
                    }
                }
            });
        }
    }

    public Parent getCharacterScreenParent() {
        return this.characterScreenParent;
    }

    public int getSummBehinderung(){
        int result = 0;
        for(TextField field : behinderungKoerperzonen){
            if(field.getText().isEmpty()){
                result += 0;
            } else {
                result += Integer.parseInt(field.getText());
            }
        }
        return  result;
    }

    public void loadSpecialAblilitys(){
        specialAbilityController = new SpecialAbilityController(specialAbilityChoiceBox);
    }
}
