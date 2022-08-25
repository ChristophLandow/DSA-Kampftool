package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Character;

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

    public void saveKampfreflexeBox(Boolean bool){
        preferences.putBoolean(KAMPFREFLEXE, bool);
    }

    public boolean getKampfreflexeButton(){
        return preferences.getBoolean(KAMPFREFLEXE, false);
    }

    /*public void save {
        preferences.put(TEST, "");
        preferences.put("MapRadius", "");
    }*/

    /*public Character getTradeTextField(){
        if(preferences.get(TEST, "").equals("")){
            return Character.MIN_VALUE;
        } else {
            return preferences.get("tradeTextField", "").charAt(0);
        }
    }*/



}
