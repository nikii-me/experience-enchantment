package com.yukii.experienceenchantment.enchantment;

import com.yukii.experienceenchantment.ExperienceToolsTarget;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;

public class ExperienceEnchantment extends Enchantment {

    public ExperienceEnchantment(EquipmentSlot... slotTypes) {
        super(Rarity.VERY_RARE, ExperienceToolsTarget.EXPERIENCE_TOOLS_TARGET, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return level * 15;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 25;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }
}
