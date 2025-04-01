package mrthomas20121.thermalconstruct.init;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.modifiers.BlisteringModifier;
import mrthomas20121.thermalconstruct.modifiers.PowerAttackModifier;
import mrthomas20121.thermalconstruct.modifiers.PowerShieldModifier;
import mrthomas20121.thermalconstruct.modifiers.CallBackModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ThermalConstructModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(ThermalConstruct.MOD_ID);

    public static StaticModifier<CallBackModifier> CALLBACK = MODIFIERS.register("callback", CallBackModifier::new);
    public static StaticModifier<PowerShieldModifier> POWER_SHIELD = MODIFIERS.register("power_shield", PowerShieldModifier::new);
    public static StaticModifier<PowerAttackModifier> POWER_ATTACK = MODIFIERS.register("power_attack", PowerAttackModifier::new);
    public static StaticModifier<BlisteringModifier> BLISTERING = MODIFIERS.register("blistering", BlisteringModifier::new);
}
