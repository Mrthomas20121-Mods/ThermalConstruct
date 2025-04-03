package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import slimeknights.tconstruct.fluids.data.FluidBlockstateModelProvider;
import slimeknights.tconstruct.fluids.data.FluidBucketModelProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

import java.util.concurrent.CompletableFuture;

public class ThermalConstructDatagen {

    public static void init(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        TinkerPartSpriteProvider partSpriteProvider = new TinkerPartSpriteProvider();
        ThermalMaterialSpriteProvider materialSpriteProvider = new ThermalMaterialSpriteProvider();
        ThermalMaterialDataProvider materialDataProvider = new ThermalMaterialDataProvider(packOutput);

        boolean server = event.includeServer();
        ThermalBlockTagsProvider blockTagsProvider = new ThermalBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(server, blockTagsProvider);
        generator.addProvider(server, new ThermalItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(server, new ThermalFluidTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(server, new ThermalRecipeProvider(packOutput));
        generator.addProvider(server, materialDataProvider);
        generator.addProvider(server, new ThermalMaterialTraitProvider(packOutput, materialDataProvider));
        generator.addProvider(server, new ThermalMaterialStatsProvider(packOutput, materialDataProvider));
        generator.addProvider(server, new ThermalModifierProvider(packOutput));

        boolean client = event.includeClient();
        generator.addProvider(client, new ThermalItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(client, new ThermalColorProvider(packOutput));
        generator.addProvider(client, new MaterialPartTextureGenerator(packOutput, existingFileHelper, partSpriteProvider, materialSpriteProvider));
        generator.addProvider(client, new ThermalMaterialRenderInfoProvider(packOutput, materialSpriteProvider, existingFileHelper));
        generator.addProvider(client, new ThermalLangProvider(packOutput));
        generator.addProvider(client, new ThermalFluidTextureProvider(packOutput));
        generator.addProvider(client, new FluidBucketModelProvider(packOutput, ThermalConstruct.MOD_ID));
        generator.addProvider(client, new FluidBlockstateModelProvider(packOutput, ThermalConstruct.MOD_ID));
    }
}
