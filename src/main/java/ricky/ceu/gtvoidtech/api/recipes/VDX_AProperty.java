package ricky.ceu.gtvoidtech.api.recipes;

import java.util.Map;
import java.util.TreeMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

import org.apache.commons.lang3.Validate;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;

public class VDX_AProperty extends RecipeProperty<Integer> {

    public static final String KEY = "vda_tier";
    private static final TreeMap<Integer, String> registerCasingTiers = new TreeMap<>();

    private static VDX_AProperty INSTANCE;

    protected VDX_AProperty() {
        super(KEY, Integer.class);
    }

    public static VDX_AProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VDX_AProperty();
        }
        return INSTANCE;
    }

    private static String getCasingTier(Integer tier) {
        Map.Entry<Integer, String> mapEntry = registerCasingTiers.ceilingEntry(tier);

        if (mapEntry == null) {
            throw new IllegalArgumentException("oopz");
        }

        return String.format(" %s", mapEntry.getValue());
    }

    public static void registerCasingTier(int tier, String shortName) {
        Validate.notNull(shortName);
        registerCasingTiers.put(tier, shortName);
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtvoidtech.recipe.vda_casing_tier",
                TextFormattingUtil.formatLongToCompactString(castValue(value))) + getCasingTier(castValue(value)), x, y,
                color);
    }
}
