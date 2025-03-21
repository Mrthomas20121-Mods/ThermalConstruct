package mrthomas20121.thermalconstruct.init;

import cofh.thermal.core.ThermalCore;
import mrthomas20121.thermalconstruct.ThermalConstruct;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.registration.deferred.ItemDeferredRegister;
import slimeknights.mantle.registration.deferred.SynchronizedDeferredRegister;
import slimeknights.mantle.registration.object.EnumObject;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.tools.part.PartCastItem;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerToolParts;

import java.util.Locale;
import java.util.function.Supplier;

public class ThermalConstructItems {

    public static ItemDeferredRegister ITEMS = new ItemDeferredRegister(ThermalConstruct.MOD_ID);
    public static final SynchronizedDeferredRegister<CreativeModeTab> CREATIVE_TABS = SynchronizedDeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThermalConstruct.MOD_ID);

    public static EnumObject<ThermalCast, Item> CASTS = ITEMS.registerEnum("bronze_cast", ThermalCast.VALUES, cast -> cast.getItemInstance().get());

    public static final RegistryObject<CreativeModeTab> tabThermalConstruct = CREATIVE_TABS.register(
            "smeltery", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.thermal_construct"))
                    .icon(() -> new ItemStack(CASTS.get(ThermalCast.GEM)))
                    .displayItems(ThermalConstructItems::addTabItems)
                    .withTabsBefore(TinkerFluids.tabFluids.getId())
                    .build());

    private static final Item.Properties PROPS = new Item.Properties();

    public enum ThermalCast {
        GEM,
        GEAR,
        COIN,
        WIRE,
        PICK_HEAD(() -> new PartCastItem(PROPS, TinkerToolParts.pickHead), "Pick Head"),
        SMALL_AXE_HEAD(() -> new PartCastItem(PROPS, TinkerToolParts.smallAxeHead), "Small Axe Head"),
        SMALL_BLADE(() -> new PartCastItem(PROPS, TinkerToolParts.smallBlade), "Small Blade"),
        ADZE_HEAD(() -> new PartCastItem(PROPS, TinkerToolParts.adzeHead), "Adze Head"),
        HAMMER_HEAD(() -> new PartCastItem(PROPS, TinkerToolParts.hammerHead), "Hammer Head"),
        BROAD_BLADE(() -> new PartCastItem(PROPS, TinkerToolParts.broadBlade), "Broad Blade"),
        BROAD_AXE_HEAD(() -> new PartCastItem(PROPS, TinkerToolParts.broadAxeHead), "Broad Axe Head"),
        LARGE_PLATE(() -> new PartCastItem(PROPS, TinkerToolParts.largePlate), "Large Plate"),
        TOOL_BINDING(() -> new PartCastItem(PROPS, TinkerToolParts.toolBinding), "Tool Binding"),
        TOUGH_BINDING(() -> new PartCastItem(PROPS, TinkerToolParts.toughBinding), "Tough Binding"),
        TOOL_HANDLE(() -> new PartCastItem(PROPS, TinkerToolParts.toolHandle), "Tool Handle"),
        TOUGH_HANDLE(() -> new PartCastItem(PROPS, TinkerToolParts.toughHandle), "Tough Handle"),
        BOW_LIMB(() -> new PartCastItem(PROPS, TinkerToolParts.bowLimb), "Bow Limb"),
        BOW_GRIP(() -> new PartCastItem(PROPS, TinkerToolParts.bowGrip), "Bow Grip"),
        HELMET_PLATING(() -> new PartCastItem(PROPS, () -> TinkerToolParts.plating.get(ArmorItem.Type.HELMET)), "Helmet Plating"),
        CHESTPLATE_PLATING(() -> new PartCastItem(PROPS, () -> TinkerToolParts.plating.get(ArmorItem.Type.CHESTPLATE)), "Chestplate Plating"),
        LEGGINGS_PLATING(() -> new PartCastItem(PROPS, () -> TinkerToolParts.plating.get(ArmorItem.Type.LEGGINGS)), "Leggings Plating"),
        BOOTS_PLATING(() -> new PartCastItem(PROPS, () -> TinkerToolParts.plating.get(ArmorItem.Type.BOOTS)), "Boots Plating"),
        MAILLE(() -> new PartCastItem(PROPS, TinkerToolParts.maille), "Maille");

        // array of ThermalCast[] to avoid calling values(); every times
        public static final ThermalCast[] VALUES = ThermalCast.values();

        // this prevents us from calling name(); every times
        private final String cast_name = this.name().toLowerCase(Locale.ROOT);
        private final String translated_name;
        private final TagKey<Item> tag;
        private final Supplier<Item> itemSupplier;

        ThermalCast() {
            this(() -> new Item(new Item.Properties()), null);
        }

        ThermalCast(Supplier<Item> createItem, @Nullable String translated_name) {
            this.itemSupplier = createItem;
            this.tag = ItemTags.create(TConstruct.getResource("casts/multi_use/" + this.cast_name));
            this.translated_name = translated_name == null ? this.cast_name: translated_name;
        }

        public String getName() {
            return cast_name;
        }

        public String getTranslatedName() {
            return translated_name;
        }

        public Supplier<Item> getItemInstance() {
            return itemSupplier;
        }

        public TagKey<Item> getTag() {
            return tag;
        }
    }

    private static ResourceLocation modLoc(String name) {
        return new ResourceLocation(ThermalConstruct.MOD_ID, name);
    }

    private static void addTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
        output.accept(ThermalCore.ITEMS.get("chiller_ingot_cast"));
        output.accept(ThermalCore.ITEMS.get("chiller_ball_cast"));
        output.accept(ThermalCore.ITEMS.get("chiller_rod_cast"));
        for(ThermalConstructItems.ThermalCast cast: ThermalConstructItems.ThermalCast.VALUES) {
            output.accept(CASTS.get(cast));
        }
    }
}
