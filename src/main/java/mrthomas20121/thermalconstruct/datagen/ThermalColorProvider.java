package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalConstructMaterialIds;
import mrthomas20121.thermalconstruct.ThermalConstructModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalConstructModifiers;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class ThermalColorProvider extends MantleColorGenerator {

    public ThermalColorProvider(PackOutput packOutput) {
        super(packOutput, ThermalConstruct.MOD_ID);
    }

    @Override
    void addColors() {

        addMaterialAndModifiers(ThermalConstructMaterialIds.BASALZ, "#32353A", ThermalConstructModifierIds.SUNDERED);
        addMaterialAndModifiers(ThermalConstructMaterialIds.BLITZ, "#DEF7FA", ThermalConstructModifierIds.SHOCKED);
        addMaterialAndModifiers(ThermalConstructMaterialIds.BLIZZ, "#37B7FE", ThermalConstructModifierIds.SHOCKED, ThermalConstructModifierIds.FREEZING_PROTECTION);

        addMaterialAndModifiers(ThermalConstructMaterialIds.ENDERIUM, "#4BCFCD", ThermalConstructModifierIds.BUSHWHACK, ThermalConstructModifierIds.SPECTRAL);
        addMaterialAndModifiers(ThermalConstructMaterialIds.LUMIUM, "#FFF1AA", ThermalConstructModifierIds.FLUORESCENCE, ThermalConstructModifierIds.PRICKLY_GLOW);
        addMaterialAndModifiers(ThermalConstructMaterialIds.SIGNALUM, "#FF9543", ThermalConstructModifiers.POWER_SHIELD.getId());
        addMaterialAndModifiers(ThermalConstructMaterialIds.TWINITE, "#FFD1E5", ThermalConstructModifiers.POWER_ATTACK.getId());
        addMaterialAndModifiers(ThermalConstructMaterialIds.DRAGONSTEEL, "#729EDB", ThermalConstructModifierIds.ENERGIZED, ThermalConstructModifiers.BLISTERING.getId());
        addMaterialAndModifiers(ThermalConstructMaterialIds.ABYSSAL, "#8DB37C", ThermalConstructModifierIds.RESONANCE, ThermalConstructModifierIds.SUBTERRANEAN);
        addMaterialAndModifiers(ThermalConstructMaterialIds.SOUL_INFUSED, "#8DB37C", ThermalConstructModifierIds.RESONANCE, ThermalConstructModifierIds.SUBTERRANEAN);

        addModifier(ThermalConstructModifierIds.INTEGRAL, "#F31700");
    }

    private void addMaterialAndModifiers(MaterialId mat, String color, ModifierId... modifiers) {
        addMaterial(mat, color);

        for (ModifierId id : modifiers) {
            addModifier(id, color);
        }
    }
}
