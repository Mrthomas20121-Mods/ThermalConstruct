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
        ThermalConstructMaterialSpriteProvider materialSpriteProvider = new ThermalConstructMaterialSpriteProvider();
        ThermalConstructMaterialDataProvider materialDataProvider = new ThermalConstructMaterialDataProvider(packOutput);

        boolean server = event.includeServer();
        ThermalConstructBlockTagsProvider blockTagsProvider = new ThermalConstructBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(server, blockTagsProvider);
        generator.addProvider(server, new ThermalConstructItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(server, new ThermalConstructFluidTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(server, new ThermalConstructRecipeProvider(packOutput));
        generator.addProvider(server, materialDataProvider);
        generator.addProvider(server, new ThermalConstructMaterialTraitProvider(packOutput, materialDataProvider));
        generator.addProvider(server, new ThermalConstructMaterialStatsProvider(packOutput, materialDataProvider));
        generator.addProvider(server, new ThermalConstructModifierProvider(packOutput));
        generator.addProvider(server, new ThermalConstructFluidEffectProvider(packOutput));

        boolean client = event.includeClient();
        generator.addProvider(client, new ThermalConstructItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(client, new ThermalConstructColorProvider(packOutput));
        generator.addProvider(client, new MaterialPartTextureGenerator(packOutput, existingFileHelper, partSpriteProvider, materialSpriteProvider));
        generator.addProvider(client, new ThermalConstructMaterialRenderInfoProvider(packOutput, materialSpriteProvider, existingFileHelper));
        generator.addProvider(client, new ThermalConstructLangProvider(packOutput));
        generator.addProvider(client, new ThermalConstructFluidTextureProvider(packOutput));
        generator.addProvider(client, new FluidBucketModelProvider(packOutput, ThermalConstruct.MOD_ID));
        generator.addProvider(client, new FluidBlockstateModelProvider(packOutput, ThermalConstruct.MOD_ID));
    }
}
