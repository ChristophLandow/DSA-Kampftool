package de.cLandow.dsaKampftool.model;

import javafx.collections.ObservableArray;

public record Ability(
        String name,

        Integer attackModificator,
        Integer paradeModificator,

        Integer initiativeModificator,

        Double encumbranceModificator
) {
}
