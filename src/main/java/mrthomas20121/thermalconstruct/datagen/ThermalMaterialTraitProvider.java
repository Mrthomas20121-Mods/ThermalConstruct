package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import mrthomas20121.thermalconstruct.ThermalModifierIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.MaterialRegistry;

public class ThermalMaterialTraitProvider extends AbstractMaterialTraitDataProvider {

    public ThermalMaterialTraitProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(ThermalMaterialIds.ENDERIUM, ThermalModifierIds.ENDSPLOSION);
        addDefaultTraits(ThermalMaterialIds.LUMIUM, ThermalModifierIds.FLUORESCENCE);
        addDefaultTraits(ThermalMaterialIds.SIGNALUM, ThermalModifierIds.WANDERER);
        addTraits(ThermalMaterialIds.ENDERIUM, MaterialRegistry.ARMOR, ThermalModifierIds.SPECTRAL);
        addTraits(ThermalMaterialIds.LUMIUM, MaterialRegistry.ARMOR, ThermalModifierIds.PRICKLY_GLOW);
        addTraits(ThermalMaterialIds.BLIZZ, MaterialRegistry.ARMOR, ThermalModifierIds.FREEZING_PROTECTION);

        addDefaultTraits(ThermalMaterialIds.BASALZ, ThermalModifierIds.SUNDERED);
        addDefaultTraits(ThermalMaterialIds.BLITZ, ThermalModifierIds.SHOCKED);
        addDefaultTraits(ThermalMaterialIds.BLIZZ, ThermalModifierIds.CHILLED);
    }

    @Override
    public String getName() {
        return "Thermal Material Traits";
    }
}
