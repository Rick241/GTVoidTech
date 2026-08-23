package ricky.ceu.gtvoidtech.api.util;

import net.minecraft.util.ResourceLocation;

import org.jetbrains.annotations.NotNull;

import ricky.ceu.gtvoidtech.GTVoidTech;

public final class GTVoidTechUtil {

    private GTVoidTechUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @NotNull
    public static ResourceLocation vtid(@NotNull String path) {
        return new ResourceLocation(GTVoidTech.MODID, path);
    }
}
