package com.henrikstabell.horselantern.integration.top;

import com.henrikstabell.horselantern.HorseLantern;
import com.henrikstabell.horselantern.integration.top.overrides.TOPBlockInfoProvider;
import mcjty.theoneprobe.api.IProbeConfig;
import mcjty.theoneprobe.api.ITheOneProbe;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Function;

public class HorseLanternTOPIntegration implements Function<ITheOneProbe, Void> {

    private static ITheOneProbe theOneProbe;

    public void setupTOPIntegration() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::sendIMC);
    }

    public void sendIMC(InterModEnqueueEvent event) {
        HorseLantern.LOGGER.info("Horse Lantern: Detected The One Probe… Registering TOP integration");
        InterModComms.sendTo("theoneprobe", "getTheOneProbe", HorseLanternTOPIntegration::new);
    }

    @Override
    public Void apply(ITheOneProbe theOneProbe) {
        HorseLanternTOPIntegration.theOneProbe = theOneProbe;

        TOPBlockInfoProvider blockInfoProvider = new TOPBlockInfoProvider();
        theOneProbe.registerBlockDisplayOverride(blockInfoProvider);
        theOneProbe.registerProbeConfigProvider(blockInfoProvider);
        return null;
    }
}
