package ricky.ceu.gtvoidtech.api.unification.materials.VTAlloys;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static ricky.ceu.gtvoidtech.api.unification.materials.VTMaterials.*;
import static ricky.ceu.gtvoidtech.api.util.GTVoidTechUtil.vtid;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

import ricky.ceu.gtvoidtech.common.VTConfigHolder;

public class VTAlloysList {

    private VTAlloysList() {}

    public static void register() {
        HSLA_Steel = new Material.Builder(VTConfigHolder.startIDs.customMaterialId++, vtid("hsla_steel_100"))
                .ingot().fluid()
                .color(0x113311).iconSet(MaterialIconSet.METALLIC)
                .flags(EXT2_METAL, GENERATE_FRAME, GENERATE_RING, GENERATE_GEAR, GENERATE_DENSE)
                .components(Carbon, 1, Copper, 1, Molybdenum, 1, Niobium, 1, Titanium, 1, Vanadium, 1)
                .rotorStats(10.0f, 8.0f, 5120)
                .blast(b -> b
                        .temp(5000, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[EV], 1400)
                        .vacuumStats(VA[HV]))
                .build();

        Aluminum_oxide = new Material.Builder(VTConfigHolder.startIDs.customMaterialId++, vtid("aluminum_oxide"))
                .ingot()
                .color(0xE8E0D8)
                .flags(EXT2_METAL, GENERATE_FRAME, GENERATE_RING, GENERATE_GEAR, GENERATE_DENSE)
                .components(Aluminium, 3, Oxygen, 2)
                .build();

        Maraging_Steel_300 = new Material.Builder(VTConfigHolder.startIDs.customMaterialId++,
                vtid("maraging_steel_300"))
                        .ingot()
                        .fluid()
                        .color(0x505B6E)
                        .flags(EXT2_METAL, GENERATE_FRAME, GENERATE_RING, GENERATE_GEAR, GENERATE_DENSE)
                        .components(Iron, 7, Nickel, 2, Cobalt, 1, Molybdenum, 1, Titanium, 1, Aluminium, 1)
                        .blast(b -> b
                                .temp(5000, BlastProperty.GasTier.HIGHER)
                                .blastStats(VA[ZPM], 2800)
                                .vacuumStats(VA[ZPM]))
                        .build();
    }
}
