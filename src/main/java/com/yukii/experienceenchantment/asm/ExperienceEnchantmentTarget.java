package com.yukii.experienceenchantment.asm;

import net.minecraft.item.*;

public class ExperienceEnchantmentTarget extends EnchantmentTargetMixin {
    @Override
    public boolean isAcceptableItem(Item item) {
        return item instanceof ToolItem
                || item instanceof RangedWeaponItem
                || item instanceof TridentItem
                || item instanceof FishingRodItem;
    }
}
