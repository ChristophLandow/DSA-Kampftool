package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Character;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static de.cLandow.dsaKampftool.Constants.*;

public class AvatarService {

    public AvatarService(){
    }

    public Boolean checkFileSize(File avatarURL){
        byte[] data;
        try {
            data = Files.readAllBytes(Paths.get(avatarURL.toURI()));
            String avatarB64 =  Base64.getEncoder().encodeToString(data);
            return avatarB64.length() <= AVATAR_CHAR_LIMIT;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File loadAvatarURL() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Wähle einen Avatar", "*.PNG", "*.jpg"));
        return fileChooser.showOpenDialog(null);
    }

    public  void saveImageAsFile(Image image, Character character) {
        File outputFile = new File(CHARACTER_FILEPATH + character.getName() + "//" + character.getName() + ".png");
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "PNG", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Image loadAvatarFromCharacterDirectory(Character currentCharacter){
        try {
            return new Image(CHARACTER_FILEPATH + currentCharacter.getName() + "//" + currentCharacter.getName() + ".png");
        } catch (IllegalArgumentException e){
            return new Image(STANDARD_CHARACTER_AVATAR_FILEPATH);
        }

    }
}
