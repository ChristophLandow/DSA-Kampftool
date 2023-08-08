package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static de.cLandow.dsaKampftool.Constants.AVATAR_CHAR_LIMIT;

public class ImageBoxController implements RenderController {

    @FXML Text fileSizeText;
    @FXML AnchorPane imageBoxAnchor;
    @FXML Circle characterImageCircle;
    @FXML Spinner<String> newCharacterProtraitSpinner;

    private final CharacterLoadPopupController characterLoadPopupController;

    public ImageBoxController(CharacterLoadPopupController characterLoadPopupController){
        this.characterLoadPopupController = characterLoadPopupController;
    }

    @Override
    public void init() {
        fileSizeText.setVisible(false);
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

    public void uploadOwnPicture(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Choose Avatar", "*.PNG", "*.jpg"));
        File avatarURL = fileChooser.showOpenDialog(null);
        if(avatarURL != null) {
            byte[] data = Files.readAllBytes(Paths.get(avatarURL.toURI()));
            String avatarB64 =  Base64.getEncoder().encodeToString(data);
            if (avatarB64.length() > AVATAR_CHAR_LIMIT) {
                fileSizeText.setVisible(true);
            } else {
                fileSizeText.setVisible(false);
                Image image = new Image(avatarURL.toURI().toString());
                characterImageCircle.setFill(new ImagePattern(image));
            }


        }
    }

    public static void saveAsPNG(Image image, String path) {
        File outputFile = new File(path);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
