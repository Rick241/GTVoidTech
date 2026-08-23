package ricky.ceu.gtvoidtech.common.block.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import org.jetbrains.annotations.NotNull;

import gregtech.api.block.VariantBlock;

import ricky.ceu.gtvoidtech.api.GTApi;

public class VTBlockLargeMultiblockCasing extends VariantBlock<VTBlockLargeMultiblockCasing.CasingType> {

    public VTBlockLargeMultiblockCasing() {
        super(Material.IRON);
        setTranslationKey("multiblock_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 2);
        setDefaultState(getState(CasingType.BEDROCK_CRUSHER_CASING));
        setCreativeTab(GTApi.TAB_VT);
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum CasingType implements IStringSerializable {

        BEDROCK_CRUSHER_CASING("bedrock_crusher_casing"),
        BEDROCK_COLLECTOR_CASING("bedrock_collector_casing"),
        HOT_ISOSTATIC_PRESSURIZATION_CASING("hot_isostatic_pressurization_casing"),
        AIR_COLLECTOR("air_collector"),
        HSLA_STEEL_CASING("hsla_steel_casing"),
        MARAGING_STEEL("maraging_steel"),
        HASTELLOY_X_CASING("hastelloy_x_casing"),
        ALUMINA_ISOLATING_CASING("alumina_isolating_casing");

        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Override
        public @NotNull String getName() {
            return this.name;
        }
    }
}
