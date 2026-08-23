package ricky.ceu.gtvoidtech.common.block;

import java.util.Objects;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.jetbrains.annotations.NotNull;

import gregtech.common.blocks.MetaBlocks;

import ricky.ceu.gtvoidtech.common.block.blocks.VTBlockCoil;
import ricky.ceu.gtvoidtech.common.block.blocks.VTBlockLargeMultiblockCasing;
import ricky.ceu.gtvoidtech.common.block.blocks.VTBlockUniqueCasings;

public class VTMetaBlocks {

    public static VTBlockLargeMultiblockCasing LARGE_MULTIBLOCK_CASING;
    public static VTBlockUniqueCasings UNIQUE_CASINGS;
    public static VTBlockCoil COIL_BLOCKS;

    public static void init() {
        LARGE_MULTIBLOCK_CASING = new VTBlockLargeMultiblockCasing();
        LARGE_MULTIBLOCK_CASING.setRegistryName("large_multiblock_casing");

        UNIQUE_CASINGS = new VTBlockUniqueCasings();
        UNIQUE_CASINGS.setRegistryName("unique_casing");

        COIL_BLOCKS = new VTBlockCoil();
        COIL_BLOCKS.setRegistryName("coil_blocks"); // Имя должно совпадать с blockstates/coil_blocks.json
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(LARGE_MULTIBLOCK_CASING);
        registerItemModel(UNIQUE_CASINGS);
        registerItemModel(COIL_BLOCKS); // <-- ДОБАВЛЯЕМ
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@NotNull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            ModelLoader.setCustomModelResourceLocation(
                    Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(
                            Objects.requireNonNull(block.getRegistryName()),
                            MetaBlocks.statePropertiesToString(state.getProperties())
                    )
            );
        }
    }
}