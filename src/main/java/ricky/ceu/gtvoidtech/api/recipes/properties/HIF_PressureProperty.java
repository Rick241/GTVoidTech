package ricky.ceu.gtvoidtech.api.recipes.properties;
import gregtech.api.GTValues;
import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.jetbrains.annotations.NotNull;

public class HIF_PressureProperty extends RecipeProperty<Integer> {

    public static final String KEY = "pressure";
    private static HIF_PressureProperty INSTANCE;

    protected HIF_PressureProperty() {
        super(KEY, Integer.class);
    }

    public static HIF_PressureProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HIF_PressureProperty();
        }
        return INSTANCE;
    }
    @Override
    public void drawInfo(@NotNull Minecraft minecraft, int x, int y, int color, Object value) {
        int val = castValue(value);
        String text = I18n.format("gtvoidtech.recipe.hif_pressure", val); // или pressure
        minecraft.fontRenderer.drawString(text, x, y, color);
    }
}
