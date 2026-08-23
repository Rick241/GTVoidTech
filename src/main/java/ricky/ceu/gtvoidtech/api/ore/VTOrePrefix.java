package ricky.ceu.gtvoidtech.api.ore;

import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

import gregtech.api.unification.ore.OrePrefix;

import ricky.ceu.gtvoidtech.api.unification.materials.VTMatIconType;
import ricky.ceu.gtvoidtech.api.unification.materials.VTMaterialFlags;

public class VTOrePrefix {

    public static final OrePrefix nanites = new OrePrefix("nanites", -1, null, VTMatIconType.nanites,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(VTMaterialFlags.GENERATE_NANITES));
}
