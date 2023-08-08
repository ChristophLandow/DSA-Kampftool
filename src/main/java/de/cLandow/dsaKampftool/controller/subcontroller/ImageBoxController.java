package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static de.cLandow.dsaKampftool.Constants.AVATAR_CHAR_LIMIT;

public class ImageBoxController implements RenderController {

    @FXML AnchorPane imageBoxAnchor;
    @FXML Circle characterImageCircle;
    @FXML Spinner<String> newCharacterProtraitSpinner;

    public ImageBoxController(){

    }

    @Override
    public void init() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/characterImageBox.fxml"));
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

    public void uploadOwnPicture(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Choose Avatar", "*.PNG", "*.jpg"));
        File avatarURL = fileChooser.showOpenDialog(null);
        if(avatarURL != null) {
            byte[] data = Files.readAllBytes(Paths.get(avatarURL.toURI()));
            String avatarB64 =  Base64.getEncoder().encodeToString(data);
            if (avatarB64.length() > AVATAR_CHAR_LIMIT) {
                System.out.println("ZU GROß!!");
                //this.avatarStatusText.setText("Image exceeds file size limit");
            } else {
                Image image = new Image(avatarURL.toURI().toString());
                characterImageCircle.setFill(new ImagePattern(image));
                //ImageIO.write(SwingFXUtils.fromFXImage(newImage, null,"png", file));
            }
        }
    }
}
