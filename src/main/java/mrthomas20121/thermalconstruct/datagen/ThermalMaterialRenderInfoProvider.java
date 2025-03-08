package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class ThermalMaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider {

    public ThermalMaterialRenderInfoProvider(PackOutput packOutput, @Nullable AbstractMaterialSpriteProvider materialSprites, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, materialSprites, existingFileHelper);
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(ThermalMaterialIds.ENDERIUM).color(0x4BCFCD).fallbacks("elemental");
        buildRenderInfo(ThermalMaterialIds.LUMIUM).color(0xFFF1AA).fallbacks("elemental");
        buildRenderInfo(ThermalMaterialIds.SIGNALUM).color(0xFF9543).fallbacks("elemental");
        buildRenderInfo(ThermalMaterialIds.BASALZ).color(0x32353A).fallbacks("elemental");
        buildRenderInfo(ThermalMaterialIds.BLITZ).color(0xDEF7FA).fallbacks("elemental");
        buildRenderInfo(ThermalMaterialIds.BLIZZ).color(0x37B7FE).fallbacks("elemental");
    }

    @Override
    public String getName() {
        return "Thermal Material Render Info";
    }
}
