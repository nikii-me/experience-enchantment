package com.yukii.experienceenchantment;

import com.yukii.experienceenchantment.enchantment.ExperienceEnchantment;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ExperienceEnchantmentMain implements ModInitializer {
    /**
     * Registers a new enchantment into the game called "Experience", which multiplies XP you get from activities such as mining, fishing or killing.
     */
    public static final Enchantment EXPERIENCE = Registry.register(Registries.ENCHANTMENT, new Identifier("experience-enchantment", "experience"), new ExperienceEnchantment());

    //This getter exists solely because you can't just place a field by itself inside a method. Whatever.
    private static Enchantment getExperience() {
        return EXPERIENCE;
    }
    @Override
    public void onInitialize() {
        //This is stupid.
        getExperience();
    }
}
