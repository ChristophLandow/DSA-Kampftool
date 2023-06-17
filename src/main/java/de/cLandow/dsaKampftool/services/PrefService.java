package de.cLandow.dsaKampftool.services;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.prefs.Preferences;
import static de.cLandow.dsaKampftool.Constants.*;

@Singleton
public class PrefService {

    private final Preferences preferences;

    @Inject
    public PrefService(){
        this.preferences = Preferences.userRoot().node(this.getClass().getName());
    }

    public void saveDirectory(String directory){
        preferences.put(DIRECTORY, directory);
    }

    public String getDirectory(){
        return preferences.get(DIRECTORY, NOSAVEFILE);
    }
}
