package com.yukii.experienceenchantment.mixin;

import com.yukii.experienceenchantment.ExperienceEnchantmentMain;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Block.class)
public class BlockMixin {
    @ModifyArgs(method = "dropExperienceWhenMined", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;dropExperience(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;I)V"))
    private void modifyExperienceDrop(Args args, ServerWorld world, BlockPos pos, ItemStack tool, IntProvider experience) {
        int i = args.get(2);
        i += EnchantmentHelper.getLevel(ExperienceEnchantmentMain.EXPERIENCE, tool) * i;
        args.set(2, i);
    }
}
