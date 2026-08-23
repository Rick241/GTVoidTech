package ricky.ceu.gtvoidtech;

import gregtech.GTInternalTags;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ricky.ceu.gtvoidtech.common.CommonProxy;

@Mod(modid = GTVoidTech.MODID,
     name = GTVoidTech.NAME,
     version = GTVoidTech.VERSION,
     dependencies = GTInternalTags.DEP_VERSION_STRING)

public class GTVoidTech {

    public static final String MODID = Tags.MODID;
    public static final String NAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;

    @SidedProxy(modId = MODID,
            clientSide = "ricky.ceu.gtvoidtech.client.ClientProxy",
            serverSide = "ricky.ceu.gtvoidtech.common.CommonProxy")
    public static CommonProxy proxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);

        proxy.preInit();
    }


    }
