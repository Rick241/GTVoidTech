package ricky.ceu.gtvoidtech.recipes.mixer;

import static gregtech.api.GTValues.EV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

import gregtech.api.recipes.RecipeMaps;

import ricky.ceu.gtvoidtech.api.unification.materials.VTMaterials;

public class mixerRecipes {

    private mixerRecipes() {};

    public static void init() {
        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, Carbon, 1)                     // 1
                .input(dust, Copper, 1)                     // 2
                .input(dust, Molybdenum, 1)                 // 3
                .input(dust, NiobiumTitanium, 1)            // 4
                .input(dust, Vanadium, 1)                   // 5
                .input(dust, Chrome, 1)                     // 6
                .output(dust, VTMaterials.HSLA_Steel, 9)
                .EUt(VA[EV]).duration(20);
    }
}
