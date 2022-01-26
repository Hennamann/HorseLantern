package com.henrikstabell.horselantern.item;

import com.henrikstabell.horselantern.HorseLantern;
import com.henrikstabell.horselantern.api.ILanternArmor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;

public class HorseLanternArmorItem extends HorseArmorItem implements ILanternArmor {

    public HorseLanternArmorItem(int protection, String type, Properties properties) {
        super(protection, new ResourceLocation(HorseLantern.MODID + ":textures/entity/horse_armor/horse_lantern_armor_" + type + ".png"), properties);
    }
}
