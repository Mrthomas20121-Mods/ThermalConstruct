package mrthomas20121.thermalconstruct.datagen;

import cofh.lib.init.data.RecipeProviderCoFH;
import cofh.thermal.core.ThermalCore;
import cofh.thermal.core.init.registries.TCoreEntities;
import mrthomas20121.thermal_extra.init.ThermalExtraItems;
import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalConstructMaterialIds;
import mrthomas20121.thermalconstruct.ThermalConstructModifierIds;
import mrthomas20121.thermalconstruct.init.ThermalConstructFluids;
import mrthomas20121.thermalconstruct.init.ThermalConstructItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.fluids.FluidType;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.mantle.recipe.data.ItemNameIngredient;
import slimeknights.mantle.recipe.helper.FluidOutput;
import slimeknights.mantle.recipe.ingredient.EntityIngredient;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.SmelteryRecipeBuilder;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.entitymelting.EntityMeltingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.function.Consumer;

public class ThermalConstructRecipeProvider extends RecipeProviderCoFH implements IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public ThermalConstructRecipeProvider(PackOutput output) {
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

        extraCompat(smelteryFolder, materialFolder, withCondition(consumer, new ModLoadedCondition("thermal_extra")));

        thermalCast(consumer, smelteryFolder, new ResourceLocation("thermal:chiller_rod_cast"), FluidValues.INGOT*4);
        thermalCast(consumer, smelteryFolder, new ResourceLocation("thermal:chiller_ball_cast"), FluidValues.INGOT*4);
        thermalCast(consumer, smelteryFolder, new ResourceLocation("thermal:chiller_ingot_cast"), FluidValues.INGOT*4);

        for(ThermalConstructItems.ThermalCast thermalCast: ThermalConstructItems.ThermalCast.VALUES) {
            Item cast = ThermalConstructItems.CASTS.get(thermalCast);

            castRecipe(consumer, cast, thermalCast.getIngredient().get(), castFolder, thermalCast.getName());
        }

        metalMaterialRecipe(consumer, ThermalConstructMaterialIds.ENDERIUM, materialFolder, "enderium", false);
        metalMaterialRecipe(consumer, ThermalConstructMaterialIds.LUMIUM, materialFolder, "lumium", false);
        metalMaterialRecipe(consumer, ThermalConstructMaterialIds.SIGNALUM, materialFolder, "signalum", false);
        materialRecipe(consumer, ThermalConstructMaterialIds.BASALZ, Ingredient.of(ThermalCore.ITEMS.get("basalz_rod")), 1, 1, materialFolder+"basalz/rod");
        materialRecipe(consumer, ThermalConstructMaterialIds.BASALZ, Ingredient.of(ThermalCore.ITEMS.get("basalz_powder")), 1, 2, materialFolder+"basalz/powder");
        materialRecipe(consumer, ThermalConstructMaterialIds.BLITZ, Ingredient.of(ThermalCore.ITEMS.get("blitz_rod")), 1, 1, materialFolder+"blitz/rod");
        materialRecipe(consumer, ThermalConstructMaterialIds.BLITZ, Ingredient.of(ThermalCore.ITEMS.get("blitz_powder")), 1, 2, materialFolder+"blitz/powder");
        materialRecipe(consumer, ThermalConstructMaterialIds.BLIZZ, Ingredient.of(ThermalCore.ITEMS.get("blizz_rod")), 1, 1, materialFolder+"blizz/rod");
        materialRecipe(consumer, ThermalConstructMaterialIds.BLIZZ, Ingredient.of(ThermalCore.ITEMS.get("blizz_powder")), 1, 2, materialFolder+"blizz/powder");

        MeltingRecipeBuilder.melting(Ingredient.of(ThermalCore.ITEMS.get("basalz_rod")), ThermalConstructFluids.basalzBlood, 100, 10).save(consumer, location("smeltery/basalz_rod"));
        MeltingRecipeBuilder.melting(Ingredient.of(ThermalCore.ITEMS.get("blitz_rod")), ThermalConstructFluids.blitzBlood, 100, 10).save(consumer, location("smeltery/blitz_rod"));
        MeltingRecipeBuilder.melting(Ingredient.of(ThermalCore.ITEMS.get("blizz_rod")), ThermalConstructFluids.blizzBlood, 100, 10).save(consumer, location("smeltery/blizz_rod"));
        castingWithCast(consumer, ThermalConstructFluids.basalzBlood, 100, TinkerSmeltery.rodCast, ThermalCore.ITEMS.get("basalz_rod"), castFolder+"basaltz");
        castingWithCast(consumer, ThermalConstructFluids.blitzBlood, 100, TinkerSmeltery.rodCast, ThermalCore.ITEMS.get("blitz_rod"), castFolder+"blitz");
        castingWithCast(consumer, ThermalConstructFluids.blizzBlood, 100, TinkerSmeltery.rodCast, ThermalCore.ITEMS.get("blizz_rod"), castFolder+"blizz");
        EntityMeltingRecipeBuilder
                .melting(EntityIngredient.of(TCoreEntities.BASALZ.get()), ThermalConstructFluids.basalzBlood.result(FluidType.BUCKET_VOLUME / 50), 2)
                .save(consumer, location("smeltery/entity_melting/basalz"));
        EntityMeltingRecipeBuilder
                .melting(EntityIngredient.of(TCoreEntities.BLITZ.get()), ThermalConstructFluids.blitzBlood.result(FluidType.BUCKET_VOLUME / 50), 2)
                .save(consumer, location("smeltery/entity_melting/blitz"));
        EntityMeltingRecipeBuilder
                .melting(EntityIngredient.of(TCoreEntities.BLIZZ.get()), ThermalConstructFluids.blizzBlood.result(FluidType.BUCKET_VOLUME / 50), 2)
                .save(consumer, location("smeltery/entity_melting/blizz"));

        materialMeltingCasting(consumer, ThermalConstructMaterialIds.ENDERIUM, TinkerFluids.moltenEnderium, smelteryFolder);
        materialMeltingCasting(consumer, ThermalConstructMaterialIds.LUMIUM, TinkerFluids.moltenLumium, smelteryFolder);
        materialMeltingCasting(consumer, ThermalConstructMaterialIds.SIGNALUM, TinkerFluids.moltenSignalum, smelteryFolder);
        materialMeltingCasting(consumer, ThermalConstructMaterialIds.BASALZ, ThermalConstructFluids.basalzBlood, smelteryFolder);
        materialMeltingCasting(consumer, ThermalConstructMaterialIds.BLITZ, ThermalConstructFluids.blitzBlood, smelteryFolder);
        materialMeltingCasting(consumer, ThermalConstructMaterialIds.BLIZZ, ThermalConstructFluids.blizzBlood, smelteryFolder);

        ModifierRecipeBuilder.modifier(ThermalConstructModifierIds.INTEGRAL)
                .setTools(TinkerTags.Items.BONUS_SLOTS)
                .addInput(ThermalCore.ITEMS.get("upgrade_augment_3"))
                .setMaxLevel(1)
                .save(withCondition(consumer, new NotCondition(new ModLoadedCondition("thermal_extra"))), prefix(ThermalConstructModifierIds.INTEGRAL, upgradeFolder));

        ModifierRecipeBuilder.modifier(ThermalConstructModifierIds.INTEGRAL)
                .setTools(TinkerTags.Items.BONUS_SLOTS)
                .addInput(ThermalExtraItems.ABYSSAL_INTEGRAL_COMPONENT.get())
                .setMaxLevel(1)
                .save(withCondition(consumer, new ModLoadedCondition("thermal_extra")), prefix(merge(ThermalConstructModifierIds.INTEGRAL, "_extra"), upgradeFolder));
    }
    
    public void extraCompat(String smelteryFolder, String materialFolder, Consumer<FinishedRecipe> consumer) {
        metal(consumer, ThermalConstructFluids.moltenSoulInfused).metal().dust().plate().gear().coin().sheetmetal().rod();
        metal(consumer, ThermalConstructFluids.moltenTwinite).metal().dust().plate().gear().coin().sheetmetal().rod();
        metal(consumer, ThermalConstructFluids.moltenShellite).metal().dust().plate().gear().coin().sheetmetal().rod();
        metal(consumer, ThermalConstructFluids.moltenDragonsteel).metal().dust().plate().gear().coin().sheetmetal().rod();
        metal(consumer, ThermalConstructFluids.moltenAbyssal).metal().dust().plate().gear().coin().sheetmetal().rod();

        metalMaterialRecipe(consumer, ThermalConstructMaterialIds.SOUL_INFUSED, materialFolder, "soul_infused", true);
        metalMaterialRecipe(consumer, ThermalConstructMaterialIds.TWINITE, materialFolder, "twinite", true);
        metalMaterialRecipe(consumer, ThermalConstructMaterialIds.SHELLITE, materialFolder, "shellite", true);
        metalMaterialRecipe(consumer, ThermalConstructMaterialIds.DRAGONSTEEL, materialFolder, "dragonsteel", true);
        metalMaterialRecipe(consumer, ThermalConstructMaterialIds.ABYSSAL, materialFolder, "abyssal", true);

        materialMeltingCasting(consumer, ThermalConstructMaterialIds.SOUL_INFUSED, ThermalConstructFluids.moltenSoulInfused, smelteryFolder);
        materialMeltingCasting(consumer, ThermalConstructMaterialIds.TWINITE, ThermalConstructFluids.moltenTwinite, smelteryFolder);
        materialMeltingCasting(consumer, ThermalConstructMaterialIds.SHELLITE, ThermalConstructFluids.moltenShellite, smelteryFolder);
        materialMeltingCasting(consumer, ThermalConstructMaterialIds.DRAGONSTEEL, ThermalConstructFluids.moltenDragonsteel, smelteryFolder);
        materialMeltingCasting(consumer, ThermalConstructMaterialIds.ABYSSAL, ThermalConstructFluids.moltenAbyssal, smelteryFolder);

        thermalCast(consumer, smelteryFolder, new ResourceLocation("thermal_extra:chiller_plate_cast"), FluidValues.INGOT*5);
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

    public SmelteryRecipeBuilder metal(Consumer<FinishedRecipe> consumer, String name, TagKey<Fluid> fluid) {
        return SmelteryRecipeBuilder.fluid(consumer, location(name), fluid).castingFolder("smeltery/casting/metal").meltingFolder("smeltery/melting/metal");
    }

    /** Creates a smeltery builder for a metal fluid */
    public SmelteryRecipeBuilder metal(Consumer<FinishedRecipe> consumer, FluidObject<?> fluid) {
        return molten(consumer, fluid).castingFolder("smeltery/casting/metal").meltingFolder("smeltery/melting/metal");
    }

    public ResourceLocation merge(ResourceLocation loc, String toAdd) {
        return new ResourceLocation(loc.getNamespace(), loc.getPath()+toAdd);
    }

    public void castRecipe(Consumer<FinishedRecipe> consumer,  ItemLike cast, Ingredient input, String folder, String name) {
        ItemCastingRecipeBuilder.tableRecipe(cast)
                .setFluidAndTime(TinkerFluids.moltenBronze, FluidValues.INGOT*4)
                .setCast(input, true)
                .setSwitchSlots()
                .save(consumer, location(folder + "gold/" + name));
    }

    @Override
    public String getModId() {
        return this.modid;
    }
}
