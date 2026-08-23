package ricky.ceu.gtvoidtech.common.metatileentities.machines;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import ricky.ceu.gtvoidtech.api.recipes.VTRecipeMaps;
import ricky.ceu.gtvoidtech.api.render.VTTextures;
import ricky.ceu.gtvoidtech.api.unification.materials.VTMaterials;
import ricky.ceu.gtvoidtech.common.block.VTMetaBlocks;
import ricky.ceu.gtvoidtech.common.block.blocks.VTBlockLargeMultiblockCasing;
import ricky.ceu.gtvoidtech.common.block.blocks.VTBlockUniqueCasings;


public class VTHotIsostaticFurnace extends GCYMRecipeMapMultiblockController {

    public VTHotIsostaticFurnace(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, VTRecipeMaps.HOT_ISOSTATIC_FURNACE);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new VTHotIsostaticFurnace(metaTileEntityId);
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
    public BlockPos getPos() {
        return super.getPos();
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" CCCCC ", " CPEDC ", " CQMQC ", " CQQQC ", " CQQQC ", "  CCC  ", "       ", "       ",
                        "       ", "       ")
                .aisle("CQQQQQC", "CHHHHHC", "CKKKKKC", "CKKKKKC", "CHHHHHC", " CQQQC ", "   F   ", "   F   ",
                        "   F   ", "   C   ")
                .aisle("CQQQQQC", "QHHHHHQ", "QKAAAKQ", "QKAAAKQ", "QHHHHHQ", "CQQQQQC", "       ", "       ",
                        "       ", "   C   ")
                .aisle("CQQQQQC", "QHHHHHQ", "IKAAAKO", "QKAAAKQ", "QHHJHHQ", "CQQJQQC", " F Y F ", " F J F ",
                        " F J F ", " CCLCC ")
                .aisle("CQQQQQC", "QHHHHHQ", "QKAAAKQ", "QKAAAKQ", "QHHHHHQ", "CQQQQQC", "       ", "       ",
                        "       ", "   C   ")
                .aisle("CQQQQQC", "CHHHHHC", "CKKKKKC", "CKKKKKC", "CHHHHHC", " CQQQC ", "   F   ", "   F   ",
                        "   F   ", "   C   ")
                .aisle(" CCCCC ", " CQQQC ", " CQSQC ", " CQQQC ", " CQQQC ", "  CCC  ", "       ", "       ",
                        "       ", "       ")
                .where(' ', any())
                .where('C', states(getCasingState1()))
                .where('Q', states(getCasingState2()))
                .where('H', states(getCasingState3()))
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('I', abilities(MultiblockAbility.IMPORT_ITEMS))
                .where('O', abilities(MultiblockAbility.EXPORT_ITEMS))
                .where('L', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('P', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('D', abilities(MultiblockAbility.EXPORT_FLUIDS))
                .where('M', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .where('F', frames(VTMaterials.Maraging_Steel_300))
                .where('Y', states(getCasingState4()))
                .where('J', states(getCasingState5()))
                .where('S', selfPredicate())
                .where('K', states(getCasingState6()))
                .where('A', air())
                .build();
    }

    private static IBlockState getCasingState1() {
        return VTMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(VTBlockLargeMultiblockCasing.CasingType.MARAGING_STEEL);
    }

    private static IBlockState getCasingState2() {
        return VTMetaBlocks.LARGE_MULTIBLOCK_CASING
                .getState(VTBlockLargeMultiblockCasing.CasingType.ALUMINA_ISOLATING_CASING);
    }

    private static IBlockState getCasingState3() {
        return VTMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(VTBlockLargeMultiblockCasing.CasingType.HSLA_STEEL_CASING);
    }

    private static IBlockState getCasingState4() {
        return VTMetaBlocks.UNIQUE_CASINGS.getState(VTBlockUniqueCasings.CasingType.HYDRAULIC_PRESS);
    }

    private static IBlockState getCasingState5() {
        return VTMetaBlocks.UNIQUE_CASINGS.getState(VTBlockUniqueCasings.CasingType.PRESS_PIPE);
    }

    private static IBlockState getCasingState6() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.MOLYBDENUM_DISILICIDE_COIL);
    }

    @Override
    public SimpleOverlayRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return VTTextures.HOT_ISOSTATIC_FURNACE_CASING;
    }

    @Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return VTTextures.HOT_ISOSTATIC_FURNACE_OVERLAY;
    }
}