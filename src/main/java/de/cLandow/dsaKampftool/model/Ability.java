package de.cLandow.dsaKampftool.model;

import javafx.collections.ObservableArray;

public record Ability(
        String abilityName,

        Integer attackModificator,
        Integer paradeModificator,

        Integer initiativeModificator,

        Double encumbranceModificator
) {
}
