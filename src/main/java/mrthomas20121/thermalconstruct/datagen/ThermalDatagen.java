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

        boolean server = event.includeServer();
        generator.addProvider(server, new ThermalRecipeProvider(packOutput));
        generator.addProvider(server, materialDataProvider);
        generator.addProvider(server, new ThermalMaterialTraitProvider(packOutput, materialDataProvider));
        generator.addProvider(server, new ThermalMaterialStatsProvider(packOutput, materialDataProvider));
        generator.addProvider(server, new ThermalModifierProvider(packOutput));

        boolean client = event.includeClient();
        generator.addProvider(client, new ThermalColorProvider(packOutput));
        generator.addProvider(client, new MaterialPartTextureGenerator(packOutput, existingFileHelper, partSpriteProvider, materialSpriteProvider));
        generator.addProvider(client, new ThermalMaterialRenderInfoProvider(packOutput, materialSpriteProvider, existingFileHelper));
        generator.addProvider(client, new ThermalLangProvider(packOutput));
        generator.addProvider(client, new ThermalFluidTextureProvider(packOutput));
    }
}
