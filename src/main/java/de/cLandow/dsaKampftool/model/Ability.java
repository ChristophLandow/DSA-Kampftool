package de.cLandow.dsaKampftool.model;

public record Ability(
        String abilityName,

        int attackModificator,
        int paradeModificator,

        int initiativeModificator,

        String modifiedArmorPiece
) {
}
