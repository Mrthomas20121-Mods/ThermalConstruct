package mrthomas20121.thermalconstruct;

import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class ThermalModifierIds {

    public static ModifierId FRENZIED_STRIKES = create("frenzied_strikes");
    public static ModifierId LUMIUM = create("lumium");
    public static ModifierId ENDERIUM = create("enderium");

    public static ModifierId create(String name) {
        return new ModifierId("thermalconstruct", name);
    }
}
