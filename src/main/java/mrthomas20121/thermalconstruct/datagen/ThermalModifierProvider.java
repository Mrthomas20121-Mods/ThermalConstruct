package mrthomas20121.thermalconstruct.datagen;

import cofh.core.init.CoreMobEffects;
import mrthomas20121.thermalconstruct.ThermalModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalModifiers;
import mrthomas20121.thermalconstruct.util.ThermalLivingEntityPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffects;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.RandomLevelingValue;
import slimeknights.tconstruct.library.modifiers.impl.BasicModifier;
import slimeknights.tconstruct.library.modifiers.modules.armor.EffectImmunityModule;
import slimeknights.tconstruct.library.modifiers.modules.behavior.ConditionalStatModule;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierTraitModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.MobEffectModule;
import slimeknights.tconstruct.library.modifiers.modules.display.DurabilityBarColorModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.tools.capability.ToolEnergyCapability;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class ThermalModifierProvider extends AbstractModifierProvider {

    public static ModifierTraitModule THORNS = new ModifierTraitModule(TinkerModifiers.thorns.getId(), 1, true);
    public static ModifierTraitModule SHULKING = new ModifierTraitModule(ThermalModifiers.SHULKING.getId(), 1, true);

    public ThermalModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {

        buildModifier(ThermalModifierIds.INTEGRAL)
                .tooltipDisplay(BasicModifier.TooltipDisplay.TINKER_STATION)
                .levelDisplay(ModifierLevelDisplay.DEFAULT)
                .addModule(StatBoostModule.multiplyBase(ToolStats.MINING_SPEED).eachLevel(1.5f))
                .addModule(StatBoostModule.multiplyBase(ToolStats.ATTACK_DAMAGE).eachLevel(1.5f))
                .addModule(StatBoostModule.multiplyBase(ToolStats.DRAW_SPEED).eachLevel(1.1f))
                .addModule(StatBoostModule.multiplyBase(ToolStats.ARMOR).eachLevel(1.2f))
                .addModule(StatBoostModule.multiplyBase(ToolStats.DURABILITY).eachLevel(1.2f));

        buildModifier(ThermalModifierIds.REDSTONE_FLUXED)
                .tooltipDisplay(BasicModifier.TooltipDisplay.ALWAYS)
                .levelDisplay(ModifierLevelDisplay.SINGLE_LEVEL)
                .addModule(ToolEnergyCapability.ENERGY_HANDLER)
                .addModule(new DurabilityBarColorModule(0xF31700));

        buildModifier(ThermalModifierIds.ENDSPLOSION)
                .addModule(ConditionalMeleeDamageModule
                        .builder()
                        .attacker(ThermalLivingEntityPredicate.IS_IN_END)
                        // if attacker is in the end, target should also be in the end, but we check for target too just in case
                        .target(ThermalLivingEntityPredicate.IS_IN_END)
                        .percent()
                        .eachLevel(1.3f)
                );

        buildModifier(ThermalModifierIds.WANDERER)
                .addModule(ConditionalStatModule.stat(ToolStats.ACCURACY).holder(ThermalLivingEntityPredicate.IS_FOREST).eachLevel(0.2f))
                .addModule(ConditionalStatModule.stat(ToolStats.DRAW_SPEED).holder(ThermalLivingEntityPredicate.IS_FOREST).eachLevel(0.2f))
                .addModule(ConditionalStatModule.stat(ToolStats.MINING_SPEED).holder(ThermalLivingEntityPredicate.IS_JUNGLE).eachLevel(1f))
                .addModule(ConditionalStatModule.stat(ToolStats.DURABILITY).holder(ThermalLivingEntityPredicate.IS_JUNGLE).percent().eachLevel(1.2f))
                .addModule(ConditionalStatModule.stat(ToolStats.ATTACK_DAMAGE).holder(ThermalLivingEntityPredicate.IS_BADLANDS).eachLevel(1f))
                .addModule(ConditionalStatModule.stat(ToolStats.ATTACK_SPEED).holder(ThermalLivingEntityPredicate.IS_BADLANDS).eachLevel(0.5f));

        buildModifier(ThermalModifierIds.FLUORESCENCE)
                .addModule(MobEffectModule.builder(MobEffects.GLOWING).time(RandomLevelingValue.perLevel(100, 20)).build());
        buildModifier(ThermalModifierIds.PRICKLY_GLOW)
                .addModule(THORNS)
                .addModule(MobEffectModule.builder(MobEffects.GLOWING).time(RandomLevelingValue.perLevel(100, 20)).build());
        buildModifier(ThermalModifierIds.SPECTRAL)
                .addModule(SHULKING)
                .addModule(new EffectImmunityModule(MobEffects.LEVITATION));

        buildModifier(ThermalModifierIds.CHILLED)
                .addModule(MobEffectModule.builder(CoreMobEffects.CHILLED.get()).time(RandomLevelingValue.perLevel(100, 20)).build());
        buildModifier(ThermalModifierIds.SHOCKED)
                .addModule(MobEffectModule.builder(CoreMobEffects.SHOCKED.get()).time(RandomLevelingValue.perLevel(100, 20)).build());
        buildModifier(ThermalModifierIds.SUNDERED)
                .addModule(MobEffectModule.builder(CoreMobEffects.SUNDERED.get()).time(RandomLevelingValue.perLevel(100, 20)).build());

    }

    @Override
    public String getName() {
        return "Thermal Modifier Provider";
    }
}
