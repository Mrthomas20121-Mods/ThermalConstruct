package mrthomas20121.thermalconstruct.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import slimeknights.tconstruct.TConstruct;

public class ThermalConstructTags {

    public static TagKey<Item> GEARS = forge("gears");
    public static TagKey<Item> COINS = forge("coins");
    public static TagKey<Item> WIRES = forge("wires");

    public static TagKey<Item> INGOT_CAST = mod(TConstruct.MOD_ID, "casts/multi_use/ingot");
    public static TagKey<Item> ROD_CAST = mod(TConstruct.MOD_ID, "casts/multi_use/rod");

    public static TagKey<Item> forge(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("forge", name));
    }

    public static TagKey<Item> mod(String mod, String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(mod, name));
    }
}
