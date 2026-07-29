package ricky.ceu.gtvoidtech.api.util;

import static gregtech.api.metatileentity.multiblock.MultiblockControllerBase.abilities;
import static gregtech.api.metatileentity.multiblock.MultiblockControllerBase.metaTileEntities;

import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.ConfigHolder;
import gregtech.common.metatileentities.MetaTileEntities;

