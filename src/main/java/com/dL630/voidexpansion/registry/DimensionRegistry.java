package com.dL630.voidexpansion.registry;

import com.dL630.voidexpansion.VoidExpansion;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DimensionRegistry {
    public static final ResourceKey<Level> VOID_DIMENSION_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(VoidExpansion.MOD_ID, "void_dimension"));

    public static final ResourceKey<DimensionType> VOID_DIMENSION_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, VOID_DIMENSION_KEY.getRegistryName());

    public static void register() {
        System.out.println("Registering Void Dimension...");
    }
}
