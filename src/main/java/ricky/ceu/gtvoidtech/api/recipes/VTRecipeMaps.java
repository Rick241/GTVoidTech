package ricky.ceu.gtvoidtech.api.recipes;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import ricky.ceu.gtvoidtech.api.recipes.properties.HIF_PressureProperty;
import ricky.ceu.gtvoidtech.api.recipes.properties.HIF_TemperatureProperty;

public class VTRecipeMaps {

    public static RecipeMap<SimpleRecipeBuilder> BEDROCK_CRUSHER_RECIPES;
    public static RecipeMap<SimpleRecipeBuilder> AIR_COLLECTOR_RECIPES;

    //public static RecipeMap<SimpleRecipeBuilder> HOT_ISOSTATIC_FURNACE;


    public static void init() {
        BEDROCK_CRUSHER_RECIPES = new RecipeMap<>(
                "bedrock_crusher",
                1, 1, 1,
                0, new SimpleRecipeBuilder(),
                false);

        AIR_COLLECTOR_RECIPES = new RecipeMap<>(
                "air_collector",
                1, 0,
                1,
                1, new SimpleRecipeBuilder(),
                false);

        //HOT_ISOSTATIC_FURNACE = new RecipeMap<>(
                //"hot_isostatic_furnace",
               // 1, 2,
               // 1, 2,
               // new SimpleRecipeBuilder(),
               // true
       // );
    }

    public static final RecipeMap<SimpleRecipeBuilder> HOT_ISOSTATIC_FURNACE =
            new RecipeMap<>("hot_isostatic_furnace", 1, 1, 1, 1, new SimpleRecipeBuilder(), false);

    static {
        HOT_ISOSTATIC_FURNACE.setProperty(TemperatureProperty.getInstance(),0)
                             .setProperty(PressureProperty.getInstance(), 0);
    }

}
