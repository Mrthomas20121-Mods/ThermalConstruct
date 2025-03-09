package mrthomas20121.thermalconstruct.datagen;

import cofh.lib.init.data.RecipeProviderCoFH;
import cofh.thermal.core.ThermalCore;
import cofh.thermal.core.init.registries.TCoreEntities;
import cofh.thermal.core.init.registries.TCoreItems;
import cofh.thermal.innovation.init.registries.TInoIDs;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import mrthomas20121.thermalconstruct.ThermalModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalConstructFluids;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.fluids.FluidType;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.mantle.recipe.helper.FluidOutput;
import slimeknights.mantle.recipe.ingredient.EntityIngredient;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
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

        materialMeltingCasting(consumer, ThermalMaterialIds.ENDERIUM, TinkerFluids.moltenEnderium, "smeltery/");
        materialMeltingCasting(consumer, ThermalMaterialIds.LUMIUM, TinkerFluids.moltenLumium, "smeltery/");
        materialMeltingCasting(consumer, ThermalMaterialIds.SIGNALUM, TinkerFluids.moltenSignalum, "smeltery/");
        materialMeltingCasting(consumer, ThermalMaterialIds.BASALZ, ThermalConstructFluids.basalz_blood, "smeltery/");
        materialMeltingCasting(consumer, ThermalMaterialIds.BLITZ, ThermalConstructFluids.blitz_blood, "smeltery/");
        materialMeltingCasting(consumer, ThermalMaterialIds.BLIZZ, ThermalConstructFluids.blizz_blood, "smeltery/");

//        ModifierRecipeBuilder.modifier(ThermalModifierIds.REDSTONE_FLUXED)
//                .setTools(TinkerTags.Items.DURABILITY)
//                .addInput(ThermalCore.ITEMS.get(TInoIDs.ID_FLUX_CAPACITOR))
//                .setMaxLevel(1)
//                .setSlots(SlotType.ABILITY, 1)
//                .saveSalvage(consumer, prefix(ThermalModifierIds.REDSTONE_FLUXED, upgradeSalvage))
//                .save(consumer, prefix(ThermalModifierIds.REDSTONE_FLUXED, upgradeFolder));

        ModifierRecipeBuilder.modifier(ThermalModifierIds.INTEGRAL)
                .setTools(TinkerTags.Items.BONUS_SLOTS)
                .addInput(ThermalCore.ITEMS.get("upgrade_augment_3"))
                .setMaxLevel(1)
                .save(new ConditionalRecipeConsumer(consumer).addCondition(new NotCondition(new ModLoadedCondition("thermal_extra"))), prefix(ThermalModifierIds.INTEGRAL, upgradeFolder));

        ModifierRecipeBuilder.modifier(ThermalModifierIds.INTEGRAL)
                .setTools(TinkerTags.Items.BONUS_SLOTS)
                .addInput(ThermalExtraItems.ABYSSAL_INTEGRAL_COMPONENT.get())
                .setMaxLevel(1)
                .save(new ConditionalRecipeConsumer(consumer).addCondition(new ModLoadedCondition("thermal_extra")), prefix(merge(ThermalModifierIds.INTEGRAL, "_extra"), upgradeFolder));
    }

    public ResourceLocation merge(ResourceLocation loc, String toAdd) {
        return new ResourceLocation(loc.getNamespace(), loc.getPath()+toAdd);
    }

    @Override
    public String getModId() {
        return this.modid;
    }
}
