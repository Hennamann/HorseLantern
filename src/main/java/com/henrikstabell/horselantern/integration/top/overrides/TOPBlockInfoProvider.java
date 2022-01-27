package com.henrikstabell.horselantern.integration.top.overrides;

import com.henrikstabell.horselantern.HorseLantern;
import com.henrikstabell.horselantern.block.HorseArmorLightBlock;
import mcjty.theoneprobe.api.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class TOPBlockInfoProvider implements IBlockDisplayOverride, IProbeConfigProvider {

    @Override
    public boolean overrideStandardInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, Player player, Level level, BlockState blockState, IProbeHitData iProbeHitData) {
        return level.getBlockState(iProbeHitData.getPos()).getBlock() instanceof HorseArmorLightBlock;
    }

    @Override
    public void getProbeConfig(IProbeConfig iProbeConfig, Player player, Level level, Entity entity, IProbeHitEntityData iProbeHitEntityData) {}

    @Override
    public void getProbeConfig(IProbeConfig iProbeConfig, Player player, Level level, BlockState blockState, IProbeHitData iProbeHitData) {
        if (level.getBlockState(iProbeHitData.getPos()).getBlock() instanceof HorseArmorLightBlock) {
            iProbeConfig.showHarvestLevel(IProbeConfig.ConfigMode.NOT).showCanBeHarvested(IProbeConfig.ConfigMode.NOT);
        }
    }
}
