package mrthomas20121.thermalconstruct.datagen;

import cofh.lib.init.tags.ItemTagsCoFH;
import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.init.ThermalConstructItems;
import mrthomas20121.thermalconstruct.item.MetalItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
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

        tag(Tags.Items.BONES)
                .add(
                        ThermalConstructItems.BASALZ_BONE.get(),
                        ThermalConstructItems.BLITZ_BONE.get(),
                        ThermalConstructItems.BLIZZ_BONE.get()
                );

        metalTags(ThermalConstructItems.COBALT);
        metalTags(ThermalConstructItems.SLIMESTEEL);
        metalTags(ThermalConstructItems.AMETHYST_BRONZE);
        metalTags(ThermalConstructItems.CINDERSLIME);
        metalTags(ThermalConstructItems.HEPATIZON);
        metalTags(ThermalConstructItems.MANYULLYN);
        metalTags(ThermalConstructItems.QUEENS_SLIME);
    }

    protected void metalTags(MetalItem metalItem) {
        tag(ItemTagsCoFH.COINS).add(metalItem.getCoin().asItem());
        tag(ItemTagsCoFH.GEARS).add(metalItem.getGear().asItem());
        tag(ItemTagsCoFH.PLATES).add(metalItem.getPlate().asItem());
        tag(Tags.Items.DUSTS).add(metalItem.getDust().asItem());

        tag(metalItem.getDustTag()).add(metalItem.getDust().asItem());
        tag(metalItem.getCoinTag()).add(metalItem.getCoin().asItem());
        tag(metalItem.getGearTag()).add(metalItem.getGear().asItem());
        tag(metalItem.getPlateTag()).add(metalItem.getPlate().asItem());
    }
}
