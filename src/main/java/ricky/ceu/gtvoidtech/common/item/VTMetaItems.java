package ricky.ceu.gtvoidtech.common.item;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import net.minecraft.util.ResourceLocation;
import ricky.ceu.gtvoidtech.api.GTApi;
import ricky.ceu.gtvoidtech.api.util.GTVoidTechUtil;

public class VTMetaItems extends StandardMetaItem {

        // Статические поля для доступа к предметам
        public static MetaItem<?>.MetaValueItem VOID_CORE;

    public VTMetaItems() {
            super();
            setCreativeTab(GTApi.TAB_VT);
        }
        @Override
        public ResourceLocation createItemModelPath (MetaItem < ? >.MetaValueItem metaValueItem, String postfix){
            return GTVoidTechUtil.vtid(this.formatModelPath(metaValueItem) + postfix);
        }


        public static void init () {
            VTMetaItems item = new VTMetaItems();
            item.setRegistryName("vt_meta-item");
        }

        @Override
        public void registerSubItems () {
            // Создаём предметы
            VOID_CORE = addItem(0, "void_core");
        }
    }
