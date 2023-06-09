package de.cLandow.dsaKampftool.model;

import javafx.collections.ObservableArray;

public record Ability(
        String abilityName,

        int attackModificator,
        int paradeModificator,

        int initiativeModificator,

        String modifiedArmorPiece
) {
}
