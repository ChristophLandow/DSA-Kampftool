package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.services.AvatarService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import java.io.File;
import java.io.IOException;
import static de.cLandow.dsaKampftool.Constants.*;

public class AvatarBoxController implements RenderController {


    @FXML Circle addAvatarCircle;
    @FXML Circle arrowUpCircle;
    @FXML Circle arrowDownCircle;
    @FXML Text fileSizeText;
    @FXML AnchorPane imageBoxAnchor;
    @FXML Circle characterImageCircle;
    private Image currentImage;

    private LoadCharacterPopupController characterLoadPopupController;
    private CharacterVBoxController characterVBoxController;

    public AvatarBoxController(LoadCharacterPopupController characterLoadPopupController){
        this.characterLoadPopupController = characterLoadPopupController;
        this.characterVBoxController = null;
    }

    public AvatarBoxController(CharacterVBoxController characterVBoxController) {
        this.characterVBoxController = characterVBoxController;
        this.characterLoadPopupController = null;
    }

    @Override
    public void init() {
        fileSizeText.setVisible(false);
        setAvatarImage();
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/imageBox.fxml"));
        loader.setControllerFactory(c->this);
        final Parent imageBoxParent;
        try {
            imageBoxParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return imageBoxParent;
    }

    public void uploadOwnAvatar(MouseEvent mouseEvent) throws IOException {
        AvatarService avatarService = new AvatarService();
        File avatarURL = avatarService.loadAvatarURL();
        if(avatarURL != null) {
            if(avatarService.checkFileSize(avatarURL)){
                fileSizeText.setVisible(false);
                currentImage = new Image(avatarURL.toURI().toString());
                characterImageCircle.setFill(new ImagePattern(currentImage));
            } else {
                fileSizeText.setVisible(true);
            }
        }
    }

    public Image getImage(){
        return currentImage;
    }

    public void AvatarListUpScroll(MouseEvent mouseEvent) {
    }

    public void AvatarListDownScroll(MouseEvent mouseEvent) {
    }

    public void setAvatarImage() {
        avatarCircle.setFill(new ImagePattern(currentAvatar));
        AvatarService avatarService = new AvatarService();
        avatarService.saveImageAsFile(currentAvatar,CHARACTER_FILEPATH + currentCharacter.getName() + "//" + currentCharacter.getName() + ".png");
    }
}
