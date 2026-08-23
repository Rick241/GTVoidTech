package ricky.ceu.gtvoidtech.api.recipes.multiblock;

import gregtech.api.unification.material.Materials;

import ricky.ceu.gtvoidtech.api.recipes.VTRecipeMaps;
import ricky.ceu.gtvoidtech.common.item.VTMetaItems;

public class VTBedrockCrusherRecipes {

    public static void init() {
        VTRecipeMaps.BEDROCK_CRUSHER_RECIPES.recipeBuilder()
                .fluidInputs(Materials.DrillingFluid.getFluid(100000))
                .output(VTMetaItems.BEDROCK_DEBRIS, 1)
                .duration(200)
                .EUt(131072)
                .buildAndRegister();
    }
}
