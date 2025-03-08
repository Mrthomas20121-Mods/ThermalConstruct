package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import mrthomas20121.thermalconstruct.ThermalModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalModifiers;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class ThermalLangProvider extends LanguageProvider {

    public ThermalLangProvider(PackOutput output) {
        super(output, ThermalConstruct.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

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

        addModifier(ThermalModifierIds.WANDERER, "Wanderer");
        addModifierFlavor(ThermalModifierIds.WANDERER, "I'm walking like an egyptian");
        addModifierDesc(ThermalModifierIds.WANDERER, """
                Get different bonus effect depending on which biomes you are in.
                forest => higher accuracy and draw speed.
                jungle => higher mining speed and durability.
                badlands => higher attack damage and attack speed.
                """);

        addModifier(ThermalModifiers.KINETIC_VELOCITY.getId(), "Kinetic Velocity");
        addModifierFlavor(ThermalModifiers.KINETIC_VELOCITY.getId(), "GOTTA GO FAST");
        addModifierDesc(ThermalModifiers.KINETIC_VELOCITY.getId(), "Get a movement speed boost when you take damage.");

        addModifier(ThermalModifiers.SHULKING.getId(), "Shulking");
        addModifierFlavor(ThermalModifiers.SHULKING.getId(), "I feel like an enderman now");
        addModifierDesc(ThermalModifiers.SHULKING.getId(), "Teleport when you take damage.");

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

        addModifier(ThermalModifierIds.REDSTONE_FLUXED, "Redstone Fluxed");
        addModifierFlavor(ThermalModifierIds.REDSTONE_FLUXED, "Powered by RF");
        addModifierDesc(ThermalModifierIds.REDSTONE_FLUXED, "Add an energy bar to your tool.");
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
