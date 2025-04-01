package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstructMaterialIds;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

public class ThermalMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Override
    public String getName() {
        return "Thermal Material Sprite Provider";
    }

    @Override
    protected void addAllMaterials() {

        buildMaterial(ThermalConstructMaterialIds.BASALZ)
                .meleeHarvest().armor().shieldCore()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF10121A).addARGB(102, 0xFF10121A).addARGB(140, 0xFF262835).addARGB(178, 0xFF352E31).addARGB(216, 0xFF32353A).addARGB(255, 0xFF42474C).build());

        buildMaterial(ThermalConstructMaterialIds.BLITZ)
                .meleeHarvest().armor().shieldCore()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF99C7D7).addARGB(102, 0xFFB4DCE8).addARGB(140, 0xFFC3E3EE).addARGB(178, 0xFFD0EDF4).addARGB(216, 0xFFDEF7FA).addARGB(255, 0xFFECFEFC).build());

        buildMaterial(ThermalConstructMaterialIds.BLIZZ)
                .meleeHarvest().armor().shieldCore()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0D6FD9).addARGB(102, 0xFF1D7CF1).addARGB(140, 0xFF25A1F8).addARGB(178, 0xFF37B7FE).addARGB(216, 0xFF53D8FF).addARGB(255, 0xFFE3F6F3).build());

        buildMaterial(ThermalConstructMaterialIds.ENDERIUM)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF011224).addARGB(102, 0xFF0A3057).addARGB(140, 0xFF0C5E7C).addARGB(178, 0xFF1D7E8C).addARGB(216, 0xFF4BCFCD).addARGB(255, 0xFF76F0E5).build());

        buildMaterial(ThermalConstructMaterialIds.LUMIUM)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFFB6611C).addARGB(102, 0xFFBE6F27).addARGB(140, 0xFFD3933A).addARGB(178, 0xFFE2BC5D).addARGB(216, 0xFFFFF1AA).addARGB(255, 0xFFFFFCE3).build());

        buildMaterial(ThermalConstructMaterialIds.SIGNALUM)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF8C0003).addARGB(102, 0xFFA40F00).addARGB(140, 0xFFEF3706).addARGB(178, 0xFFFB6114).addARGB(216, 0xFFFF9543).addARGB(255, 0xFFFFC787).build());

        buildMaterial(ThermalConstructMaterialIds.ABYSSAL)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF172A1F).addARGB(102, 0XFF37523D).addARGB(140, 0XFF516E4F).addARGB(178, 0XFF688961).addARGB(216, 0XFF8DB37C).addARGB(255, 0XFFB8E49D).build());

        buildMaterial(ThermalConstructMaterialIds.DRAGONSTEEL)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF212252).addARGB(102, 0XFF4852A6).addARGB(140, 0XFF5766BE).addARGB(178, 0XFF6083C5).addARGB(216, 0XFF729EDB).addARGB(255, 0XFF89C0FA).build());

        buildMaterial(ThermalConstructMaterialIds.SHELLITE)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF46154C).addARGB(102, 0XFF6D2B7F).addARGB(140, 0XFF813491).addARGB(178, 0XFF9649AF).addARGB(216, 0XFFA65FCC).addARGB(255, 0XFFC294E8).build());

        buildMaterial(ThermalConstructMaterialIds.TWINITE)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFFB11F4F).addARGB(102, 0XFFE44F76).addARGB(140, 0XFFEC6F86).addARGB(178, 0XFFFA93B6).addARGB(216, 0XFFFFD1E5).addARGB(255, 0XFFFFF4F5).build());

        buildMaterial(ThermalConstructMaterialIds.SOUL_INFUSED)
                .meleeHarvest().armor()
                .fallbacks("elemental").ranged()
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF5B2A25).addARGB(102, 0XFF894B3C).addARGB(140, 0XFFA2624E).addARGB(178, 0XFFB7785A).addARGB(216, 0XFFDB9E70).addARGB(255, 0XFFFFD68E).build());
    }
}
