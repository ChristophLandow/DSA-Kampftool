package de.cLandow.dsaKampftool.services;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static de.cLandow.dsaKampftool.Constants.AVATAR_CHAR_LIMIT;

public class AvatarService {

    public AvatarService(){
    }

    public Boolean checkFileSize(File avatarURL){
        byte[] data = new byte[0];
        try {
            data = Files.readAllBytes(Paths.get(avatarURL.toURI()));
            String avatarB64 =  Base64.getEncoder().encodeToString(data);
            if (avatarB64.length() > AVATAR_CHAR_LIMIT) {
                return false;
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadOwnPicture() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Wähle einen Avatar", "*.PNG", "*.jpg"));
        File avatarURL = fileChooser.showOpenDialog(null);
        if(avatarURL != null) {
            byte[] data = Files.readAllBytes(Paths.get(avatarURL.toURI()));
            String avatarB64 =  Base64.getEncoder().encodeToString(data);
            if (avatarB64.length() > AVATAR_CHAR_LIMIT) {
                fileSizeText.setVisible(true);
            } else {
                fileSizeText.setVisible(false);
                currentImage = new Image(avatarURL.toURI().toString());
                characterImageCircle.setFill(new ImagePattern(currentImage));
            }


        }
    }
}
