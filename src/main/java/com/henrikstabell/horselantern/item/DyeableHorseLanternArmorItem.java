package com.henrikstabell.horselantern.item;

import com.henrikstabell.horselantern.HorseLantern;
import com.henrikstabell.horselantern.api.IHorseLanternArmor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeableHorseArmorItem;
import net.minecraft.world.item.DyeableLeatherItem;

public class DyeableHorseLanternArmorItem extends DyeableHorseArmorItem implements DyeableLeatherItem, IHorseLanternArmor {

    public DyeableHorseLanternArmorItem(int protection, String type, Properties properties) {
        super(protection, new ResourceLocation(HorseLantern.MODID + ":textures/entity/horse_armor/horse_lantern_armor_" + type + ".png"), properties);
    }
}
