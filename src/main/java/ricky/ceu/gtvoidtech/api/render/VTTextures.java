package ricky.ceu.gtvoidtech.api.render;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;

@SideOnly(Side.CLIENT)
public final class VTTextures {

    // Базовая текстура корпуса — используется как ICubeRenderer
    public static SimpleOverlayRenderer BEDROCK_CRUSHER_CASING;
    public static SimpleOverlayRenderer PRESSURE_BOOSTER_CASING;
    public static SimpleOverlayRenderer HOT_ISOSTATIC_FURNACE_CASING;

    // Фронтальный оверлей (показывает состояние машины)
    public static OrientedOverlayRenderer BEDROCK_CRUSHER_OVERLAY;
    public static OrientedOverlayRenderer PRESSURE_BOOSTER_OVERLAY;
    public static OrientedOverlayRenderer HOT_ISOSTATIC_FURNACE_OVERLAY;

    // Если вам нужны другие текстуры, добавляйте их аналогично

    public static void preInit() {
        // Если потребуется дополнительная инициализация, она здесь

        BEDROCK_CRUSHER_CASING = new SimpleOverlayRenderer("casings/large_multiblock/bedrock_crusher");
        BEDROCK_CRUSHER_OVERLAY = new OrientedOverlayRenderer("multiblock/bedrock_crusher");

        PRESSURE_BOOSTER_CASING = new SimpleOverlayRenderer("casings/large_multiblock/maraging_steel");
        PRESSURE_BOOSTER_OVERLAY = new OrientedOverlayRenderer("multiblock/large_macerator");

        HOT_ISOSTATIC_FURNACE_CASING = new SimpleOverlayRenderer("casings/large_multiblock/alumina_isolating_casing");
        HOT_ISOSTATIC_FURNACE_OVERLAY = new OrientedOverlayRenderer("multiblock/large_macerator");
    }
}
