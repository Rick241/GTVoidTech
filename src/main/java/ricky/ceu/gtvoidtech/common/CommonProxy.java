package ricky.ceu.gtvoidtech.common;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;

import gregtech.api.block.IHeatingCoilBlockStats;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import gregtech.api.GregTechAPI;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.event.MaterialRegistryEvent;
import gregtech.api.unification.material.event.PostMaterialEvent;

import ricky.ceu.gtvoidtech.GTVoidTech;
import ricky.ceu.gtvoidtech.api.recipes.VTRecipeMaps;
import ricky.ceu.gtvoidtech.api.recipes.multiblock.VTAirCollectorRecipes;
import ricky.ceu.gtvoidtech.api.recipes.multiblock.VTBedrockCrusherRecipes;
import ricky.ceu.gtvoidtech.api.unification.materials.VTMaterials;
import ricky.ceu.gtvoidtech.common.block.VTMetaBlocks;
import ricky.ceu.gtvoidtech.common.block.blocks.VTBlockCoil;
import ricky.ceu.gtvoidtech.common.item.VTMetaItems;
import ricky.ceu.gtvoidtech.common.metatileentities.VTMetaTileEntities;
import ricky.ceu.gtvoidtech.recipes.VTRecipes;

@Mod.EventBusSubscriber(modid = GTVoidTech.MODID)
public abstract class CommonProxy {

    public void preInit() {
        VTRecipeMaps.init();
        VTMetaBlocks.init();
        VTMetaItems.init();
        VTMetaTileEntities.init();
    }

    public void init() {
        VTBedrockCrusherRecipes.init();
        VTAirCollectorRecipes.init();

        // Получаем состояние блока (неактивное)
        IBlockState coilState = VTMetaBlocks.COIL_BLOCKS.getState(VTBlockCoil.CoilType.GRAPHITE_COIL);

        // Регистрируем катушку: ключ — состояние блока, значение — объект с характеристиками (enum)
        GregTechAPI.HEATING_COILS.put(coilState, VTBlockCoil.CoilType.GRAPHITE_COIL);
    }

    public void postInit() {}

    @SubscribeEvent()
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        VTRecipes.init();
    }

    // ==================Регистрация Обшивок=================//
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(VTMetaBlocks.LARGE_MULTIBLOCK_CASING);
        registry.register(VTMetaBlocks.UNIQUE_CASINGS);
        registry.register(VTMetaBlocks.COIL_BLOCKS);
    }

    // ==================Регистрация блоков типа ItemBlock===//
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(createItemBlock(VTMetaBlocks.LARGE_MULTIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(VTMetaBlocks.UNIQUE_CASINGS, VariantItemBlock::new));
        registry.register(createItemBlock(VTMetaBlocks.COIL_BLOCKS, VariantItemBlock::new));
    }

    @SubscribeEvent
    public static void registerMaterials(MaterialEvent event) {
        VTMaterials.init();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void lateMaterialChanges(PostMaterialEvent event) {
        VTMaterials.initChanges();
    }

    @SubscribeEvent
    public static void createMaterialRegistry(MaterialRegistryEvent event) {
        GregTechAPI.materialManager.createRegistry(GTVoidTech.MODID);
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(GTVoidTech.MODID)) {
            ConfigManager.sync(GTVoidTech.MODID, Config.Type.INSTANCE);
        }
    }
}