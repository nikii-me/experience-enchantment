package com.yukii.experienceenchantment.asm;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public class EarlyRiser implements Runnable {

    /**
     * Injects an additional entry into the {@link net.minecraft.enchantment.EnchantmentTarget} enum.<br>
     * The new enum is then used in {@link com.yukii.experienceenchantment.enchantment.ExperienceEnchantment} to make the
     * enchantment compatible with a custom group of items (see {@link ExperienceEnchantmentTarget}).
     */
    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        String enchantmentTargetPattern = remapper.mapClassName("intermediary", "net.minecraft.class_1886");
        ClassTinkerers.enumBuilder(enchantmentTargetPattern)
                .addEnumSubclass("EXPERIENCE_TOOLS", "com.yukii.experienceenchantment.asm.ExperienceEnchantmentTarget").build();
    }
}