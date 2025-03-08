package mrthomas20121.thermalconstruct.init;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.modifiers.KineticVelocityModifier;
import mrthomas20121.thermalconstruct.modifiers.ShulkingModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
import slimeknights.tconstruct.tools.modifiers.EnergyHandlerModifier;

public class ThermalModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(ThermalConstruct.MOD_ID);

    public static StaticModifier<ShulkingModifier> SHULKING = MODIFIERS.register("shulking", ShulkingModifier::new);
    public static StaticModifier<KineticVelocityModifier> KINETIC_VELOCITY = MODIFIERS.register("kinetic_velocity", KineticVelocityModifier::new);
}
