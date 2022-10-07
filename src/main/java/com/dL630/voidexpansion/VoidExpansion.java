package com.dL630.voidexpansion;

import com.dL630.voidexpansion.registry.BlockRegistry;
import com.dL630.voidexpansion.registry.DimensionRegistry;
import com.dL630.voidexpansion.registry.ItemRegistry;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.dL630.voidexpansion.VoidExpansion.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class VoidExpansion
{
    public static final String MOD_ID = "voidexpansion";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public VoidExpansion()
    {
        // Register the setup method for modloading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);

        DimensionRegistry.register();


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", net.minecraft.world.level.block.Blocks.DIRT.getRegistryName());
    }
}
