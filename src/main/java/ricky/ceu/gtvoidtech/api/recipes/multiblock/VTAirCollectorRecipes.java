package ricky.ceu.gtvoidtech.api.recipes.multiblock;

import gregtech.api.unification.material.Materials;

import ricky.ceu.gtvoidtech.api.recipes.VTRecipeMaps;
import ricky.ceu.gtvoidtech.api.unification.materials.VTMatBaseElementMaterials;

public class VTAirCollectorRecipes {

    public static void init() {
        VTRecipeMaps.AIR_COLLECTOR_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Air.getFluid(8000))
                .fluidOutputs(VTMatBaseElementMaterials.HiPressureAir.getFluid(1000))
                .duration(200)
                .EUt(512)
                .buildAndRegister();

        VTRecipeMaps.AIR_COLLECTOR_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Argon.getFluid(8000))
                .fluidOutputs(VTMatBaseElementMaterials.HiPressureArgon.getFluid(1000))
                .duration(200)
                .EUt(2048)
                .buildAndRegister();
    }
}
