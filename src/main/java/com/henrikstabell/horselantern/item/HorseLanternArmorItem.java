package com.henrikstabell.horselantern.item;

import com.henrikstabell.horselantern.HorseLantern;
import com.henrikstabell.horselantern.api.IHorseLanternArmor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;

public class HorseLanternArmorItem extends HorseArmorItem implements IHorseLanternArmor {

    public HorseLanternArmorItem(int protection, String type, Properties properties) {
        super(protection, new ResourceLocation(HorseLantern.MODID + ":textures/entity/horse_armor/horse_lantern_armor_" + type + ".png"), properties);
    }

    public ResourceLocation getTexture() {
        return super.getTexture();
    }

    public int getProtection() {
        return super.getProtection();
    }
}
