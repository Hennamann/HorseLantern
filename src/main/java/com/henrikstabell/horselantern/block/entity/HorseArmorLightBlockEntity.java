package com.henrikstabell.horselantern.block.entity;

import com.henrikstabell.horselantern.HorseLantern;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class HorseArmorLightBlockEntity extends BlockEntity {

    public HorseArmorLightBlockEntity(BlockPos pos, BlockState state) {
        super(HorseLantern.HORSE_ARMOR_LIGHT_BLOCK_ENTITYTYPE, pos, state);
    }

    public static <T extends BlockEntity> void tick(Level world, BlockPos pos, BlockState state, T be) {
        List<AbstractHorse> nearbyHorses = world.getEntitiesOfClass(AbstractHorse.class, new AABB(pos).inflate(2));
        nearbyHorses.removeIf(horse -> !horse.isWearingArmor());

        if ((long) nearbyHorses.size() == 0) {
            world.removeBlock(pos, false);
        }
    }
}
