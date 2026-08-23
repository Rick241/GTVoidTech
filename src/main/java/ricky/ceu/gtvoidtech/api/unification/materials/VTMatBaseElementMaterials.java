package ricky.ceu.gtvoidtech.api.unification.materials;

import static ricky.ceu.gtvoidtech.api.unification.VTElements.bd;
import static ricky.ceu.gtvoidtech.api.unification.VTElements.vd;
import static ricky.ceu.gtvoidtech.api.util.GTVoidTechUtil.vtid;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

public class VTMatBaseElementMaterials {

    public static int id = 4000;
    public static final MaterialIconSet vda_icons = new MaterialIconSet("vda");
    public static final MaterialIconSet bd_icons = new MaterialIconSet("bd");
    public static Material HiPressureAir;
    public static Material LiquidCarbon;
    public static Material HiPressureArgon;

    public static void register() {
        VTMaterials.vda = new Material.Builder(id++, vtid("vda"))
                .dust(7)
                .iconSet(vda_icons)
                .color(0x504045)
                .element(vd)
                .build();

        VTMaterials.bedrock_dust = new Material.Builder(id++, vtid("bedrock_dust"))
                .dust(7)
                .iconSet(bd_icons)
                .color(0x705065)
                .element(bd)
                .build();

        HiPressureAir = new Material.Builder(id++, vtid("hight_pressure_air"))
                .color(0xFFFFFF)
                .gas()
                .build();

        LiquidCarbon = new Material.Builder(id++, vtid("fluid_carbon"))
                .color(0x101010)
                .liquid()
                .build();

        HiPressureArgon = new Material.Builder(id++, vtid("hipressure_argon"))
                .color(0x12FF12)
                .gas()
                .build();
    }
}
