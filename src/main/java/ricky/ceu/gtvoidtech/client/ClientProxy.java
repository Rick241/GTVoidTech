package ricky.ceu.gtvoidtech.client;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import ricky.ceu.gtvoidtech.api.render.VTTextures;
import ricky.ceu.gtvoidtech.common.CommonProxy;
import ricky.ceu.gtvoidtech.common.block.VTMetaBlocks;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
        VTTextures.preInit();
        VTMetaBlocks.registerItemModels();
    }


    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        VTMetaBlocks.registerItemModels();
    }
}
