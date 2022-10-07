package com.dL630.voidexpansion.registry;

import com.dL630.voidexpansion.VoidExpansion;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VoidExpansion.MOD_ID);

    public static final RegistryObject<Item> ITEM = newItem("item",
            new Properties().tab(CreativeModeTab.TAB_BREWING));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static RegistryObject<Item> newItem(String name, Properties properties) {
        return ITEMS.register(name, () -> new Item(properties));
    }
}
