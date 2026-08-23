package ricky.ceu.gtvoidtech.api.recipes.properties;

import gregtech.api.GTValues;
import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.jetbrains.annotations.NotNull;

public class HIF_TemperatureProperty extends RecipeProperty<Integer> {

    public static final String KEY = "temperature";
    private static HIF_TemperatureProperty INSTANCE;

    protected HIF_TemperatureProperty() {
        super(KEY, Integer.class);
    }

    public static HIF_TemperatureProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HIF_TemperatureProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(@NotNull Minecraft minecraft, int x, int y, int color, Object value) {
        int val = castValue(value);
        String text = I18n.format("gtvoidtech.recipe.hif_temperature", val); // или pressure
        minecraft.fontRenderer.drawString(text, x, y, color);
    }
}
