package mrthomas20121.thermalconstruct.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ThermalConstructTags {

    public static TagKey<Item> GEARS = forge("gears");
    public static TagKey<Item> COINS = forge("coins");
    public static TagKey<Item> WIRES = forge("wires");

    public static TagKey<Item> forge(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("forge", name));
    }
}
