package ricky.ceu.gtvoidtech.common.metatileentities.machines;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import org.jetbrains.annotations.NotNull;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;

import ricky.ceu.gtvoidtech.api.recipes.VTRecipeMaps;
import ricky.ceu.gtvoidtech.api.render.VTTextures;
import ricky.ceu.gtvoidtech.api.unification.materials.VTMaterials;
import ricky.ceu.gtvoidtech.common.block.VTMetaBlocks;
import ricky.ceu.gtvoidtech.common.block.blocks.VTBlockLargeMultiblockCasing;
import ricky.ceu.gtvoidtech.common.block.blocks.VTBlockUniqueCasings;

public class VTPressureBooster extends GCYMRecipeMapMultiblockController {

    public VTPressureBooster(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, VTRecipeMaps.AIR_COLLECTOR_RECIPES);
    }

    @Override
    public boolean isParallel() {
        return false;
    }

    @Override
    public boolean isTiered() {
        return true;
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("RRR", "F F", "F F", "F F", "CIC")
                .aisle("RRR", " Q ", " E ", " E ", "CCC")
                .aisle("RSR", "F F", "F F", "F F", "CCC")
                .where(' ', any())
                .where('S', selfPredicate())
                .where('F', frames(VTMaterials.Maraging_Steel_300))
                .where('Q', states(getCasingState2()))
                .where('E', states(getCasingState3()))
                .where('R', states(getCasingState1()).or(autoAbilities(true, true, false, false, false, true, false)))
                .where('I',
                        abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .or(autoAbilities(false, false, false, false, true, false, false)))
                .where('C', states(getCasingState1()))
                .build();
    }

    private static IBlockState getCasingState1() {
        return VTMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(VTBlockLargeMultiblockCasing.CasingType.MARAGING_STEEL);
    }

    private static IBlockState getCasingState2() {
        return VTMetaBlocks.UNIQUE_CASINGS.getState(VTBlockUniqueCasings.CasingType.HYDRAULIC_PRESS);
    }

    private static IBlockState getCasingState3() {
        return VTMetaBlocks.UNIQUE_CASINGS.getState(VTBlockUniqueCasings.CasingType.PRESS_PIPE);
    }

    @Override
    public SimpleOverlayRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return VTTextures.PRESSURE_BOOSTER_CASING;
    }

    @Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return VTTextures.PRESSURE_BOOSTER_OVERLAY;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new VTPressureBooster(metaTileEntityId);
    }

    @Override
    public BlockPos getPos() {
        return super.getPos();
    }
}
