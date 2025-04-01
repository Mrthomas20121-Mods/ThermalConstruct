package mrthomas20121.thermalconstruct.datagen;

import cofh.core.init.CoreMobEffects;
import mrthomas20121.thermalconstruct.ThermalConstructModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalConstructModifiers;
import mrthomas20121.thermalconstruct.util.ThermalLivingEntityPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffects;
import slimeknights.mantle.data.predicate.damage.DamageSourcePredicate;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.RandomLevelingValue;
import slimeknights.tconstruct.library.modifiers.modules.armor.EffectImmunityModule;
import slimeknights.tconstruct.library.modifiers.modules.armor.ProtectionModule;
import slimeknights.tconstruct.library.modifiers.modules.behavior.ConditionalStatModule;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierSlotModule;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierTraitModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.MobEffectModule;
import slimeknights.tconstruct.library.modifiers.modules.technical.ArmorStatModule;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.capability.TinkerDataKeys;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class ThermalModifierProvider extends AbstractModifierProvider {

    public static ModifierTraitModule THORNS = new ModifierTraitModule(TinkerModifiers.thorns.getId(), 1, true);
    public static ModifierTraitModule ENDER_RETREAT = new ModifierTraitModule(ThermalConstructModifiers.CALLBACK.getId(), 1, true);

    public ThermalModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {

        // basalz bone
        //buildModifier(ThermalModifierIds.HARDROCK)
        //        .addModule(ConditionalMiningSpeedModule.builder().blocks(BlockPredicate.tag(Tags.Blocks.OBSIDIAN)).eachLevel(1.1f));

        buildModifier(ThermalConstructModifierIds.SIPHONING)
                .addModule(StatBoostModule.add(ToolStats.ATTACK_DAMAGE).eachLevel(-1.5f))
                .addModule(StatBoostModule.multiplyAll(ToolStats.DURABILITY).flat(0.8f))
                .addModule(StatBoostModule.add(ToolStats.MINING_SPEED).eachLevel(-1.5f))
                .addModule(new ModifierSlotModule(SlotType.ABILITY))
                .addModule(new ModifierSlotModule(SlotType.UPGRADE));

        // blizz armor
        buildModifier(ThermalConstructModifierIds.FREEZING_PROTECTION)
                .addModule(ProtectionModule.builder().source(DamageSourcePredicate.tag(DamageTypeTags.IS_FREEZING)).eachLevel(2f));

        buildModifier(ThermalConstructModifierIds.SUBTERRANEAN)
                .addModule(ConditionalMeleeDamageModule.builder().attacker(LivingEntityPredicate.UNDERWATER).target(LivingEntityPredicate.UNDERWATER).eachLevel(2f));

        buildModifier(ThermalConstructModifierIds.RESONANCE)
                .addModule(ProtectionModule.builder()
                        .attacker(ThermalLivingEntityPredicate.IS_WARDEN).eachLevel(1.25f));

        buildModifier(ThermalConstructModifierIds.GHOSTLY)
                .addModule(ArmorStatModule.builder(TinkerDataKeys.GOOD_EFFECT_DURATION)
                        .heldTag(TinkerTags.Items.HELD_ARMOR)
                        .tooltipStyle(ArmorStatModule.TooltipStyle.PERCENT).eachLevel(0.25f))
                .addModule(ArmorStatModule.builder(TinkerDataKeys.BAD_EFFECT_DURATION)
                        .heldTag(TinkerTags.Items.HELD_ARMOR)
                        .tooltipStyle(ArmorStatModule.TooltipStyle.PERCENT).eachLevel(0.25f));

        buildModifier(ThermalConstructModifierIds.TOUGH_SHELL)
                .addModule(StatBoostModule.add(ToolStats.ARMOR_TOUGHNESS).eachLevel(1f));

        buildModifier(ThermalConstructModifierIds.INTEGRAL)
                .addModule(StatBoostModule.multiplyBase(ToolStats.MINING_SPEED).eachLevel(1.5f))
                .addModule(StatBoostModule.multiplyBase(ToolStats.ATTACK_DAMAGE).eachLevel(1.5f))
                .addModule(StatBoostModule.multiplyBase(ToolStats.DRAW_SPEED).eachLevel(1.1f))
                .addModule(StatBoostModule.multiplyBase(ToolStats.ARMOR).eachLevel(1.2f))
                .addModule(StatBoostModule.multiplyBase(ToolStats.DURABILITY).eachLevel(1.2f));

        buildModifier(ThermalConstructModifierIds.BUSHWHACK)
                .addModule(ConditionalMeleeDamageModule
                        .builder()
                        .attacker(ThermalLivingEntityPredicate.IS_IN_END)
                        // if the attacker is in the end, the target should also be in the end, but we check for target too just in case
                        .target(ThermalLivingEntityPredicate.IS_IN_END)
                        .percent()
                        .eachLevel(1.3f)
                );

        buildModifier(ThermalConstructModifierIds.ACCUSTOMED)
                .addModule(ConditionalStatModule.stat(ToolStats.MINING_SPEED).holder(ThermalLivingEntityPredicate.HAS_POTION_EFFECT).eachLevel(2f))
                .addModule(ConditionalStatModule.stat(ToolStats.DRAW_SPEED).holder(ThermalLivingEntityPredicate.HAS_POTION_EFFECT).eachLevel(0.2f));

        buildModifier(ThermalConstructModifierIds.FLUORESCENCE)
                .addModule(MobEffectModule.builder(MobEffects.GLOWING).time(RandomLevelingValue.perLevel(100, 20)).build());
        buildModifier(ThermalConstructModifierIds.PRICKLY_GLOW)
                .addModule(THORNS)
                .addModule(MobEffectModule.builder(MobEffects.GLOWING).time(RandomLevelingValue.perLevel(100, 20)).build());
        buildModifier(ThermalConstructModifierIds.SPECTRAL)
                .addModule(ENDER_RETREAT)
                .addModule(new EffectImmunityModule(MobEffects.LEVITATION));

        buildModifier(ThermalConstructModifierIds.ENERGIZED)
                .addModule(MobEffectModule.builder(CoreMobEffects.SUPERCHARGE.get()).time(RandomLevelingValue.perLevel(80, 20)).build());

        buildModifier(ThermalConstructModifierIds.CHILLED)
                .addModule(MobEffectModule.builder(CoreMobEffects.CHILLED.get()).time(RandomLevelingValue.perLevel(100, 20)).build());
        buildModifier(ThermalConstructModifierIds.SHOCKED)
                .addModule(MobEffectModule.builder(CoreMobEffects.SHOCKED.get()).time(RandomLevelingValue.perLevel(100, 20)).build());
        buildModifier(ThermalConstructModifierIds.SUNDERED)
                .addModule(MobEffectModule.builder(CoreMobEffects.SUNDERED.get()).time(RandomLevelingValue.perLevel(100, 20)).build());

    }

    @Override
    public String getName() {
        return "Thermal Modifier Provider";
    }
}
