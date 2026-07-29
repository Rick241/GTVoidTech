package ricky.ceu.gtvoidtech.common;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.Mod;



import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ricky.ceu.gtvoidtech.api.util.GTVoidTechValues;
import ricky.ceu.gtvoidtech.common.item.VTMetaItems;
import ricky.ceu.gtvoidtech.core.api.GTVoidTechValue;

@Mod.EventBusSubscriber(modid = GTVoidTechValue.MODID)


public abstract class CommonProxy {

    public static final VTMetaItems VTMETA_ITEMS = new VTMetaItems();
    // ⚠️ ВАЖНО: установить имя ДО регистрации
    static {
        VTMETA_ITEMS.setRegistryName(GTVoidTechValues.MODID, "vt_meta_items");
    }
    // Метод для этапа пред-инициализации
    public void preInit(FMLPreInitializationEvent e) {
        // общий код, выполняемый до инициализации
    }

    // Метод для этапа инициализации (тот, который вы вызываете)
    public void init(FMLInitializationEvent e) {
        // общий код, выполняемый на этапе инициализации
    }

    // Метод для этапа пост-инициализации
    public void postInit(FMLPostInitializationEvent event) {
        // общий код, выполняемый после инициализации
    }


    protected void PreInit() {
    }

    public void preInit(){
        VTMetaItems.init();
    }

    // Регистрация предметов
    @Mod.EventBusSubscriber(modid = GTVoidTechValues.MODID)
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(VTMETA_ITEMS);
        }


    }
}

