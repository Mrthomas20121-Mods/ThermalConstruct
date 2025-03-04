package mrthomas20121.thermalconstruct;

import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class ThermalMaterialIds {

    public static MaterialId SIGNALUM = create("signalum");
    public static MaterialId LUMIUM = create("lumium");
    public static MaterialId ENDERIUM = create("enderium");

    public static MaterialId create(String name) {
        return new MaterialId("thermalconstruct", name);
    }
}
