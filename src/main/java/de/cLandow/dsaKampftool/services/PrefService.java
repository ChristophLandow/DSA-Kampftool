package de.cLandow.dsaKampftool.services;

import java.util.prefs.Preferences;
import static de.cLandow.dsaKampftool.Constants.*;


public class PrefService {

    private final Preferences preferences;

    public PrefService(){
        this.preferences = Preferences.userRoot().node(this.getClass().getName());
    }

    public void saveDirectory(String directory){
        preferences.put(DIRECTORY, directory);
    }

    public String getDirectory(){
        return preferences.get(DIRECTORY, NOSAVEFILE);
    }

    public void saveCharacterName(String name){
        preferences.put(CHARACTER, name);
    }

    public String getCharacterName(){
        return preferences.get(CHARACTER, NOCHARACTER);
    }
}
