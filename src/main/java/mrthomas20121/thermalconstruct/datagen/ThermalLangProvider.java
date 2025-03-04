package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class ThermalLangProvider extends LanguageProvider {

    public ThermalLangProvider(PackOutput output) {
        super(output, ThermalConstruct.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        addMaterial(ThermalMaterialIds.ENDERIUM, "Enderium");
        addMaterial(ThermalMaterialIds.LUMIUM, "Lumium");
        addMaterial(ThermalMaterialIds.SIGNALUM, "Signalum");
    }

    public void addMaterial(MaterialId material, String s) {
        add("material."+material.getNamespace()+"."+material.getPath(), s);
    }
    public void addMaterialFlavor(MaterialId material, String s) {
        add("material."+material.getNamespace()+"."+material.getPath()+".flavor", s);
    }

    public void addMaterialEncyclopedia(MaterialId material, String s) {
        add("material."+material.getNamespace()+"."+material.getPath()+".encyclopedia", s);
    }
}
