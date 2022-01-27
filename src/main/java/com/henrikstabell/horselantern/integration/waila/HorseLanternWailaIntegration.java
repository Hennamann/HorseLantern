package com.henrikstabell.horselantern.integration.waila;

import com.henrikstabell.horselantern.HorseLantern;
import com.henrikstabell.horselantern.block.HorseArmorLightBlock;
import com.henrikstabell.horselantern.block.entity.HorseArmorLightBlockEntity;
import com.henrikstabell.horselantern.integration.waila.overrides.WailaBlockOverrideProvider;
import com.henrikstabell.horselantern.integration.waila.overrides.WailaEntityOverrideProvider;
import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.WailaPlugin;

@WailaPlugin(id = HorseLantern.MODID + ":waila_plugin")
public class HorseLanternWailaIntegration implements IWailaPlugin {

    @Override
    public void register(IRegistrar registrar) {
        registrar.addOverride(new WailaBlockOverrideProvider(), HorseArmorLightBlock.class);
        registrar.addOverride(new WailaEntityOverrideProvider(), HorseArmorLightBlockEntity.class);
    }
}
