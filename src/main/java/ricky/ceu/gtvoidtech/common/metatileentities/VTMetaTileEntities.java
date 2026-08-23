package ricky.ceu.gtvoidtech.common.metatileentities;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static ricky.ceu.gtvoidtech.api.util.GTVoidTechUtil.vtid;

import gregtech.api.block.machines.MachineItemBlock;

import ricky.ceu.gtvoidtech.api.GTApi;
import ricky.ceu.gtvoidtech.common.metatileentities.machines.*;

public final class VTMetaTileEntities {

    public static VTBedrockCrusher BEDROCK_CRUSHER;
    public static VTPressureBooster PRESSURE_BOOSTER;
    public static VTHotIsostaticFurnace HOT_ISOSTATIC_FURNACE;

    public static void init() {
        MachineItemBlock.addCreativeTab(GTApi.TAB_VT);

        BEDROCK_CRUSHER = registerMetaTileEntity(3000,
                new VTBedrockCrusher(vtid("bedrock_crusher")));

        PRESSURE_BOOSTER = registerMetaTileEntity(3001,
                new VTPressureBooster(vtid("pressure_booster")));

        HOT_ISOSTATIC_FURNACE = registerMetaTileEntity(3002,
                new VTHotIsostaticFurnace(vtid("thermal_isostatic_furnace")));
    }
}
