package mrthomas20121.thermalconstruct.item;

import cofh.core.common.item.CoinItem;
import cofh.core.common.item.CountedItem;
import mrthomas20121.thermalconstruct.ThermalConstruct;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.apache.commons.lang3.StringUtils;
import slimeknights.mantle.registration.deferred.ItemDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;

public class MetalItem {

    private final String name;

    private final ItemObject<CoinItem> coin;

    private final ItemObject<Item> gear;

    private final ItemObject<CountedItem> plate;

    private final ItemObject<Item> dust;

    private final TagKey<Item> coinTag;
    private final TagKey<Item> gearTag;
    private final TagKey<Item> plateTag;
    private final TagKey<Item> dustTag;

    public MetalItem(String name, ItemDeferredRegister registry) {
        this.coin = registry.register(name + "_coin", () -> new CoinItem(new Item.Properties()));
        this.gear = registry.register(name + "_gear", () -> new Item(new Item.Properties()));
        this.plate = registry.register(name + "_plate", () -> new CountedItem(new Item.Properties()));
        this.dust = registry.register(name + "_dust", () -> new Item(new Item.Properties()));

        this.coinTag = ItemTags.create(new ResourceLocation("forge", "coins/" + name));
        this.gearTag = ItemTags.create(new ResourceLocation("forge", "gears/" + name));
        this.plateTag = ItemTags.create(new ResourceLocation("forge", "plates/" + name));
        this.dustTag = ItemTags.create(new ResourceLocation("forge", "dusts/" + name));

        this.name = name;
    }

    public ItemObject<CoinItem> getCoin() {
        return coin;
    }

    public ItemObject<Item> getGear() {
        return gear;
    }

    public ItemObject<CountedItem> getPlate() {
        return plate;
    }

    public ItemObject<Item> getDust() {
        return dust;
    }

    public TagKey<Item> getCoinTag() {
        return coinTag;
    }

    public TagKey<Item> getGearTag() {
        return gearTag;
    }

    public TagKey<Item> getPlateTag() {
        return plateTag;
    }

    public TagKey<Item> getDustTag() {
        return dustTag;
    }

    public String getName() {
        return name;
    }

    public String getTranslatedName() {
        return capitalize(this.getName());
    }

    private String capitalize(String input) {
        if(input.contains("_")) {
            String[] split = input.split("_");
            StringBuilder output = new StringBuilder();
            for(String s : split) {
                output.append(StringUtils.capitalize(s));
                output.append(" ");
            }
            return output.toString().trim();
        }
        return StringUtils.capitalize(input);
    }
}
