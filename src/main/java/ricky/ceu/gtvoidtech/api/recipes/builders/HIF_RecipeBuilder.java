package ricky.ceu.gtvoidtech.api.recipes.builders;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import org.jetbrains.annotations.NotNull;
import ricky.ceu.gtvoidtech.api.recipes.properties.HIF_PressureProperty;
import ricky.ceu.gtvoidtech.api.recipes.properties.HIF_TemperatureProperty;

public class HIF_RecipeBuilder extends RecipeBuilder<HIF_RecipeBuilder> {

    public HIF_RecipeBuilder() {}

     public HIF_RecipeBuilder(Recipe recipe, RecipeMap<HIF_RecipeBuilder> recipeMap){
        super(recipe, recipeMap);
     }

    public HIF_RecipeBuilder(RecipeBuilder<HIF_RecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public HIF_RecipeBuilder copy(){
        return new HIF_RecipeBuilder(this);
     }

     public boolean applyProperty(@NotNull String key, Object value){
        switch (key){
            case HIF_TemperatureProperty.KEY -> {
                this.Temperature(((Number) value).intValue());
                return true;
            }
            case HIF_PressureProperty.KEY -> {
                this.Pressure(((Number) value).intValue());
                return true;
            }
        }
        return super.applyProperty(key, value);
     }

     public HIF_RecipeBuilder Temperature(int temperature){
        if(temperature <0){
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(HIF_TemperatureProperty.getInstance(), temperature);
        return this;
     }

    public HIF_RecipeBuilder Pressure(int pressure){
        if(pressure <0){
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(HIF_PressureProperty.getInstance(), pressure);
        return this;
    }
}
