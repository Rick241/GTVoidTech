package ricky.ceu.gtvoidtech.common;

import net.minecraftforge.common.config.Config;

import ricky.ceu.gtvoidtech.GTVoidTech;

@Config.LangKey(GTVoidTech.MODID + ".config." + GTVoidTech.MODID)
@Config(modid = GTVoidTech.MODID,
        name = GTVoidTech.MODID + "/" + GTVoidTech.MODID,
        category = "GTVoidTech")
public class VTConfigHolder {

    @Config.Name("General Options")
    @Config.RequiresMcRestart
    public static final General general = new General();

    @Config.Name("Start IDs")
    @Config.Comment("Start IDs for meta items, machines and materials. Change if there are conflicts with other mods.")
    @Config.RequiresMcRestart
    public static final StartIDs startIDs = new StartIDs();

    public static class General {

    }

    public static class StartIDs {

        @Config.Comment({ "Start ID for custom meta items",
                "Default: 25000" })
        @Config.RangeInt(min = 0)
        public int metaItemCustomId = 25000;

        @Config.Comment({ "Start ID for custom meta machines (MTE)",
                "Default: 25500" })
        @Config.RangeInt(min = 0)
        public int metaMachineId = 25500;

        @Config.Comment({ "Start ID for custom materials",
                "Default: 9000" })
        @Config.RangeInt(min = 0)
        public int customMaterialId = 9000;
    }
}
