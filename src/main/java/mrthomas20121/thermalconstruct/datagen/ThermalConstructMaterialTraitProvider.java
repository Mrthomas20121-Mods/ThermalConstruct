package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstructMaterialIds;
import mrthomas20121.thermalconstruct.ThermalConstructModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalConstructModifiers;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.MaterialRegistry;

public class ThermalConstructMaterialTraitProvider extends AbstractMaterialTraitDataProvider {

    public ThermalConstructMaterialTraitProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(ThermalConstructMaterialIds.ENDERIUM, ThermalConstructModifierIds.BUSHWHACK);
        addDefaultTraits(ThermalConstructMaterialIds.LUMIUM, ThermalConstructModifierIds.FLUORESCENCE);
        addDefaultTraits(ThermalConstructMaterialIds.SIGNALUM, ThermalConstructModifiers.POWER_SHIELD);
        addDefaultTraits(ThermalConstructMaterialIds.TWINITE, ThermalConstructModifiers.POWER_ATTACK);
        addDefaultTraits(ThermalConstructMaterialIds.ABYSSAL, ThermalConstructModifierIds.SUBTERRANEAN);
        addTraits(ThermalConstructMaterialIds.DRAGONSTEEL, MaterialRegistry.RANGED, ThermalConstructModifiers.BLISTERING);

        addTraits(ThermalConstructMaterialIds.ENDERIUM, MaterialRegistry.ARMOR, ThermalConstructModifierIds.SPECTRAL);
        addTraits(ThermalConstructMaterialIds.LUMIUM, MaterialRegistry.ARMOR, ThermalConstructModifierIds.PRICKLY_GLOW);
        addTraits(ThermalConstructMaterialIds.SOUL_INFUSED, MaterialRegistry.ARMOR, ThermalConstructModifierIds.GHOSTLY);
        addTraits(ThermalConstructMaterialIds.ABYSSAL, MaterialRegistry.ARMOR, ThermalConstructModifierIds.RESONANCE);
        addTraits(ThermalConstructMaterialIds.SHELLITE, MaterialRegistry.ARMOR, ThermalConstructModifierIds.TOUGH_SHELL);
        addTraits(ThermalConstructMaterialIds.DRAGONSTEEL, MaterialRegistry.ARMOR, ThermalConstructModifierIds.ENERGIZED);
        addTraits(ThermalConstructMaterialIds.BLIZZ, MaterialRegistry.ARMOR, ThermalConstructModifierIds.FREEZING_PROTECTION);

        addDefaultTraits(ThermalConstructMaterialIds.BASALZ, ThermalConstructModifierIds.SUNDERED);
        addDefaultTraits(ThermalConstructMaterialIds.BLITZ, ThermalConstructModifierIds.SHOCKED);
        addDefaultTraits(ThermalConstructMaterialIds.BLIZZ, ThermalConstructModifierIds.CHILLED);
    }

    @Override
    public String getName() {
        return "Thermal Material Traits";
    }
}
