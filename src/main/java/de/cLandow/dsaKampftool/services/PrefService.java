package de.cLandow.dsaKampftool.services;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.prefs.Preferences;

@Singleton
public class PrefService {

    private final Preferences preferences;

    @Inject
    public PrefService(Preferences preferences){
        this.preferences = preferences;
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
