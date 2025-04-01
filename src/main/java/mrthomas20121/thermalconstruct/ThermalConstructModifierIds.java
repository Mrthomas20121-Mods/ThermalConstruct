package mrthomas20121.thermalconstruct;

import slimeknights.tconstruct.library.modifiers.ModifierId;

public class ThermalConstructModifierIds {

    // traits
    public static ModifierId ACCUSTOMED = create("accustomed");
    public static ModifierId FLUORESCENCE = create("fluorescence");
    public static ModifierId PRICKLY_GLOW = create("prickly_glow");
    public static ModifierId BUSHWHACK = create("bushwhack");
    public static ModifierId SPECTRAL = create("spectral");
    public static ModifierId CHILLED = create("chilled");
    public static ModifierId SHOCKED = create("shocked");
    public static ModifierId SUNDERED = create("sundered");
    public static ModifierId FREEZING_PROTECTION = create("freezing_protection");
    public static ModifierId SUBTERRANEAN = create("subterranean");
    public static ModifierId RESONANCE = create("resonance");
    public static ModifierId TOUGH_SHELL = create("tough_shell");
    public static ModifierId GHOSTLY = create("ghostly");
    public static ModifierId ENERGIZED = create("energized");
    public static ModifierId SIPHONING = create("siphoning");

    // modifiers
    public static ModifierId INTEGRAL = create("integral");

    public static ModifierId create(String name) {
        return new ModifierId("thermalconstruct", name);
    }
}
