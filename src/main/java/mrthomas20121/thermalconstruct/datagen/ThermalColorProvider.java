package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalModifierIds;
import net.minecraft.data.PackOutput;

public class ThermalColorProvider extends MantleColorGenerator {

    public ThermalColorProvider(PackOutput packOutput) {
        super(packOutput, ThermalConstruct.MOD_ID);
    }

    @Override
    void addColors() {
        addModifier(ThermalModifierIds.ENDSPLOSION, "#4BCFCD");
        addModifier(ThermalModifierIds.FLUORESCENCE, "#FFF1AA");
        addModifier(ThermalModifierIds.PRICKLY_GLOW, "#FFF1AA");
        addModifier(ThermalModifierIds.INTEGRAL, "#F31700");
        addModifier(ThermalModifierIds.REDSTONE_FLUXED, "#95CFE6");
    }
}
