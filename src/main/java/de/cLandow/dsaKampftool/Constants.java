package de.cLandow.dsaKampftool;

public class Constants {

    public static final String SCREEN_TITLE = "DSA4.1 Kampftool";
    public static final int AVATAR_CHAR_LIMIT = 16384;

    public static final String DIRECTORY = "Directory";
    public static final String NOSAVEFILE = "NoSaveFile";

    public static final String CHARACTER = "actualCharacter";

    public static final String NOCHARACTER = "NoCharacterNameSaved";
    public static final String CHARACTER_FILEPATH = System.getProperty("user.home") + "//DSAKampftool//Charakter//";
    public static final String SETUP_FILEPATH = System.getProperty("user.home") + "//DSAKampftool//Setup//";
    public static final String WEAPON_FILEPATH = System.getProperty("user.home") + "//DSAKampftool//Setup//Weapons.xml";
    public static final String ARMOR_FILEPATH = System.getProperty("user.home") + "//DSAKampftool//Setup//Armor.xml";
    public static final String ABILITY_FILEPATH = System.getProperty("user.home") + "//DSAKampftool//Setup//Abilities.xml";
    public static final String CHARACTERISTICS_FILEPATH = System.getProperty("user.home") + "//DSAKampftool//Setup//Characteristics.xml";
    public static final String RIGHT_ARM = "Right Arm";
    public static final String LEFT_ARM = "Left Arm";

    public static final String TORSO = "Chest";

    public static final String TUMMY = "Tummy";
    public static final String BACKSIDE = "Backside";

    public static final String HEAD = "Head";

    public static final String LEFT_LEG = "Left Leg";

    public static final String RIGHT_LEG = "Right Leg";

    public static final String WHITE_BUTTON = "white-button";

    public static final String RED_BUTTON = "red-button";

    // Gear List
    public static final String ZONE = "Zone";
    public static final String HEAD_ARMOR = "Kopf";
    public static final String CHEST_ARMOR = "Brust";
    public static final String BACKSIDE_ARMOR = "Ruecken";
    public static final String TUMMY_ARMOR = "Bauch";
    public static final String RIGHTARM_ARMOR = "RechterArm";
    public static final String LEFTARM_ARMOR = "LinkerArm";
    public static final String RIGHTLEG_ARMOR = "RechtesBein";
    public static final String LEFTLEG_ARMOR = "LinkesBein";

    public static final String FULLARMOR = CHEST_ARMOR + "_" + BACKSIDE_ARMOR + "_" + TUMMY_ARMOR + "_" + LEFTARM_ARMOR
            + "_" + RIGHTARM_ARMOR + "_" + LEFTLEG_ARMOR + "_" + RIGHTLEG_ARMOR;

    public static final String FULLARMOR_WITH_HELMET = HEAD_ARMOR + "_" + CHEST_ARMOR + "_" + BACKSIDE_ARMOR + "_" + TUMMY_ARMOR + "_" + LEFTARM_ARMOR
            + "_" + RIGHTARM_ARMOR + "_" + LEFTLEG_ARMOR + "_" + RIGHTLEG_ARMOR;

    public static final String TORSOARMOR_WITH_HELMET = HEAD_ARMOR + "_" + CHEST_ARMOR + "_" + BACKSIDE_ARMOR;
    public static final String SUMM_ARMOR = "gesamt-Ruestungsschutz";
    public static final String SUMM_ENCUMBRANCE = "gesamt-Behinderung";

    public static final String MAINWEAPON = "Hauptwaffe";
    public static final String SIDEWEAPON = "Nebenwaffe";
    public static final String SHIELD = "Schild";
    public static final String SHOWALL = "Alle";
    public static final String DAMAGE = "Schaden";
    public static final String DISTANCE = "Distanzklasse";
    public static final String STATMOD = "StatModifikator";
    public static final String INITIATIVEMOD = "InitiativeModifikator";
    public static final String DAMAGEMOD = "SchadensModifikator";
    public static final String NAME = "Name";
    public static final String WEAPON = "Waffe";

    public static final String ARMOR = "Ruestung";

    public static final String CLOTHES = "Kleidung";

    public static final String CLOTARMOR = "Tuchruestung";


    public static final String BASTARDSWORDS = "Anderthalbhaender";
    public static final String TWO_HANDED_IMPACT_WEAPON = "Zweihand-Hiebwaffen";
    public static final String DAGGERS = "Dolche";
    public static final String FENCING_WEAPONS = "Fechtwaffen";
    public static final String IMPACT_WEAPONS = "Hiebwaffen";
    public static final String TWOHANDED = "ZweihaendigeWaffe";
    public static final String TRUE = "true";
    public static final String FALSE = "false";


    //Gear Class
    public static final String CLOSECOMBATCLASS = "class de.cLandow.dsaKampftool.model.Weapon_closeCombat";
    public static final String ARMORCLASS = "class de.cLandow.dsaKampftool.model.Armor";

    //Abilities
    public static final String ABILITIES = "Sonderfertigkeiten";
    public static final String ABILITY = "Sonderfertigkeit";
    public static final String ATTACK_MOD = "AttackeModifikator";
    public static final String PARADE_MOD = "ParadeModifikator";
    public static final String INIT_MOD = "InitiativeModifikator";
    public static final String ENCUMBRANCE_MOD = "BehinderungModifikator";

    //Characteristics

    public static final String CHARACTERISTICS = "Vorteile_Nachteile";
    public static final String CHARACTERISTIC = "Vorteil_Nachteil";
    public static final String CHARACTERISTIC_GROUP = "Gruppe";
    public static final String ADVANTAGE = "Vorteil";
    public static final String DRAWBACK = "Nachteil";

    //Images

    public static final String MAINWEAPON_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/sword.png";
    public static final String MAINWEAPON_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/sword_equiped.png";
    public static final String SIDEWEAPON_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/sideWeapon.png";
    public static final String SIDEWEAPON_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/sideWeapon_set.png";
    public static final String SHIELD_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/shield.png";
    public static final String SHIELD_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/shield_set.png";
    public static final String BREASTPLATE_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/breastPlate.png";
    public static final String BREASTPLATE_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/breastPlate_set.png";

    public static final String BACKSIDEPLATE_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/backsidePlate.png";
    public static final String BACKSIDEPLATE_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/backsidePlate_set.png";
    public static final String HELMET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/helmetIcon.png";
    public static final String HELMET_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/helmetIcon_set.png";

    public static final String TUMMYPLATE_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/tummyPlate.png";
    public static final String TUMMYPLATE_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/tummyPlate_set.png";
    public static final String LEFTBOOT_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/leftBoot.png";
    public static final String LEFTBOOT_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/leftBoot_set.png";
    public static final String RIGHTBOOT_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/rightBoot.png";
    public static final String RIGHTBOOT_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/rightBoot_set.png";
    public static final String LEFTGLOVE_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/leftGloveIcon.png";
    public static final String LEFTGLOVE_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/leftGloveIcon_set.png";
    public static final String RIGHTGLOVE_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/rightGloveIcon.png";
    public static final String RIGHTGLOVE_SET_IMAGE_PATH = "src/main/resources/de/cLandow/dsaKampftool/images/rightGloveIcon_set.png";


}
