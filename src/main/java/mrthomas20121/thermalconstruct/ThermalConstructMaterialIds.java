package mrthomas20121.thermalconstruct;

import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class ThermalConstructMaterialIds {

    public static MaterialId BLIZZ = create("blizz");
    public static MaterialId BLITZ = create("blitz");
    public static MaterialId BASALZ = create("basalz");
    public static MaterialId SIGNALUM = create("signalum");
    public static MaterialId LUMIUM = create("lumium");
    public static MaterialId ENDERIUM = create("enderium");

    public static MaterialId SOUL_INFUSED = create("soul_infused");
    public static MaterialId TWINITE = create("twinite");
    public static MaterialId SHELLITE = create("shellite");
    public static MaterialId DRAGONSTEEL = create("dragonsteel");
    public static MaterialId ABYSSAL = create("abyssal");

    public static MaterialId create(String name) {
        return new MaterialId("thermalconstruct", name);
    }
}
