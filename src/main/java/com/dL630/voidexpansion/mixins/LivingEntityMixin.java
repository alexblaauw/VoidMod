package com.dL630.voidexpansion.mixins;

import com.dL630.voidexpansion.registry.DimensionRegistry;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @ModifyConstant(method = "travel", constant = @Constant(doubleValue = 0.08D))
    private double modifyGravity(double gravity) {
        LivingEntity entity = LivingEntity.class.cast(this);
        System.out.println("Mixin succesful!");
        return gravity;
    }

    @Inject(at = @At("HEAD"), method = "baseTick")
    public void baseTick() {
        System.out.println("hello!");
    }

}
