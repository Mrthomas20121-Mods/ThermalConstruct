package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalConstructMaterialIds;
import mrthomas20121.thermalconstruct.ThermalConstructModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalConstructFluids;
import mrthomas20121.thermalconstruct.init.ThermalConstructItems;
import mrthomas20121.thermalconstruct.init.ThermalConstructModifiers;
import mrthomas20121.thermalconstruct.item.MetalItem;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

import java.util.Locale;

public class ThermalConstructLangProvider extends LanguageProvider {

    public ThermalConstructLangProvider(PackOutput output) {
        super(output, ThermalConstruct.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        addMetalItem(ThermalConstructItems.AMETHYST_BRONZE);
        addMetalItem(ThermalConstructItems.COBALT);
        addMetalItem(ThermalConstructItems.CINDERSLIME);
        addMetalItem(ThermalConstructItems.HEPATIZON);
        addMetalItem(ThermalConstructItems.MANYULLYN);
        addMetalItem(ThermalConstructItems.QUEENS_SLIME);
        addMetalItem(ThermalConstructItems.SLIMESTEEL);

        for(ThermalConstructItems.ThermalCast cast: ThermalConstructItems.ThermalCast.VALUES) {
            add(ThermalConstructItems.CASTS.get(cast), cast.getTranslatedName() + " Cast");
        }

        fluid(ThermalConstructFluids.basalzBlood, "Basalz Blood");
        fluid(ThermalConstructFluids.blitzBlood, "Blitz Blood");
        fluid(ThermalConstructFluids.blizzBlood, "Blizz Blood");

        fluid(ThermalConstructFluids.moltenSoulInfused, "Molten Soul Infused");
        fluid(ThermalConstructFluids.moltenTwinite, "Molten Twinite");
        fluid(ThermalConstructFluids.moltenShellite, "Molten Shellite");
        fluid(ThermalConstructFluids.moltenDragonsteel, "Molten Dragonsteel");
        fluid(ThermalConstructFluids.moltenAbyssal, "Molten Abyssal");

        add("itemGroup.thermal_construct", "Thermal Construct tab");

        addMaterial(ThermalConstructMaterialIds.ENDERIUM, "Enderium");
        addMaterialFlavor(ThermalConstructMaterialIds.ENDERIUM, "Resonate at any frequency.");
        addMaterial(ThermalConstructMaterialIds.LUMIUM, "Lumium");
        addMaterialFlavor(ThermalConstructMaterialIds.LUMIUM, "A Brick of solid sunshine.");
        addMaterial(ThermalConstructMaterialIds.SIGNALUM, "Signalum");
        addMaterialFlavor(ThermalConstructMaterialIds.SIGNALUM, "Conduct better than silver.");

        addMaterial(ThermalConstructMaterialIds.SOUL_INFUSED, "Soul Infused");
        addMaterialFlavor(ThermalConstructMaterialIds.SOUL_INFUSED, "Trap souls better than soul sand.");
        addMaterial(ThermalConstructMaterialIds.TWINITE, "Twinite");
        addMaterialFlavor(ThermalConstructMaterialIds.TWINITE, "Not as hard as obsidian.");
        addMaterial(ThermalConstructMaterialIds.SHELLITE, "Shellite");
        addMaterialFlavor(ThermalConstructMaterialIds.SHELLITE, "Soft like a shulker shell.");
        addMaterial(ThermalConstructMaterialIds.DRAGONSTEEL, "Dragonsteel");
        addMaterialFlavor(ThermalConstructMaterialIds.DRAGONSTEEL, "Killed a dragon to make this.");
        addMaterial(ThermalConstructMaterialIds.ABYSSAL, "Abyssal");
        addMaterialFlavor(ThermalConstructMaterialIds.ABYSSAL, "there echo in there.");

        addMaterial(ThermalConstructMaterialIds.BASALZ, "Basalz");
        addMaterial(ThermalConstructMaterialIds.BLITZ, "Blitz");
        addMaterial(ThermalConstructMaterialIds.BLIZZ, "Blizz");

        addModifier(ThermalConstructModifierIds.HARD_SLICE, "Hard Slice");
        addModifierFlavor(ThermalConstructModifierIds.HARD_SLICE, "Who want some minced enderman?");
        addModifierDesc(ThermalConstructModifierIds.HARD_SLICE, "Deal more damage to mobs in the end.");

        addModifier(ThermalConstructModifierIds.SPECTRAL, "Spectral");
        addModifierFlavor(ThermalConstructModifierIds.SPECTRAL, "Chorus Fruit taste so good");
        addModifierDesc(ThermalConstructModifierIds.SPECTRAL, "Immune to levitation but you teleport when you take damage.");

        addModifier(ThermalConstructModifierIds.LUMINESCENCE, "Luminescence");
        addModifierFlavor(ThermalConstructModifierIds.LUMINESCENCE, "Begone Darkness!");
        addModifierDesc(ThermalConstructModifierIds.LUMINESCENCE, "Target is glowing when hit.");

        addModifier(ThermalConstructModifierIds.ACCUSTOMED, "Accustomed");
        addModifierFlavor(ThermalConstructModifierIds.ACCUSTOMED, "Taste the wind");
        addModifierDesc(ThermalConstructModifierIds.ACCUSTOMED, "Boost Mining/Draw Speed if you have a potion effect.");

        addModifier(ThermalConstructModifierIds.FREEZING_PROTECTION, "Freezing Protection");
        addModifierFlavor(ThermalConstructModifierIds.FREEZING_PROTECTION, "It's cold down there");
        addModifierDesc(ThermalConstructModifierIds.FREEZING_PROTECTION, "Protect against freezing damage types.");

        addModifier(ThermalConstructModifiers.CALLBACK.getId(), "Callback");
        addModifierFlavor(ThermalConstructModifiers.CALLBACK.getId(), "I feel like an enderman now");
        addModifierDesc(ThermalConstructModifiers.CALLBACK.getId(), "Teleport when you take damage from entities.");

        addModifier(ThermalConstructModifierIds.SUBTERRANEAN, "Subterranean");
        addModifierFlavor(ThermalConstructModifierIds.SUBTERRANEAN, "Deep inside");
        addModifierDesc(ThermalConstructModifierIds.SUBTERRANEAN, "Increases damage underwater.");

        addModifier(ThermalConstructModifiers.BLISTERING.getId(), "Blistering");
        addModifierFlavor(ThermalConstructModifiers.BLISTERING.getId(), "Like a dragon");
        addModifierDesc(ThermalConstructModifiers.BLISTERING.getId(), "Your arrow spawn an area of effect when hit like a dragon with it's fireball.");

        addModifier(ThermalConstructModifierIds.ENERGIZED, "Energized");
        addModifierFlavor(ThermalConstructModifierIds.ENERGIZED, "Full of energy");
        addModifierDesc(ThermalConstructModifierIds.ENERGIZED, "Charge RF/FE items in your inventory when you take damage.");

        addModifier(ThermalConstructModifierIds.SIPHONING, "Siphoning");
        addModifierFlavor(ThermalConstructModifierIds.SIPHONING, "Where did my money go?");
        addModifierDesc(ThermalConstructModifierIds.SIPHONING, "Lose damage, mining speed and durability but gain 1 ability and 1 upgrade per part.");

        addModifier(ThermalConstructModifierIds.RESONANCE, "Resonance");
        addModifierFlavor(ThermalConstructModifierIds.RESONANCE, "Quiet please!");
        addModifierDesc(ThermalConstructModifierIds.RESONANCE, "Take less damage from the warden.");

        addModifier(ThermalConstructModifierIds.GHOSTLY, "Ghostly");
        addModifierFlavor(ThermalConstructModifierIds.GHOSTLY, "The Good, The Bad, The Ghostly");
        addModifierDesc(ThermalConstructModifierIds.GHOSTLY, "Increases the duration of good and bad effects.");

        addModifier(ThermalConstructModifierIds.TOUGH_SHELL, "Tough Shell");
        addModifierFlavor(ThermalConstructModifierIds.TOUGH_SHELL, "Bullet resistant!");
        addModifierDesc(ThermalConstructModifierIds.TOUGH_SHELL, "Increases armor toughness.");

        addModifier(ThermalConstructModifierIds.CHILLED, "Chilled");
        addModifierFlavor(ThermalConstructModifierIds.CHILLED, "Netflix and Chilled");
        addModifierDesc(ThermalConstructModifierIds.CHILLED, "Apply the chilled effect.");

        addModifier(ThermalConstructModifierIds.SHOCKED, "Shocked");
        addModifierFlavor(ThermalConstructModifierIds.SHOCKED, "You need Shock therapy in your life");
        addModifierDesc(ThermalConstructModifierIds.SHOCKED, "Apply the Shocked effect.");

        addModifier(ThermalConstructModifierIds.SUNDERED, "Sundered");
        addModifierFlavor(ThermalConstructModifierIds.SUNDERED, "*split the red sea in half*");
        addModifierDesc(ThermalConstructModifierIds.SUNDERED, "Apply the sundered effect.");

        addModifier(ThermalConstructModifierIds.INTEGRAL, "Integral");
        addModifierFlavor(ThermalConstructModifierIds.INTEGRAL, "Dad's favorite math stuff");
        addModifierDesc(ThermalConstructModifierIds.INTEGRAL, "Boost your tool/armor/bow stats.");

        addModifier(ThermalConstructModifiers.FLUX_SHIELD.getId(), "Flux Shield");
        addModifierFlavor(ThermalConstructModifiers.FLUX_SHIELD.getId(), "Powered by RF");
        addModifierDesc(ThermalConstructModifiers.FLUX_SHIELD.getId(), "Tool consumes RF instead of durability, until it runs out!.");

        addModifier(ThermalConstructModifiers.FLUX_CHARGE.getId(), "Flux Charge");
        addModifierFlavor(ThermalConstructModifiers.FLUX_CHARGE.getId(), "Powered by RF");
        addModifierDesc(ThermalConstructModifiers.FLUX_CHARGE.getId(), "Tool consumes RF instead of durability, until it runs out!.");
    }

    public void fluid(FluidObject<ForgeFlowingFluid> fluid, String name) {
        add("fluid."+ThermalConstruct.MOD_ID+"." + fluid.getId().getPath(), name);
        add(fluid.asItem(), name + " Bucket");
    }

    public void addModifier(ModifierId material, String s) {
        add("modifier."+material.getNamespace()+"."+material.getPath(), s);
    }

    public void addModifierFlavor(ModifierId material, String s) {
        add("modifier."+material.getNamespace()+"."+material.getPath()+".flavor", s);
    }

    public void addModifierDesc(ModifierId material, String s) {
        add("modifier."+material.getNamespace()+"."+material.getPath()+".description", s);
    }

    public void addMaterial(MaterialId material, String s) {
        add("material."+material.getNamespace()+"."+material.getPath(), s);
    }
    public void addMaterialFlavor(MaterialId material, String s) {
        add("material."+material.getNamespace()+"."+material.getPath()+".flavor", s);
    }

    public void addMaterialEncyclopedia(MaterialId material, String s) {
        add("material."+material.getNamespace()+"."+material.getPath()+".encyclopedia", s);
    }

    public void addMetalItem(MetalItem metalItem) {
        String name = metalItem.getTranslatedName();
        add(metalItem.getDust().asItem(),  name + " Dust");
        add(metalItem.getCoin().asItem(),  name + " Coin");
        add(metalItem.getPlate().asItem(),  name + " Plate");
        add(metalItem.getGear().asItem(),  name + " Gear");
    }
}
