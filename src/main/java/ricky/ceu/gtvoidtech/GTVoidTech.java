package ricky.ceu.gtvoidtech;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


import ricky.ceu.gtvoidtech.api.util.GTVoidTechValues;
import ricky.ceu.gtvoidtech.common.CommonProxy;
import ricky.ceu.gtvoidtech.common.blocks.VTMetaBlocks;
import ricky.ceu.gtvoidtech.common.item.VTMetaItems;


@Mod(modid = GTVoidTechValues.MODID,
        name = GTVoidTechValues.MODNAME,
        version = GTVoidTechValues.VERSION,
        acceptedMinecraftVersions = "[1.12, 1.12.2]")

public class GTVoidTech {

    public static final String MODID = Tags.MODID;
    public static final String NAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;

    @SidedProxy(modId = GTVoidTechValues.MODID,
            clientSide = "ricky.ceu.gtvoidtech.client.ClientProxy",
            serverSide = "ricky.ceu.gtvoidtech.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static GTVoidTech instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        MinecraftForge.EVENT_BUS.register(this);
        VTMetaBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }


    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent e) {
        if (e.getModID().equals(Tags.MODID)) {
            ConfigManager.sync(Tags.MODID, Config.Type.INSTANCE);
        }
    }
}
