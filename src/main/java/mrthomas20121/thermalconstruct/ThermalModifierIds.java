package mrthomas20121.thermalconstruct;

import slimeknights.tconstruct.library.modifiers.ModifierId;

public class ThermalModifierIds {

    // traits
    public static ModifierId WANDERER = create("wanderer");
    public static ModifierId FLUORESCENCE = create("fluorescence");
    public static ModifierId PRICKLY_GLOW = create("prickly_glow");
    public static ModifierId ENDSPLOSION = create("endsplosion");
    public static ModifierId SPECTRAL = create("spectral");

    public static ModifierId CHILLED = create("chilled");
    public static ModifierId SHOCKED = create("shocked");
    public static ModifierId SUNDERED = create("sundered");

    // modifiers
    public static ModifierId REDSTONE_FLUXED = create("redstone_fluxed");

    public static ModifierId INTEGRAL = create("integral");

    public static ModifierId create(String name) {
        return new ModifierId("thermalconstruct", name);
    }
}
