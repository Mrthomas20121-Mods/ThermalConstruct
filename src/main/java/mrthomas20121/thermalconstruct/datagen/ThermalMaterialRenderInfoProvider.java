package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstructMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class ThermalMaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider {

    public ThermalMaterialRenderInfoProvider(PackOutput packOutput, @Nullable AbstractMaterialSpriteProvider materialSprites, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, materialSprites, existingFileHelper);
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(ThermalConstructMaterialIds.ENDERIUM).color(0x4BCFCD).fallbacks("elemental");
        buildRenderInfo(ThermalConstructMaterialIds.LUMIUM).color(0xFFF1AA).fallbacks("elemental");
        buildRenderInfo(ThermalConstructMaterialIds.SIGNALUM).color(0xFF9543).fallbacks("elemental");
        buildRenderInfo(ThermalConstructMaterialIds.SOUL_INFUSED).color(0XDB9E70).fallbacks("elemental");
        buildRenderInfo(ThermalConstructMaterialIds.TWINITE).color(0XFFD1E5).fallbacks("elemental");
        buildRenderInfo(ThermalConstructMaterialIds.SHELLITE).color(0XA65FCC).fallbacks("elemental");
        buildRenderInfo(ThermalConstructMaterialIds.DRAGONSTEEL).color(0X729EDB).fallbacks("elemental");
        buildRenderInfo(ThermalConstructMaterialIds.ABYSSAL).color(0X8DB37C).fallbacks("elemental");

        buildRenderInfo(ThermalConstructMaterialIds.BASALZ).color(0x32353A).fallbacks("elemental");
        buildRenderInfo(ThermalConstructMaterialIds.BLITZ).color(0xDEF7FA).fallbacks("elemental");
        buildRenderInfo(ThermalConstructMaterialIds.BLIZZ).color(0x37B7FE).fallbacks("elemental");
    }

    @Override
    public String getName() {
        return "Thermal Material Render Info";
    }
}
