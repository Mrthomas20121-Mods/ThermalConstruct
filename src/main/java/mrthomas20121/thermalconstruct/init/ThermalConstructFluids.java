package mrthomas20121.thermalconstruct.init;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;

import static slimeknights.tconstruct.fluids.block.BurningLiquidBlock.createBurning;

public class ThermalConstructFluids {
    
    public static FluidDeferredRegister FLUIDS = new FluidDeferredRegister(ThermalConstruct.MOD_ID);

    public static final FlowingFluidObject<ForgeFlowingFluid> basalzBlood = FLUIDS.register("basalz_blood").type(hot("basalz_blood").temperature(1200).lightLevel(15).density(3500)).block(createBurning(MapColor.COLOR_GRAY, 15, 15, 5f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> blitzBlood = FLUIDS.register("blitz_blood").type(hot("blitz_blood").temperature(1200).lightLevel(15).density(3500)).block(createBurning(MapColor.QUARTZ, 15, 15, 5f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> blizzBlood = FLUIDS.register("blizz_blood").type(hot("blizz_blood").temperature(1200).lightLevel(15).density(3500)).block(createBurning(MapColor.COLOR_LIGHT_BLUE, 15, 15, 5f)).bucket().flowing();

    public static final FlowingFluidObject<ForgeFlowingFluid> moltenSoulInfused = FLUIDS.register("molten_soul_infused").type(hot("molten_soul_infused").temperature(1200).lightLevel(15)).block(createBurning(MapColor.COLOR_ORANGE, 15, 15, 2f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenTwinite = FLUIDS.register("molten_twinite").type(hot("molten_twinite").temperature(1200).lightLevel(15)).block(createBurning(MapColor.COLOR_PINK, 15, 15, 2f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenShellite = FLUIDS.register("molten_shellite").type(hot("molten_shellite").temperature(1500).lightLevel(15)).block(createBurning(MapColor.COLOR_PURPLE, 15, 15, 3f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenDragonsteel = FLUIDS.register("molten_dragonsteel").type(hot("molten_dragonsteel").temperature(1500).lightLevel(15)).block(createBurning(MapColor.COLOR_BLUE, 15, 15, 4f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenAbyssal = FLUIDS.register("molten_abyssal").type(hot("molten_abyssal").temperature(1500).lightLevel(15)).block(createBurning(MapColor.COLOR_GREEN, 15, 15, 4f)).bucket().flowing();

    /** Creates a builder for a hot with sounds and description */
    private static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
                .descriptionId(ThermalConstruct.makeDescriptionId("fluid", name))
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                // from forge lava type
                .motionScale(0.0023333333333333335D)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }
}
