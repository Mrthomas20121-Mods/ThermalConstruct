package mrthomas20121.thermalconstruct.init;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.modifiers.ShulkingModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ThermalConstructModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(ThermalConstruct.MOD_ID);

    public static StaticModifier<ShulkingModifier> SHULKING = MODIFIERS.register("shulking", ShulkingModifier::new);
}
