package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.init.ThermalConstructItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.concurrent.CompletableFuture;

public class ThermalConstructItemTagsProvider extends ItemTagsProvider {

    public ThermalConstructItemTagsProvider(PackOutput p_275204_, CompletableFuture<HolderLookup.Provider> p_275194_, CompletableFuture<TagLookup<Block>> p_275634_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275204_, p_275194_, p_275634_, ThermalConstruct.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for(ThermalConstructItems.ThermalCast cast: ThermalConstructItems.ThermalCast.VALUES) {
            tag(cast.getTag()).add(ThermalConstructItems.CASTS.get(cast));
            tag(TinkerTags.Items.CASTS).add(ThermalConstructItems.CASTS.get(cast));
        }

        tag(TinkerTags.Items.ANVIL_METAL)
                .addOptional(new ResourceLocation("thermal_extra:soul_infused_block"))
                .addOptional(new ResourceLocation("thermal_extra:twinite_block"))
                .addOptional(new ResourceLocation("thermal_extra:shellite_block"))
                .addOptional(new ResourceLocation("thermal_extra:dragonsteel_block"))
                .addOptional(new ResourceLocation("thermal_extra:abyssal_block"));
    }
}
