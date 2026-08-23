package ricky.ceu.gtvoidtech.api.unification.modifiedproperties;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static ricky.ceu.gtvoidtech.api.unification.materials.VTMaterials.vda;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;

public final class VTMaterialExtraFlags {

    public static void setFlags(Material[] materials, MaterialFlag... flags) {
        for (Material material : materials) {
            material.addFlags(flags);
        }
    }

    public static void init() {
        doublePlates();
        densePlates();
        screwsBolts();
        frameBoxes();
        smallGears();
        fineWire();
        longRods();
        rotors();
        plates();
        gears();
        rings();
        rods();
    }

    private static void doublePlates() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_DOUBLE_PLATE);
    }

    private static void densePlates() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_DENSE);
    }

    private static void screwsBolts() {}

    private static void frameBoxes() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_FRAME);
    }

    private static void smallGears() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_SMALL_GEAR);
    }

    private static void fineWire() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_FINE_WIRE);
    }

    private static void longRods() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_LONG_ROD);
    }

    private static void rotors() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_ROTOR);
    }

    private static void plates() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_PLATE);
    }

    private static void gears() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_GEAR);
    }

    private static void rings() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_RING);
    }

    private static void rods() {
        Material[] materials = { vda };

        setFlags(materials, GENERATE_BOLT_SCREW);
    }
}
