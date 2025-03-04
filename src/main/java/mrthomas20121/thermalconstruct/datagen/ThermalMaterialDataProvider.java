package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class ThermalMaterialDataProvider extends AbstractMaterialDataProvider {


    public ThermalMaterialDataProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {
        addMaterial(ThermalMaterialIds.ENDERIUM, 4, ORDER_END, false);
        addMaterial(ThermalMaterialIds.LUMIUM, 3, ORDER_NETHER, false);
        addMaterial(ThermalMaterialIds.SIGNALUM, 3, ORDER_HARVEST, false);
    }

    @Override
    public String getName() {
        return "Thermal Material Data Provider";
    }
}
