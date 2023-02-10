package com.yukii.experienceenchantment.mixin;

import com.yukii.experienceenchantment.ExperienceEnchantmentMain;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberEntityMixin {
    @Shadow
    public abstract PlayerEntity getPlayerOwner();

    @ModifyArg(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ExperienceOrbEntity;<init>(Lnet/minecraft/world/World;DDDI)V"))
    private int customXpInt(int i) {
        if (getPlayerOwner() != null) {
            return i + (EnchantmentHelper.getLevel(ExperienceEnchantmentMain.EXPERIENCE, this.getPlayerOwner().getMainHandStack()) * i);
        }
        return i;
    }
}
