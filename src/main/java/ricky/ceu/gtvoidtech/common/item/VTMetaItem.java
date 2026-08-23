package ricky.ceu.gtvoidtech.common.item;

import static ricky.ceu.gtvoidtech.common.item.VTMetaItems.*;

import net.minecraft.util.ResourceLocation;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;

import ricky.ceu.gtvoidtech.api.GTApi;
import ricky.ceu.gtvoidtech.api.util.GTVoidTechUtil;
import ricky.ceu.gtvoidtech.common.VTConfigHolder;

public class VTMetaItem extends StandardMetaItem {

    public VTMetaItem() {
        super();
        setCreativeTab(GTApi.TAB_VT);
    }

    @Override
    public ResourceLocation createItemModelPath(MetaItem<?>.MetaValueItem metaValueItem, String postfix) {
        return GTVoidTechUtil.vtid(this.formatModelPath(metaValueItem) + postfix);
    }

    @Override
    public void registerSubItems() {
        VOID_CORE = addItem(VTConfigHolder.startIDs.metaItemCustomId++, "void_core");
        MACERATED_BEDROCK_DEBRIS = addItem(VTConfigHolder.startIDs.metaItemCustomId++, "macerated_bedrock_debris");
        BEDROCK_DEBRIS = addItem(VTConfigHolder.startIDs.metaItemCustomId++, "bedrock_debris");
        CARBID_TUNGSTEN_GRINDER = addItem(VTConfigHolder.startIDs.metaItemCustomId++, "carbid_tungsten_grinder");
    }
}
