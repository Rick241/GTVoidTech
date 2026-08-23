package ricky.ceu.gtvoidtech.api.unification.modifiedproperties;

import static gregtech.api.unification.material.properties.PropertyKey.*;
import static gregtech.api.unification.material.properties.PropertyKey.INGOT;
import static ricky.ceu.gtvoidtech.api.unification.materials.VTMaterials.vda;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.*;
import gregtech.api.unification.material.properties.IngotProperty;

public final class VTModifyProperties {

    public static void init() {
        ingots();
        dusts();
    }

    private static void ingots() {
        Material[] materials = { vda };
        for (Material material : materials) {
            if (material.hasProperty(INGOT)) continue;
            material.setProperty(INGOT, new IngotProperty());
        }
    }

    private static void dusts() {
        Material[] materials = { vda };
        for (Material material : materials) {
            if (material.hasProperty(DUST)) continue;
            material.setProperty(DUST, new DustProperty());
        }
    }
}
