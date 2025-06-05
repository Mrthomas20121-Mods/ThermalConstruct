package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstructMaterialIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.data.material.MaterialIds;
import slimeknights.tconstruct.tools.stats.*;

import static net.minecraft.world.item.Tiers.*;

public class ThermalConstructMaterialStatsProvider extends AbstractMaterialStatsDataProvider {

    public ThermalConstructMaterialStatsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialStats() {
        addMelee();
        addRanged();
        addArmor();
    }

    private void addMelee() {

        addMaterialStats(ThermalConstructMaterialIds.ENDERIUM,
                new HeadMaterialStats(1525, 6f, NETHERITE, 3f),
                HandleMaterialStats.multipliers().durability(1.15f).miningSpeed(1.05f).attackSpeed(0.95f).attackDamage(1f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalConstructMaterialIds.LUMIUM,
                new HeadMaterialStats(480, 3.5f, DIAMOND, 3.25f),
                HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1f).attackSpeed(1.20f).attackDamage(0.90f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalConstructMaterialIds.SIGNALUM,
                new HeadMaterialStats(580, 7f, DIAMOND, 2f),
                HandleMaterialStats.multipliers().durability(0.95f).miningSpeed(1.15f).attackSpeed(1f).attackDamage(1.05f).build());

        addMaterialStats(ThermalConstructMaterialIds.SOUL_INFUSED,
                new HeadMaterialStats(460, 3.2f, DIAMOND, 3f),
                HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.1f).attackSpeed(0.9f).attackDamage(1f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalConstructMaterialIds.TWINITE,
                new HeadMaterialStats(500, 4f, DIAMOND, 2.5f),
                HandleMaterialStats.multipliers().durability(0.9f).miningSpeed(0.9f).attackSpeed(1.05f).attackDamage(1.1f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalConstructMaterialIds.SHELLITE,
                new HeadMaterialStats(500, 3.5f, DIAMOND, 3.5f),
                HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1f).attackSpeed(1f).attackDamage(1.15f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalConstructMaterialIds.ABYSSAL,
                new HeadMaterialStats(570, 7.1f, DIAMOND, 2.9f),
                HandleMaterialStats.multipliers().durability(1.1f).miningSpeed(1.05f).attackSpeed(0.9f).attackDamage(0.9f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalConstructMaterialIds.BASALZ,
                new HeadMaterialStats(150, 2.6f, STONE, 1.3f),
                HandleMaterialStats.multipliers().durability(0.75f).attackSpeed(1.1f).build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(ThermalConstructMaterialIds.BLITZ,
                new HeadMaterialStats(150, 2.3f, STONE, 1.6f),
                HandleMaterialStats.multipliers().durability(0.75f).attackSpeed(1.1f).build(),
                StatlessMaterialStats.BINDING);
    }

    private void addRanged() {

        addMaterialStats(ThermalConstructMaterialIds.BASALZ, StatlessMaterialStats.BOWSTRING);
        addMaterialStats(ThermalConstructMaterialIds.BLITZ, StatlessMaterialStats.BOWSTRING);
        addMaterialStats(ThermalConstructMaterialIds.BLIZZ, StatlessMaterialStats.BOWSTRING);

        addMaterialStats(ThermalConstructMaterialIds.SIGNALUM,
                new LimbMaterialStats(580, -0.15f, 0.15f, 0.02f),
                new GripMaterialStats(0.25f, 0.02f, 3f));

        addMaterialStats(ThermalConstructMaterialIds.LUMIUM,
                new LimbMaterialStats(480, 0.12f, -0.05f, 0.1f),
                new GripMaterialStats(0.1f, -0.05f, 2.7f));

        addMaterialStats(ThermalConstructMaterialIds.SOUL_INFUSED,
                new LimbMaterialStats(460, 0.15f, -0.15f, 0.03f),
                new GripMaterialStats(0.20f, 0.02f, 2f));

        addMaterialStats(ThermalConstructMaterialIds.TWINITE,
                new LimbMaterialStats(500, -0.15f, 0.05f, 0.07f),
                new GripMaterialStats(0.30f, 0.06f, 2.5f));

        addMaterialStats(ThermalConstructMaterialIds.DRAGONSTEEL,
                new LimbMaterialStats(570, 0.12f, 0.05f, -0.1f),
                new GripMaterialStats(0.3f, 0.05f, 3.5f));

    }

    private void addArmor() {

        addMaterialStats(ThermalConstructMaterialIds.BASALZ, StatlessMaterialStats.SHIELD_CORE);
        addMaterialStats(ThermalConstructMaterialIds.BLITZ, StatlessMaterialStats.SHIELD_CORE);
        addMaterialStats(ThermalConstructMaterialIds.BLIZZ, StatlessMaterialStats.SHIELD_CORE);

        addArmorShieldStats(ThermalConstructMaterialIds.BLIZZ,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(10)
                        .armor(1, 3, 4, 1),
                StatlessMaterialStats.MAILLE);

//        addArmorShieldStats(ThermalMaterialIds.SIGNALUM,
//                PlatingMaterialStats
//                        .builder()
//                        .durabilityFactor(30)
//                        .armor(2, 5, 7, 2)
//                        .toughness(2).
//                        knockbackResistance(0.07f),
//                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(ThermalConstructMaterialIds.LUMIUM,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(25)
                        .armor(2, 5, 6, 3)
                        .toughness(1).
                        knockbackResistance(0.3f),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(ThermalConstructMaterialIds.ENDERIUM,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(50)
                        .armor(3, 6, 8, 4)
                        .toughness(2).
                        knockbackResistance(0.10f),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(ThermalConstructMaterialIds.SHELLITE,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(60)
                        .armor(2, 5, 7, 3)
                        .toughness(1).
                        knockbackResistance(0.20f),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(ThermalConstructMaterialIds.DRAGONSTEEL,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(60)
                        .armor(3, 6, 8, 4)
                        .toughness(2).
                        knockbackResistance(0.20f),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(ThermalConstructMaterialIds.ABYSSAL,
                PlatingMaterialStats
                        .builder()
                        .durabilityFactor(70)
                        .armor(4, 6, 8, 4)
                        .toughness(3).
                        knockbackResistance(0.15f),
                StatlessMaterialStats.MAILLE);
    }

    @Override
    public String getName() {
        return "Thermal Material Stats";
    }
}
