package mrthomas20121.thermalconstruct.datagen;

import cofh.lib.init.data.RecipeProviderCoFH;
import mrthomas20121.thermalconstruct.ThermalConstruct;
import mrthomas20121.thermalconstruct.ThermalMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;

import java.util.function.Consumer;

public class ThermalRecipeProvider extends RecipeProviderCoFH implements IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public ThermalRecipeProvider(PackOutput output) {
        super(output, ThermalConstruct.MOD_ID);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        String materialFolder = "materials/";

        metalMaterialRecipe(consumer, ThermalMaterialIds.ENDERIUM, materialFolder, "enderium", false);
        metalMaterialRecipe(consumer, ThermalMaterialIds.LUMIUM, materialFolder, "lumium", false);
        metalMaterialRecipe(consumer, ThermalMaterialIds.SIGNALUM, materialFolder, "signalum", false);

        materialMeltingCasting(consumer, ThermalMaterialIds.ENDERIUM, TinkerFluids.moltenEnderium, "smeltery/");
        materialMeltingCasting(consumer, ThermalMaterialIds.LUMIUM, TinkerFluids.moltenLumium, "smeltery/");
        materialMeltingCasting(consumer, ThermalMaterialIds.SIGNALUM, TinkerFluids.moltenSignalum, "smeltery/");
    }

    @Override
    public String getModId() {
        return this.modid;
    }
}
