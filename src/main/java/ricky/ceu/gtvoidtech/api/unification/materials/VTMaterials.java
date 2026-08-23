package ricky.ceu.gtvoidtech.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.common.items.MetaItems;

import ricky.ceu.gtvoidtech.api.ore.VTOrePrefix;
import ricky.ceu.gtvoidtech.api.unification.materials.VTAlloys.VTAlloysList;
import ricky.ceu.gtvoidtech.api.unification.modifiedproperties.VTMaterialExtraFlags;
import ricky.ceu.gtvoidtech.api.unification.modifiedproperties.VTModifyProperties;

public class VTMaterials {

    public static Material vda;
    public static Material bedrock_dust;
    public static Material HSLA_Steel;
    public static Material Aluminum_oxide;
    public static Material Maraging_Steel_300;
    public static Material HiPressureArgon;

    private VTMaterials() {};

    public static void init() {
        MetaItems.addOrePrefix(VTOrePrefix.nanites);
        VTMatBaseElementMaterials.register();
        VTAlloysList.register();
    }

    public static void initChanges() {
        VTModifyProperties.init();
        VTMaterialExtraFlags.init();
    }

    public static void initLateChangers() {
        VTModifyProperties.init();
    }
}
