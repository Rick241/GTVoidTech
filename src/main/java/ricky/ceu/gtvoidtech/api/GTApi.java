package ricky.ceu.gtvoidtech.api;

import gregtech.api.util.BaseCreativeTab;
import ricky.ceu.gtvoidtech.common.item.VTMetaItems;

public class GTApi {
    public static final BaseCreativeTab TAB_VT = new BaseCreativeTab("gtvoidtech",
            () -> VTMetaItems.VOID_CORE.getStackForm(), false);
}
