package ricky.ceu.gtvoidtech.common.block.blocks;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.common.ConfigHolder;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;

public class VTBlockCoil extends VariantActiveBlock<VTBlockCoil.CoilType> {

    public VTBlockCoil() {
        super(net.minecraft.block.material.Material.IRON);
        setTranslationKey("vt_coil");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 3);
        setDefaultState(getState(CoilType.GRAPHITE_COIL));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }
/*
    @Override
    protected boolean isBloomEnabled(CoilType value) {
        return ConfigHolder.client.coilsActiveEmissiveTextures;
    }*/

    public enum CoilType implements IStringSerializable, IHeatingCoilBlockStats {
        GRAPHITE_COIL("graphite_coil", 3000, 4, 4, 5, Materials.Graphite);

        private final String name;
        private final int coilTemperature;
        private final int level;
        private final int energyDiscount;
        private final int tier;
        private final Material material;

        CoilType(String name, int coilTemperature, int level, int energyDiscount, int tier, Material material) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.tier = tier;
            this.material = material;
        }

        @Override
        public int getCoilTemperature() {
            return coilTemperature;
        }

        @Override
        public int getLevel() {
            return level;
        }

        @Override
        public int getEnergyDiscount() {
            return energyDiscount;
        }

        @Override
        public int getTier() {
            return tier;
        }

        @Override
        @Nullable
        public Material getMaterial() {
            return material;
        }

        @Override
        @NotNull
        public String getName() {
            return name;
        }
    }
}