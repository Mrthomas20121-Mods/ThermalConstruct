package mrthomas20121.thermalconstruct.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

public class ThermalDatagen {

    public static void init(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();

        TinkerPartSpriteProvider partSpriteProvider = new TinkerPartSpriteProvider();
        ThermalMaterialSpriteProvider materialSpriteProvider = new ThermalMaterialSpriteProvider();
        ThermalMaterialDataProvider materialDataProvider = new ThermalMaterialDataProvider(packOutput);

        generator.addProvider(event.includeServer(), new ThermalRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), materialDataProvider);
        generator.addProvider(event.includeServer(), new ThermalMaterialTraitProvider(packOutput, materialDataProvider));
        generator.addProvider(event.includeServer(), new ThermalMaterialStatsProvider(packOutput, materialDataProvider));

        generator.addProvider(event.includeClient(), new MaterialPartTextureGenerator(packOutput, existingFileHelper, partSpriteProvider, materialSpriteProvider));
        generator.addProvider(event.includeClient(), new ThermalMaterialRenderInfoProvider(packOutput, materialSpriteProvider, existingFileHelper));
        generator.addProvider(event.includeClient(), new ThermalLangProvider(packOutput));

    }
}
