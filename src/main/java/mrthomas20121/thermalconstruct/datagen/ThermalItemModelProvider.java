package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.init.ThermalConstructItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ThermalItemModelProvider extends ItemModelProvider {

    public ThermalItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ThermalConstruct.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        for(ThermalConstructItems.ThermalCast cast: ThermalConstructItems.ThermalCast.VALUES) {
            // name shouldn't be null but just in case
            ResourceLocation name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(ThermalConstructItems.CASTS.get(cast)));
            basicItem(name, "cast/" + cast.getName());
        }
    }

    public ItemModelBuilder basicItem(ResourceLocation item, String texture)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + texture));
    }
}
