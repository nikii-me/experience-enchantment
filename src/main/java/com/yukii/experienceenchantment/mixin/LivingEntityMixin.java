package com.yukii.experienceenchantment.mixin;

import com.yukii.experienceenchantment.ExperienceEnchantmentMain;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.TridentEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow public abstract LivingEntity getAttacker();
    @Shadow public abstract DamageSource getRecentDamageSource();

    @ModifyArg(method = "dropXp", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ExperienceOrbEntity;spawn(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/Vec3d;I)V"))
    private int customXpInt(int i) {
        LivingEntity attacker = this.getAttacker();
        if (attacker instanceof PlayerEntity player && !((Object) this instanceof PlayerEntity)) {
            if (this.getRecentDamageSource() != null && this.getRecentDamageSource().getSource() instanceof TridentEntity trident) {
                if (trident.getOwner() != null && trident.getOwner().equals(attacker)) {
                    return i + (EnchantmentHelper.getLevel(ExperienceEnchantmentMain.EXPERIENCE, ((TridentEntityAccessor) trident).invokeAsItemStack()) * i);
                }
            }
            return i + (EnchantmentHelper.getLevel(ExperienceEnchantmentMain.EXPERIENCE, player.getMainHandStack()) * i);
        }
        return i;
    }
}
