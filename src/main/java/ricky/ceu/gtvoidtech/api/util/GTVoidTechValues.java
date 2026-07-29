package ricky.ceu.gtvoidtech.api.util;


import net.minecraft.util.ResourceLocation;

import org.jetbrains.annotations.NotNull;

import ricky.ceu.gtvoidtech.Tags;

public class GTVoidTechValues {

    public static final String MODID = Tags.MODID;
    public static final String MODNAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;

    public static @NotNull ResourceLocation modId(String path) {
        return new ResourceLocation(MODID, path);
    }
}