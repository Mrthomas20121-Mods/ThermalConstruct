package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstructMaterialIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class ThermalConstructMaterialDataProvider extends AbstractMaterialDataProvider {

    public ThermalConstructMaterialDataProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {
        addMaterial(ThermalConstructMaterialIds.ENDERIUM, 4, ORDER_END, false);
        addMaterial(ThermalConstructMaterialIds.LUMIUM, 3, ORDER_NETHER, false);
        addMaterial(ThermalConstructMaterialIds.SIGNALUM, 3, ORDER_HARVEST, false);
        addCompatMetalMaterial(ThermalConstructMaterialIds.SOUL_INFUSED, 3, ORDER_NETHER);
        addCompatMetalMaterial(ThermalConstructMaterialIds.TWINITE, 3, ORDER_NETHER);
        addCompatMetalMaterial(ThermalConstructMaterialIds.SHELLITE, 3, ORDER_END);
        addCompatMetalMaterial(ThermalConstructMaterialIds.DRAGONSTEEL, 4, ORDER_END);
        addCompatMetalMaterial(ThermalConstructMaterialIds.ABYSSAL, 4, ORDER_END);
        addMaterial(ThermalConstructMaterialIds.BASALZ, 2, ORDER_BINDING, true);
        addMaterial(ThermalConstructMaterialIds.BLITZ, 2, ORDER_BINDING, true);
        addMaterial(ThermalConstructMaterialIds.BLIZZ, 2, ORDER_BINDING, true);
    }

    @Override
    public String getName() {
        return "Thermal Material Data Provider";
    }
}
