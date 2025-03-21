package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import mrthomas20121.thermalconstruct.ThermalModifierIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class ThermalColorProvider extends MantleColorGenerator {

    public ThermalColorProvider(PackOutput packOutput) {
        super(packOutput, ThermalConstruct.MOD_ID);
    }

    @Override
    void addColors() {

        addMaterialAndModifiers(ThermalMaterialIds.BASALZ, "#32353A", ThermalModifierIds.SUNDERED);
        addMaterialAndModifiers(ThermalMaterialIds.BLITZ, "#DEF7FA", ThermalModifierIds.SHOCKED);
        addMaterialAndModifiers(ThermalMaterialIds.BLIZZ, "#37B7FE", ThermalModifierIds.SHOCKED, ThermalModifierIds.FREEZING_PROTECTION);

        addMaterialAndModifiers(ThermalMaterialIds.ENDERIUM, "#4BCFCD", ThermalModifierIds.ENDSPLOSION, ThermalModifierIds.SPECTRAL);
        addMaterialAndModifiers(ThermalMaterialIds.LUMIUM, "#FFF1AA", ThermalModifierIds.FLUORESCENCE, ThermalModifierIds.PRICKLY_GLOW);
        addMaterialAndModifiers(ThermalMaterialIds.LUMIUM, "#FF9543", ThermalModifierIds.SCIENTISTIC);

        addModifier(ThermalModifierIds.INTEGRAL, "#F31700");
        addModifier(ThermalModifierIds.FLUXED, "#95CFE6");
    }

    private void addMaterialAndModifiers(MaterialId mat, String color, ModifierId... modifiers) {
        addMaterial(mat, color);

        for (ModifierId id : modifiers) {
            addModifier(id, color);
        }
    }
}
