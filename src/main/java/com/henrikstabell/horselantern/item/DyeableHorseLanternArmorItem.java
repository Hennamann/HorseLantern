package com.henrikstabell.horselantern.item;

import com.henrikstabell.horselantern.api.ILanternArmor;
import net.minecraft.world.item.DyeableLeatherItem;

public class DyeableHorseLanternArmorItem extends HorseLanternArmorItem implements DyeableLeatherItem, ILanternArmor {

    public DyeableHorseLanternArmorItem(int protection, String type, Properties properties) {
        super(protection, type, properties);
    }

}
