package com.dL630.voidexpansion.registry;

import com.dL630.voidexpansion.VoidExpansion;
import net.minecraft.world.level.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VoidExpansion.MOD_ID);

    public static final RegistryObject<Block> VOID_STONE = registerBlock("void_stone",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F, 6.0F)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> VOID_STONE_FURNACE = registerBlock("void_stone_furnace",
            () -> new FurnaceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F, 6.0F)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> VOID_TENEBRIS = registerBlock("void_tenebris",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)
                    .sound(SoundType.NETHER_WART)
                    .strength(1.5F, 3.5F)),
            CreativeModeTab.TAB_BUILDING_BLOCKS);



    private static <T extends Block> RegistryObject<T> registerBlock(String name,
                                                                     Supplier<T> block,
                                                                     CreativeModeTab tab) {
        RegistryObject<T> outputBlock = BLOCKS.register(name, block);
        registerBlockItem(name, (RegistryObject<Block>) outputBlock, tab);

        return outputBlock;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,
                                                                           RegistryObject<Block> block,
                                                                           CreativeModeTab tab)
    {
        return ItemRegistry.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
