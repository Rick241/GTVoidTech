package ricky.ceu.gtvoidtech.recipes;

import ricky.ceu.gtvoidtech.recipes.alloyblast.alloyBlastRecipes;
import ricky.ceu.gtvoidtech.recipes.mixer.mixerRecipes;

public class VTRecipes {

    public static void init() {
        mixerRecipes.init();
        alloyBlastRecipes.init();
    }
}
