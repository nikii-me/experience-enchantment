package com.yukii.experienceenchantment;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.enchantment.EnchantmentTarget;

//The only reason this exists is because I can't put the field in the main class for whatever reason. Go figure.
public interface ExperienceToolsTarget {

    /**
     * Allows the custom enum to be used as an EnchantmentTarget.
     */
    EnchantmentTarget EXPERIENCE_TOOLS_TARGET = ClassTinkerers.getEnum(EnchantmentTarget.class, "EXPERIENCE_TOOLS");
}
