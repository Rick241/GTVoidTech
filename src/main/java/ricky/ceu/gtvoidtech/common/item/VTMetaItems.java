package ricky.ceu.gtvoidtech.common.item;

import gregtech.api.items.metaitem.MetaItem;

public class VTMetaItems {

    public static MetaItem<?>.MetaValueItem VOID_CORE;
    public static MetaItem<?>.MetaValueItem MACERATED_BEDROCK_DEBRIS;
    public static MetaItem<?>.MetaValueItem BEDROCK_DEBRIS;
    public static MetaItem<?>.MetaValueItem CARBID_TUNGSTEN_GRINDER;

    public static void init() {
        VTMetaItem item = new VTMetaItem();
        item.setRegistryName("vt_meta_item");
    }
}
