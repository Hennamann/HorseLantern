package com.henrikstabell.horselantern.block;

import com.henrikstabell.horselantern.HorseLantern;
import com.henrikstabell.horselantern.block.entity.HorseArmorLightBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class HorseArmorLightBlock extends LightBlock implements EntityBlock {

    public HorseArmorLightBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return HorseLantern.HORSE_ARMOR_LIGHT_BLOCK_ENTITYTYPE.create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return type == HorseLantern.HORSE_ARMOR_LIGHT_BLOCK_ENTITYTYPE ? HorseArmorLightBlockEntity::tick : null;
    }
}
