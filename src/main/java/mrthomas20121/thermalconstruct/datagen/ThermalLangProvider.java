package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import mrthomas20121.thermalconstruct.ThermalModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalConstructFluids;
import mrthomas20121.thermalconstruct.init.ThermalConstructItems;
import mrthomas20121.thermalconstruct.init.ThermalConstructModifiers;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class ThermalLangProvider extends LanguageProvider {

    public ThermalLangProvider(PackOutput output) {
        super(output, ThermalConstruct.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        for(ThermalConstructItems.ThermalCast cast: ThermalConstructItems.ThermalCast.VALUES) {
            add(ThermalConstructItems.CASTS.get(cast), cast.getTranslatedName());
        }

        fluid(ThermalConstructFluids.basalz_blood, "Basalz Blood");
        fluid(ThermalConstructFluids.blitz_blood, "Blitz Blood");
        fluid(ThermalConstructFluids.blizz_blood, "Blizz Blood");

        add("itemGroup.thermal_construct", "Thermal Construct tab");

        addMaterial(ThermalMaterialIds.ENDERIUM, "Enderium");
        addMaterialFlavor(ThermalMaterialIds.ENDERIUM, "Resonate at any frequency.");

        addMaterial(ThermalMaterialIds.LUMIUM, "Lumium");
        addMaterialFlavor(ThermalMaterialIds.LUMIUM, "A Brick of solid sunshine.");
        addMaterial(ThermalMaterialIds.SIGNALUM, "Signalum");
        addMaterialFlavor(ThermalMaterialIds.SIGNALUM, "Conduct better than silver.");
        addMaterial(ThermalMaterialIds.BASALZ, "Basalz");
        addMaterial(ThermalMaterialIds.BLITZ, "Blitz");
        addMaterial(ThermalMaterialIds.BLIZZ, "Blizz");

        addModifier(ThermalModifierIds.ENDSPLOSION, "End'splosion");
        addModifierFlavor(ThermalModifierIds.ENDSPLOSION, "Explosion of Flavors");
        addModifierDesc(ThermalModifierIds.ENDSPLOSION, "Deal more damage to mobs in the end.");

        addModifier(ThermalModifierIds.SPECTRAL, "Spectral");
        addModifierFlavor(ThermalModifierIds.SPECTRAL, "Chorus Fruit taste so good");
        addModifierDesc(ThermalModifierIds.SPECTRAL, "Immune to levitation but you teleport when you take damage.");

        addModifier(ThermalModifierIds.FLUORESCENCE, "Fluorescence");
        addModifierFlavor(ThermalModifierIds.FLUORESCENCE, "Glow in the dark");
        addModifierDesc(ThermalModifierIds.FLUORESCENCE, "Target is glowing when hit.");

        addModifier(ThermalModifierIds.PRICKLY_GLOW, "Prickly Glow");
        addModifierFlavor(ThermalModifierIds.PRICKLY_GLOW, "Holy Light!");
        addModifierDesc(ThermalModifierIds.PRICKLY_GLOW, "Attacker is glowing and take damage when hit.");

        addModifier(ThermalModifierIds.SCIENTISTIC, "Scientistic");
        addModifierFlavor(ThermalModifierIds.SCIENTISTIC, "You know, i'm something of a scientist myself");
        addModifierDesc(ThermalModifierIds.SCIENTISTIC, "Boost Mining/Draw Speed if you have a potion effect.");

        addModifier(ThermalModifierIds.FREEZING_PROTECTION, "Freezing Protection");
        addModifierFlavor(ThermalModifierIds.FREEZING_PROTECTION, "It's cold down there");
        addModifierDesc(ThermalModifierIds.FREEZING_PROTECTION, "Protect against freezing damage types.");

        addModifier(ThermalConstructModifiers.SHULKING.getId(), "Shulking");
        addModifierFlavor(ThermalConstructModifiers.SHULKING.getId(), "I feel like an enderman now");
        addModifierDesc(ThermalConstructModifiers.SHULKING.getId(), "Teleport when you take damage.");

        addModifier(ThermalModifierIds.CHILLED, "Chilled");
        addModifierFlavor(ThermalModifierIds.CHILLED, "Netflix and Chill");
        addModifierDesc(ThermalModifierIds.CHILLED, "Apply the chilled effect.");

        addModifier(ThermalModifierIds.SHOCKED, "Shocked");
        addModifierFlavor(ThermalModifierIds.SHOCKED, "*Shocked Pikachu face*");
        addModifierDesc(ThermalModifierIds.SHOCKED, "Apply the Shocked effect.");

        addModifier(ThermalModifierIds.SUNDERED, "Sundered");
        addModifierFlavor(ThermalModifierIds.SUNDERED, "*split the red sea in half*");
        addModifierDesc(ThermalModifierIds.SUNDERED, "Apply the sundered effect.");

        addModifier(ThermalModifierIds.INTEGRAL, "Integral");
        addModifierFlavor(ThermalModifierIds.INTEGRAL, "Dad's favorite math stuff");
        addModifierDesc(ThermalModifierIds.INTEGRAL, "Boost your tool/armor/bow stats.");

        addModifier(ThermalModifierIds.FLUXED, "Fluxed");
        addModifierFlavor(ThermalModifierIds.FLUXED, "Powered by RF");
        addModifierDesc(ThermalModifierIds.FLUXED, "Add an energy bar to your tool.");

        addModifier(ThermalConstructModifiers.REDSTONE_FLUX_MODIFIER.getId(), "RF");
        addModifierFlavor(ThermalConstructModifiers.REDSTONE_FLUX_MODIFIER.getId(), "Powered by RF");
        addModifierDesc(ThermalConstructModifiers.REDSTONE_FLUX_MODIFIER.getId(), "Allow your tools to accept RF.");
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
}
