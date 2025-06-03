package mrthomas20121.thermalconstruct.init;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.modifiers.BlisteringModifier;
import mrthomas20121.thermalconstruct.modifiers.FluxChargeModifier;
import mrthomas20121.thermalconstruct.modifiers.FluxShieldModifier;
import mrthomas20121.thermalconstruct.modifiers.CallBackModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ThermalConstructModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(ThermalConstruct.MOD_ID);

    public static StaticModifier<CallBackModifier> CALLBACK = MODIFIERS.register("callback", CallBackModifier::new);
    public static StaticModifier<FluxShieldModifier> FLUX_SHIELD = MODIFIERS.register("flux_shield", FluxShieldModifier::new);
    public static StaticModifier<FluxChargeModifier> FLUX_CHARGE = MODIFIERS.register("flux_charge", FluxChargeModifier::new);
    public static StaticModifier<BlisteringModifier> BLISTERING = MODIFIERS.register("blistering", BlisteringModifier::new);
}
