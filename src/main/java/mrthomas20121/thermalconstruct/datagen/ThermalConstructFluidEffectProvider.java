package mrthomas20121.thermalconstruct.datagen;

import cofh.core.init.CoreMobEffects;
import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.init.ThermalConstructFluids;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Blocks;
import slimeknights.tconstruct.library.data.tinkering.AbstractFluidEffectProvider;
import slimeknights.tconstruct.library.modifiers.fluid.FluidMobEffect;
import slimeknights.tconstruct.library.modifiers.fluid.TimeAction;
import slimeknights.tconstruct.library.modifiers.fluid.block.PlaceBlockFluidEffect;
import slimeknights.tconstruct.library.modifiers.fluid.entity.PushEntityFluidEffect;
import slimeknights.tconstruct.library.modifiers.fluid.general.ScalingFluidEffect;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.shared.TinkerCommons;

public class ThermalConstructFluidEffectProvider extends AbstractFluidEffectProvider {

    public ThermalConstructFluidEffectProvider(PackOutput packOutput) {
        super(packOutput, ThermalConstruct.MOD_ID);
    }

    @Override
    protected void addFluids() {
        addFluid(ThermalConstructFluids.basalzBlood, 100)
                .magicDamage(1f)
                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.SUNDERED.get(), 20 * 5, 2), TimeAction.SET);

        addFluid(ThermalConstructFluids.blitzBlood, 100)
                .fireDamage(1f)
                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.SHOCKED.get(), 20 * 5, 2), TimeAction.SET);

        addFluid(ThermalConstructFluids.blizzBlood, 100)
                .coldDamage(1f)
                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.CHILLED.get(), 20 * 5, 2), TimeAction.SET);

        addFluid(ThermalConstructFluids.moltenSoulInfused, FluidValues.INGOT)
                .fireDamage(1f)
                .addBlockEffect(new PlaceBlockFluidEffect(Blocks.SOUL_FIRE));

        addFluid(ThermalConstructFluids.moltenTwinite, FluidValues.INGOT)
                .impactDamage(1f)
                .addBlockEffect(ScalingFluidEffect.blocks()
                        .effect(1, new PlaceBlockFluidEffect(Blocks.NETHERRACK))
                        .effect(4, new PlaceBlockFluidEffect(Blocks.NETHER_BRICKS))
                        .build());

        addFluid(ThermalConstructFluids.moltenShellite, FluidValues.INGOT)
                .fireDamage(1f)
                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.ENDERFERENCE.get(), 20 * 5, 2), TimeAction.SET);

        addFluid(ThermalConstructFluids.moltenDragonsteel, FluidValues.INGOT)
                .fireDamage(1f)
                .addEffect(FluidMobEffect.builder().effect(CoreMobEffects.SUPERCHARGE.get(), 20 * 5, 2), TimeAction.SET);

        addFluid(ThermalConstructFluids.moltenAbyssal, FluidValues.INGOT)
                .impactDamage(1f)
                .addEffect(FluidMobEffect.builder().effect(MobEffects.DARKNESS, 20 * 5, 2), TimeAction.SET);
    }

    @Override
    public String getName() {
        return "ThermalConstruct Fluid Effects";
    }
}
