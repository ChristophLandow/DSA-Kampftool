package de.cLandow.dsaKampftool.model;

import java.util.List;

public record weapon_rangedCombat(
        String name,
        String tp,
        List reichweiten,
        List tpPlus,
        int gewicht,
        int laden
){
}
