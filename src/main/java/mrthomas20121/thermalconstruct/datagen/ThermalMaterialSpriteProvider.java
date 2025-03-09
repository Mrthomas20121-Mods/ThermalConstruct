package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class ThermalMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Override
    public String getName() {
        return "Thermal Material Sprite Provider";
    }

    @Override
    protected void addAllMaterials() {

        buildMaterial(ThermalMaterialIds.BASALZ)
                .meleeHarvest().armor().shieldCore()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF10121A).addARGB(102, 0xFF10121A).addARGB(140, 0xFF262835).addARGB(178, 0xFF352E31).addARGB(216, 0xFF32353A).addARGB(255, 0xFF42474C).build());

        buildMaterial(ThermalMaterialIds.BLITZ)
                .meleeHarvest().armor().shieldCore()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF99C7D7).addARGB(102, 0xFFB4DCE8).addARGB(140, 0xFFC3E3EE).addARGB(178, 0xFFD0EDF4).addARGB(216, 0xFFDEF7FA).addARGB(255, 0xFFECFEFC).build());

        buildMaterial(ThermalMaterialIds.BLIZZ)
                .meleeHarvest().armor().shieldCore()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0D6FD9).addARGB(102, 0xFF1D7CF1).addARGB(140, 0xFF25A1F8).addARGB(178, 0xFF37B7FE).addARGB(216, 0xFF53D8FF).addARGB(255, 0xFFE3F6F3).build());

        buildMaterial(ThermalMaterialIds.ENDERIUM)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF011224).addARGB(102, 0xFF0A3057).addARGB(140, 0xFF0C5E7C).addARGB(178, 0xFF1D7E8C).addARGB(216, 0xFF4BCFCD).addARGB(255, 0xFF76F0E5).build());

        buildMaterial(ThermalMaterialIds.LUMIUM)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFFB6611C).addARGB(102, 0xFFBE6F27).addARGB(140, 0xFFD3933A).addARGB(178, 0xFFE2BC5D).addARGB(216, 0xFFFFF1AA).addARGB(255, 0xFFFFFCE3).build());

        buildMaterial(ThermalMaterialIds.SIGNALUM)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF8C0003).addARGB(102, 0xFFA40F00).addARGB(140, 0xFFEF3706).addARGB(178, 0xFFFB6114).addARGB(216, 0xFFFF9543).addARGB(255, 0xFFFFC787).build());
    }
}
