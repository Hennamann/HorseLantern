package com.henrikstabell.horselantern;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import org.apache.commons.lang3.tuple.Pair;

public class Configuration {

    public static final ForgeConfigSpec CONFIG_SPEC;
    private static final Configuration CONFIG;

    public final IntValue horseArmorLightLevel;

    static
    {
        Pair<Configuration,ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Configuration::new);

        CONFIG_SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    Configuration(ForgeConfigSpec.Builder builder)
    {
        horseArmorLightLevel = builder
                .comment("Sets the light level emit from Horses with Horse Lantern Armor , where 1 is minimum/weakest and 15 is maximum. Default is 15, same as vanilla Lanterns.")
                .translation("config.horselantern.horseArmorLightLevel")
                .defineInRange("horseArmorLightLevel", 15, 1, 15);
    }

    public static int getHorseArmorLightLevel() {
        return CONFIG.horseArmorLightLevel.get();
    }

}
