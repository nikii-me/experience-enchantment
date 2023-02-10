package com.yukii.experienceenchantment.mixin;

import com.yukii.experienceenchantment.ExperienceEnchantmentMain;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(RedstoneOreBlock.class)
public class RedstoneOreBlockMixin {
    @ModifyArgs(method = "onStacksDropped", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/RedstoneOreBlock;dropExperience(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;I)V"))
    private void modifyExperienceDrop(Args args, BlockState state, ServerWorld world, BlockPos pos, ItemStack stack, boolean dropExperience) {
        int i = args.get(2);
        i += EnchantmentHelper.getLevel(ExperienceEnchantmentMain.EXPERIENCE, stack) * i;
        args.set(2, i);
    }
}
