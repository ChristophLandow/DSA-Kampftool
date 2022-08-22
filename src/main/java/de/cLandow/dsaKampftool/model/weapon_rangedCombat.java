package de.cLandow.dsaKampftool.model;

import java.util.List;

public record Weapon_rangedCombat(
        String name,
        String tp,
        List reichweiten,
        List tpPlus,
        int laden
){
}
