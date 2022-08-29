package de.cLandow.dsaKampftool.services;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.prefs.Preferences;

@Singleton
public class PrefService {

    private final Preferences preferences;

    @Inject
    public PrefService(){
        this.preferences = Preferences.userRoot().node(this.getClass().getName());
    }

    public void saveBox(String box, Boolean selected){
        preferences.putBoolean(box, selected);
    }

    public boolean getBox(String box){
        return preferences.getBoolean(box, false);
    }
}
