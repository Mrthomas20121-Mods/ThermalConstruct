package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.init.ThermalConstructFluids;
import net.minecraft.data.PackOutput;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FluidObject;

public class ThermalConstructFluidTextureProvider extends AbstractFluidTextureProvider {
    public ThermalConstructFluidTextureProvider(PackOutput packOutput) {
        super(packOutput, ThermalConstruct.MOD_ID);
    }

    @Override
    public void addTextures() {
        named(ThermalConstructFluids.basalzBlood, "molten/basalz");
        named(ThermalConstructFluids.blitzBlood, "molten/blitz");
        named(ThermalConstructFluids.blizzBlood, "molten/blizz");

        named(ThermalConstructFluids.moltenSoulInfused, "molten/soul_infused");
        named(ThermalConstructFluids.moltenTwinite, "molten/twinite");
        named(ThermalConstructFluids.moltenShellite, "molten/shellite");
        named(ThermalConstructFluids.moltenDragonsteel, "molten/dragonsteel");
        named(ThermalConstructFluids.moltenAbyssal, "molten/abyssal");
    }

    @Override
    public String getName() {
        return "Thermal Fluid Texture Provider";
    }

    /** Creates a texture using the given fixed name in the fluid folder */
    private FluidTexture.Builder named(FluidObject<?> fluid, String name) {
        return texture(fluid).textures(ThermalConstruct.getResource("fluid/"+name+"/"), false, false);
    }
}
