package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.concurrent.CompletableFuture;

public class ThermalBlockTagsProvider extends BlockTagsProvider {

    public ThermalBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ThermalConstruct.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(TinkerTags.Blocks.ANVIL_METAL)
                .addOptional(new ResourceLocation("thermal_extra:soul_infused_block"))
                .addOptional(new ResourceLocation("thermal_extra:twinite_block"))
                .addOptional(new ResourceLocation("thermal_extra:shellite_block"))
                .addOptional(new ResourceLocation("thermal_extra:dragonsteel_block"))
                .addOptional(new ResourceLocation("thermal_extra:abyssal_block"));
    }
}
