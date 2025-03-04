package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

import static net.minecraft.world.item.Tiers.DIAMOND;
import static net.minecraft.world.item.Tiers.NETHERITE;

public class ThermalMaterialStatsProvider extends AbstractMaterialStatsDataProvider {

    public ThermalMaterialStatsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialStats() {
        addMaterialStats(ThermalMaterialIds.ENDERIUM,
                new HeadMaterialStats(1525, 5.7f, NETHERITE, 2.8f),
                new HandleMaterialStats(1.15f, 1.05f, 0.95f, 1f),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalMaterialIds.LUMIUM,
                new HeadMaterialStats(480, 3.5f, DIAMOND, 3.25f),
                new HandleMaterialStats(1.05f, 1f, 1.20f, 0.90f),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalMaterialIds.SIGNALUM,
                new HeadMaterialStats(580, 7f, DIAMOND, 2f),
                new HandleMaterialStats(0.95f, 1.15f, 1f, 1.05f),
                StatlessMaterialStats.BINDING);
    }

    @Override
    public String getName() {
        return "Thermal Material Stats";
    }
}
