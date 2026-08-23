package ricky.ceu.gtvoidtech.api.recipes.multiblock;

import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import org.jetbrains.annotations.NotNull;
import ricky.ceu.gtvoidtech.api.recipes.VTRecipeMaps;

import static gregtech.api.GTValues.*;

public class VTHotIsostaticFurnaceRecipes<R extends RecipeBuilder<R>> extends RecipeMap<R> {

    public VTHotIsostaticFurnaceRecipes(@NotNull String unlocalizedName, int maxInputs, boolean modifyItemInputs, int maxOutputs, boolean modifyItemOutputs, int maxFluidInputs, boolean modifyFluidInputs, int maxFluidOutputs, boolean modifyFluidOutputs, @NotNull R defaultRecipeBuilder, boolean isHidden) {
        super(unlocalizedName, maxInputs, modifyItemInputs, maxOutputs, modifyItemOutputs, maxFluidInputs, modifyFluidInputs, maxFluidOutputs, modifyFluidOutputs, defaultRecipeBuilder, isHidden);
    }

    public static void init() {
        VTRecipeMaps.HOT_ISOSTATIC_FURNACE.recipeBuilder()
                .input(OrePrefix.dust, Materials.Iron, 4)
                .output(OrePrefix.ingot, Materials.Steel, 4)
                .duration(200)
                .EUt(VA[EV])
                .buildAndRegister();


    }
}