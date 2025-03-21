package mrthomas20121.thermalconstruct.datagen;

import cofh.lib.init.data.RecipeProviderCoFH;
import cofh.thermal.core.ThermalCore;
import cofh.thermal.core.init.registries.TCoreEntities;
import cofh.thermal.innovation.init.registries.TInoIDs;
import mrthomas20121.thermal_extra.init.ThermalExtraFluids;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import mrthomas20121.thermalconstruct.ThermalModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalConstructFluids;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.fluids.FluidType;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.mantle.recipe.data.ItemNameIngredient;
import slimeknights.mantle.recipe.helper.FluidOutput;
import slimeknights.mantle.recipe.ingredient.EntityIngredient;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.*;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.entitymelting.EntityMeltingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.function.Consumer;

public class ThermalRecipeProvider extends RecipeProviderCoFH implements IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public ThermalRecipeProvider(PackOutput output) {
        super(output, ThermalConstruct.MOD_ID);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // material folders
        String materialFolder = "materials/";

        String castFolder = "casting/";
        String smelteryFolder = "smeltery/";

        // modifier folders
        String upgradeFolder = "tools/modifiers/upgrade/";
        String abilityFolder = "tools/modifiers/ability/";
        String slotlessFolder = "tools/modifiers/slotless/";
        String upgradeSalvage = "tools/modifiers/salvage/upgrade/";
        String abilitySalvage = "tools/modifiers/salvage/ability/";
        String defenseFolder = "tools/modifiers/defense/";
        String defenseSalvage = "tools/modifiers/salvage/defense/";
        String compatFolder = "tools/modifiers/compat/";
        String compatSalvage = "tools/modifiers/salvage/compat/";
        String worktableFolder = "tools/modifiers/worktable/";

        extraCompat(smelteryFolder, consumer);

        thermalCast(consumer, smelteryFolder, new ResourceLocation("thermal:chiller_rod_cast"), FluidValues.INGOT*4);
        thermalCast(consumer, smelteryFolder, new ResourceLocation("thermal:chiller_ball_cast"), FluidValues.INGOT*4);
        thermalCast(consumer, smelteryFolder, new ResourceLocation("thermal:chiller_ingot_cast"), FluidValues.INGOT*4);

        metalMaterialRecipe(consumer, ThermalMaterialIds.ENDERIUM, materialFolder, "enderium", false);
        metalMaterialRecipe(consumer, ThermalMaterialIds.LUMIUM, materialFolder, "lumium", false);
        metalMaterialRecipe(consumer, ThermalMaterialIds.SIGNALUM, materialFolder, "signalum", false);
        materialRecipe(consumer, ThermalMaterialIds.BASALZ, Ingredient.of(ThermalCore.ITEMS.get("basalz_rod")), 1, 1, materialFolder+"basalz/rod");
        materialRecipe(consumer, ThermalMaterialIds.BASALZ, Ingredient.of(ThermalCore.ITEMS.get("basalz_powder")), 1, 2, materialFolder+"basalz/powder");
        materialRecipe(consumer, ThermalMaterialIds.BLITZ, Ingredient.of(ThermalCore.ITEMS.get("blitz_rod")), 1, 1, materialFolder+"blitz/rod");
        materialRecipe(consumer, ThermalMaterialIds.BLITZ, Ingredient.of(ThermalCore.ITEMS.get("blitz_powder")), 1, 2, materialFolder+"blitz/powder");
        materialRecipe(consumer, ThermalMaterialIds.BLIZZ, Ingredient.of(ThermalCore.ITEMS.get("blizz_rod")), 1, 1, materialFolder+"blizz/rod");
        materialRecipe(consumer, ThermalMaterialIds.BLIZZ, Ingredient.of(ThermalCore.ITEMS.get("blizz_powder")), 1, 2, materialFolder+"blizz/powder");

        MeltingRecipeBuilder.melting(Ingredient.of(ThermalCore.ITEMS.get("basalz_rod")), ThermalConstructFluids.basalz_blood, 100, 10).save(consumer, location("smeltery/basalz_rod"));
        MeltingRecipeBuilder.melting(Ingredient.of(ThermalCore.ITEMS.get("blitz_rod")), ThermalConstructFluids.blitz_blood, 100, 10).save(consumer, location("smeltery/blitz_rod"));
        MeltingRecipeBuilder.melting(Ingredient.of(ThermalCore.ITEMS.get("blizz_rod")), ThermalConstructFluids.blizz_blood, 100, 10).save(consumer, location("smeltery/blizz_rod"));
        castingWithCast(consumer, ThermalConstructFluids.basalz_blood, 100, TinkerSmeltery.rodCast, ThermalCore.ITEMS.get("basalz_rod"), castFolder+"basaltz");
        castingWithCast(consumer, ThermalConstructFluids.blitz_blood, 100, TinkerSmeltery.rodCast, ThermalCore.ITEMS.get("blitz_rod"), castFolder+"blitz");
        castingWithCast(consumer, ThermalConstructFluids.blizz_blood, 100, TinkerSmeltery.rodCast, ThermalCore.ITEMS.get("blizz_rod"), castFolder+"blizz");
        EntityMeltingRecipeBuilder
                .melting(EntityIngredient.of(TCoreEntities.BASALZ.get()), ThermalConstructFluids.basalz_blood.result(FluidType.BUCKET_VOLUME / 50), 2)
                .save(consumer, location("smeltery/entity_melting/basalz"));
        EntityMeltingRecipeBuilder
                .melting(EntityIngredient.of(TCoreEntities.BLITZ.get()), ThermalConstructFluids.blitz_blood.result(FluidType.BUCKET_VOLUME / 50), 2)
                .save(consumer, location("smeltery/entity_melting/blitz"));
        EntityMeltingRecipeBuilder
                .melting(EntityIngredient.of(TCoreEntities.BLIZZ.get()), ThermalConstructFluids.blizz_blood.result(FluidType.BUCKET_VOLUME / 50), 2)
                .save(consumer, location("smeltery/entity_melting/blizz"));

        materialMeltingCasting(consumer, ThermalMaterialIds.ENDERIUM, TinkerFluids.moltenEnderium, smelteryFolder);
        materialMeltingCasting(consumer, ThermalMaterialIds.LUMIUM, TinkerFluids.moltenLumium, smelteryFolder);
        materialMeltingCasting(consumer, ThermalMaterialIds.SIGNALUM, TinkerFluids.moltenSignalum, smelteryFolder);
        materialMeltingCasting(consumer, ThermalMaterialIds.BASALZ, ThermalConstructFluids.basalz_blood, smelteryFolder);
        materialMeltingCasting(consumer, ThermalMaterialIds.BLITZ, ThermalConstructFluids.blitz_blood, smelteryFolder);
        materialMeltingCasting(consumer, ThermalMaterialIds.BLIZZ, ThermalConstructFluids.blizz_blood, smelteryFolder);

        ModifierRecipeBuilder.modifier(ThermalModifierIds.FLUXED)
                .setTools(TinkerTags.Items.DURABILITY)
                .addInput(ThermalCore.ITEMS.get(TInoIDs.ID_FLUX_CAPACITOR))
                .setMaxLevel(1)
                .setSlots(SlotType.UPGRADE, 1)
                .saveSalvage(consumer, prefix(ThermalModifierIds.FLUXED, upgradeSalvage))
                .save(consumer, prefix(ThermalModifierIds.FLUXED, upgradeFolder));

        ModifierRecipeBuilder.modifier(ThermalModifierIds.INTEGRAL)
                .setTools(TinkerTags.Items.BONUS_SLOTS)
                .addInput(ThermalCore.ITEMS.get("upgrade_augment_3"))
                .setMaxLevel(1)
                .save(withCondition(consumer, new NotCondition(new ModLoadedCondition("thermal_extra"))), prefix(ThermalModifierIds.INTEGRAL, upgradeFolder));

        ModifierRecipeBuilder.modifier(ThermalModifierIds.INTEGRAL)
                .setTools(TinkerTags.Items.BONUS_SLOTS)
                .addInput(ThermalExtraItems.ABYSSAL_INTEGRAL_COMPONENT.get())
                .setMaxLevel(1)
                .save(withCondition(consumer, new ModLoadedCondition("thermal_extra")), prefix(merge(ThermalModifierIds.INTEGRAL, "_extra"), upgradeFolder));
    }
    
    public void extraCompat(String smelteryFolder, Consumer<FinishedRecipe> consumer) {
        baseMetalMelting(consumer, smelteryFolder, "soul_infused");
        baseMetalMelting(consumer, smelteryFolder, "twinite");
        baseMetalMelting(consumer, smelteryFolder, "shellite");
        baseMetalMelting(consumer, smelteryFolder, "dragonsteel");
        baseMetalMelting(consumer, smelteryFolder, "abyssal");

        thermalCast(withCondition(consumer, new ModLoadedCondition("thermal_extra")), smelteryFolder, new ResourceLocation("thermal_extra:chiller_plate_cast"), FluidValues.INGOT*5);
    }

    protected void thermalCast(Consumer<FinishedRecipe> consumer, String folder, ResourceLocation castName, int output) {
        MeltingRecipeBuilder.melting(ItemNameIngredient.from(castName),
                FluidOutput.fromFluid(TinkerFluids.moltenBronze.get(), output),
                TinkerFluids.moltenBronze.getType().getTemperature(), 15)
                .save(consumer, new ResourceLocation(ThermalConstruct.MOD_ID, folder+castName.getPath()));
    }

    protected SmelteryRecipeBuilder smelteryBuilder(Consumer<FinishedRecipe> consumer, String folder, Fluid fluid, String materialName) {
        return SmelteryRecipeBuilder.fluid(consumer, location(materialName), fluid).meltingFolder(folder);
    }

    protected void baseMetalMelting(Consumer<FinishedRecipe> consumer, String folder, String materialName) {
        Fluid fluid = ThermalExtraFluids.FLUIDS.get(materialName);

        baseMetalMelting(consumer, fluid, materialName, false, folder, true);
    }

    private void baseMetalMelting(Consumer<FinishedRecipe> consumer, Fluid fluid, String name, boolean hasOre, String folder, boolean isOptional, IByproduct... byproducts) {
        SmelteryRecipeBuilder builder = SmelteryRecipeBuilder.fluid(consumer, location(name), fluid).meltingFolder(folder).optional(isOptional);
        if (hasOre) {
            builder.ore(byproducts);
        }
        builder.metal().dust().plate();
    }

    public ResourceLocation merge(ResourceLocation loc, String toAdd) {
        return new ResourceLocation(loc.getNamespace(), loc.getPath()+toAdd);
    }

    @Override
    public String getModId() {
        return this.modid;
    }
}
