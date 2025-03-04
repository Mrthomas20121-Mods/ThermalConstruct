package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.tools.data.ModifierIds;

public class ThermalMaterialTraitProvider extends AbstractMaterialTraitDataProvider {

    public ThermalMaterialTraitProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(ThermalMaterialIds.ENDERIUM, ModifierIds.pierce);
        addDefaultTraits(ThermalMaterialIds.LUMIUM, ModifierIds.pierce);
        addDefaultTraits(ThermalMaterialIds.SIGNALUM, ModifierIds.pierce);
    }

    @Override
    public String getName() {
        return "Thermal Material Traits";
    }
}
