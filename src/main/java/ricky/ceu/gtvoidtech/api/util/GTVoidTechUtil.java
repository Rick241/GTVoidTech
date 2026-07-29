package ricky.ceu.gtvoidtech.api.util;


import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import ricky.ceu.gtvoidtech.GTVoidTech;

public final class GTVoidTechUtil{



    @NotNull
    public static ResourceLocation vtid(@NotNull String path){
        return new ResourceLocation(GTVoidTech.MODID, path);
    }
}