package ricky.ceu.gtvoidtech.common.metatileentities.machines;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;

import gregicality.multiblocks.api.capability.impl.GCYMMultiblockRecipeLogic;
import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;

import ricky.ceu.gtvoidtech.api.recipes.VTRecipeMaps;
import ricky.ceu.gtvoidtech.api.render.VTTextures;
import ricky.ceu.gtvoidtech.common.block.VTMetaBlocks;
import ricky.ceu.gtvoidtech.common.block.blocks.VTBlockLargeMultiblockCasing;

public class VTBedrockCrusher extends GCYMRecipeMapMultiblockController {

    public VTBedrockCrusher(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, VTRecipeMaps.BEDROCK_CRUSHER_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new VTBedrockCrusher(metaTileEntityId);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("     ", "F   F", "KOEIC", "FVVVF", "FCCCF", "FCCCF", "FCCCF", "FCCCF", "FVVVF", "CCCCC")
                .aisle("  Q  ", "  C  ", "CCCCC", "VACAV", "CACAC", "CACAC", "CCCCC", "CPPPC", "VAAAV", "CCCCC")
                .aisle(" Q Q ", " C C ", "CCGCC", "VCGCV", "CCGCC", "CCGCC", "CCGCC", "CPGPC", "VAGAV", "CCCCC")
                .aisle("  Q  ", "  C  ", "CCCCC", "VACAV", "CACAC", "CACAC", "CCCCC", "CPPPC", "VAAAV", "CCCCC")
                .aisle("     ", "F   F", "CCSCC", "FVVVF", "FCCCF", "FCCCF", "FCCCF", "FCCCF", "FVVVF", "CCCCC")
                .where('S', selfPredicate())
                .where('C', states(getCasingState()))
                .where('F', frames(Materials.Steel))
                .where('V', states(getCasingState4()))
                .where('G', states(getCasingState5()))
                .where('P', states(getPipeCasingState()))
                .where('A', air())
                .where('Q', blocks(Blocks.BEDROCK, Blocks.BEDROCK))
                .where(' ', any())
                .where('O', abilities(MultiblockAbility.EXPORT_ITEMS))
                .where('I', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('K', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .build();
    }

    @Override
    public boolean isParallel() {
        return false;
    }

    @Override
    public boolean isTiered() {
        return true;
    }

    private static IBlockState getCasingState() {
        return VTMetaBlocks.LARGE_MULTIBLOCK_CASING
                .getState(VTBlockLargeMultiblockCasing.CasingType.BEDROCK_CRUSHER_CASING);
    }

    private IBlockState getPipeCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    private static IBlockState getCasingState4() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    private static IBlockState getCasingState5() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_GEARBOX);
    }

    @Override
    public SimpleOverlayRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return VTTextures.BEDROCK_CRUSHER_CASING;
    }

    @Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return VTTextures.BEDROCK_CRUSHER_OVERLAY;
    }

    @Override
    public BlockPos getPos() {
        return super.getPos();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);

        // Добавляем описание (видно всегда)
        tooltip.add(I18n.format("gtvoidtech.machine.bedrock_crusher.description1"));
        tooltip.add(I18n.format("gtvoidtech.machine.bedrock_crusher.description2"));
        tooltip.add(I18n.format("gtvoidtech.machine.bedrock_crusher.description3"));
    }

    private static final int MAX_DEPTH = 5;          // максимальное число разрушаемых бедроков
    private int destroyedCount = 0;                  // сколько бедроков уже сломано
    private int totalDestroyed = 0;                  // сколько всего блоков сломано (включая обычные)
    private boolean wasAtMax = false;                // флаг ожидания разрушения после завершения рецепта
    private int completionTicks = 0;                 // счётчик тиков после завершения

    // Кэшированная информация о следующем блоке (обновляется только при изменениях)
    private BlockPos nextBlockPos = null;
    private boolean nextBlockIsBedrock = false;

    // ------------------------------------------------------------
    // Инициализация
    // ------------------------------------------------------------
    @Override
    public void onLoad() {
        super.onLoad();
        updateNextBlockCache();    // находим первый блок при загрузке
    }

    // ------------------------------------------------------------
    // Основной update – без сканирования мира каждый тик
    // ------------------------------------------------------------
    @Override
    public void update() {
        super.update();
        if (getWorld() == null || getWorld().isRemote) return;

        if (nextBlockPos == null && this.recipeMapWorkable.isWorkingEnabled()) {
            this.recipeMapWorkable.setWorkingEnabled(false);
        }

        GCYMMultiblockRecipeLogic logic = (GCYMMultiblockRecipeLogic) this.recipeMapWorkable;
        int currentProgress = logic.getProgress();
        int maxProgress = logic.getMaxProgress();

        // ----- Обработка завершения рецепта с задержкой 2 тика -----
        if (maxProgress > 0) {
            // Если прогресс достиг максимума и мы ещё не в режиме ожидания
            if (currentProgress >= maxProgress && !wasAtMax) {
                wasAtMax = true;
                completionTicks = 0;
                System.out.println(">>> Progress reached max, scheduling destroy.");
            }
            // Если ожидание активно, считаем тики
            if (wasAtMax) {
                completionTicks++;
                if (completionTicks >= 2) {
                    System.out.println(">>> Destroying block now.");
                    destroyNextBlock();           // уничтожаем кэшированный блок
                    wasAtMax = false;
                    completionTicks = 0;
                    // setActive = false;
                }
            }
        } else {
            // Нет активного рецепта – сбрасываем таймер
            wasAtMax = false;
            completionTicks = 0;

        }
    }

    // ------------------------------------------------------------
    // Обновление кэша: поиск следующего блока (вызывается редко)
    // ------------------------------------------------------------
    private void updateNextBlockCache() {
        World world = getWorld();
        if (world == null) return;

        BlockPos controllerPos = getPos();
        EnumFacing front = getFrontFacing();

        // Защита от вертикальных направлений
        if (front == EnumFacing.UP || front == EnumFacing.DOWN) {
            front = EnumFacing.NORTH;
        }

        EnumFacing localX = front.rotateY();
        EnumFacing localZ = front;
        BlockPos targetColumn = controllerPos
                .offset(localX, 0)
                .offset(localZ, -2);

        int maxY = targetColumn.getY() - 1;
        if (maxY < 0) {
            nextBlockPos = null;
            return;
        }

        // Ищем сверху вниз (от maxY до 0)
        for (int y = maxY; y >= 0; y--) {
            BlockPos checkPos = new BlockPos(targetColumn.getX(), y, targetColumn.getZ());
            if (!world.isAirBlock(checkPos)) {
                if (world.getBlockState(checkPos).getBlock() == Blocks.BEDROCK) {
                    if (destroyedCount < MAX_DEPTH) {
                        nextBlockPos = checkPos;
                        nextBlockIsBedrock = true;
                        return;
                    } else {
                        nextBlockPos = null;
                        return;
                    }
                } else {
                    nextBlockPos = checkPos;
                    nextBlockIsBedrock = false;
                    return;
                }
            }
        }
        nextBlockPos = null;
    }

    // ------------------------------------------------------------
    // Разрушение одного блока (использует кэшированную позицию)
    // ------------------------------------------------------------
    private void destroyNextBlock() {
        World world = getWorld();
        if (world == null || world.isRemote) return;
        if (nextBlockPos == null) {
            System.out.println("destroyNextBlock called but nextBlockPos is null.");
            return;
        }

        BlockPos targetPos = nextBlockPos;

        // Удаляем блок
        assert Blocks.AIR != null;
        world.setBlockState(targetPos, Blocks.AIR.getDefaultState(), 3);

        // Обновляем счётчики
        if (nextBlockIsBedrock) {
            destroyedCount++;
            totalDestroyed++;
            syncDestroyedCount();
            System.out.println(
                    "Destroyed bedrock at " + targetPos + " (bedrock " + destroyedCount + " of " + MAX_DEPTH + ")");
        } else {
            totalDestroyed++;
            System.out.println("Destroyed ordinary block at " + targetPos);
        }

        // После разрушения обновляем кэш, чтобы найти следующий блок
        updateNextBlockCache();

        // Если после обновления кэша блоков нет – работа отключится в следующем тике
        // (или можно сразу выключить, но оставим как есть)
    }

    // ------------------------------------------------------------
    // Синхронизация с клиентом (только количество бедроков)
    // ------------------------------------------------------------
    private void syncDestroyedCount() {
        if (!getWorld().isRemote) {
            writeCustomData(100, buf -> {
                buf.ensureWritable(1);
                buf.writeByte(destroyedCount);
            });
        }
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == 100 && buf.readableBytes() >= 1) {
            destroyedCount = buf.readByte();
        }
    }
}
