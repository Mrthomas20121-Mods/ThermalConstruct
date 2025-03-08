package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

import static net.minecraft.world.item.Tiers.DIAMOND;
import static net.minecraft.world.item.Tiers.NETHERITE;

public class ThermalMaterialStatsProvider extends AbstractMaterialStatsDataProvider {

    public ThermalMaterialStatsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialStats() {
        addMelee();
        addRanged();
        addArmor();
    }

    private void addMelee() {

        addMaterialStats(ThermalMaterialIds.ENDERIUM,
                new HeadMaterialStats(1525, 5.7f, NETHERITE, 2.8f),
                HandleMaterialStats.multipliers().durability(1.15f).miningSpeed(1.05f).attackSpeed(0.95f).attackDamage(1f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalMaterialIds.LUMIUM,
                new HeadMaterialStats(480, 3.5f, DIAMOND, 3.25f),
                HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1f).attackSpeed(1.20f).attackDamage(0.90f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalMaterialIds.SIGNALUM,
                new HeadMaterialStats(580, 7f, DIAMOND, 2f),
                HandleMaterialStats.multipliers().durability(0.95f).miningSpeed(1.15f).attackSpeed(1f).attackDamage(1.05f).build(),
                StatlessMaterialStats.BINDING);
    }

    private void addRanged() {

        addMaterialStats(ThermalMaterialIds.BASALZ, StatlessMaterialStats.BOWSTRING);
        addMaterialStats(ThermalMaterialIds.BLITZ, StatlessMaterialStats.BOWSTRING);
        addMaterialStats(ThermalMaterialIds.BLIZZ, StatlessMaterialStats.BOWSTRING);

        addMaterialStats(ThermalMaterialIds.SIGNALUM,
                new LimbMaterialStats(580, -0.15f, 0.15f, 0.02f),
                new GripMaterialStats(0.25f, 0.02f, 3f));

        addMaterialStats(ThermalMaterialIds.LUMIUM,
                new LimbMaterialStats(480, 0.12f, -0.05f, 0.1f),
                new GripMaterialStats(0.1f, -0.05f, 2.7f));

    }

    private void addArmor() {

        addMaterialStats(ThermalMaterialIds.BASALZ, StatlessMaterialStats.SHIELD_CORE);
        addMaterialStats(ThermalMaterialIds.BLITZ, StatlessMaterialStats.SHIELD_CORE);
        addMaterialStats(ThermalMaterialIds.BLIZZ, StatlessMaterialStats.SHIELD_CORE);

        addArmorShieldStats(ThermalMaterialIds.SIGNALUM,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(30)
                        .armor(2, 5, 7, 2)
                        .toughness(2).
                        knockbackResistance(0.07f),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(ThermalMaterialIds.LUMIUM,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(25)
                        .armor(2, 5, 6, 2)
                        .toughness(1).
                        knockbackResistance(0.3f),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(ThermalMaterialIds.ENDERIUM,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(50)
                        .armor(3, 6, 8, 3)
                        .toughness(2).
                        knockbackResistance(0.10f),
                StatlessMaterialStats.MAILLE);
    }

    @Override
    public String getName() {
        return "Thermal Material Stats";
    }
}
