package com.ecarrascon.simpleorpheus;

import com.ecarrascon.carrasconlib.config.LibConfig;
import com.ecarrascon.simpleorpheus.registry.RegistriesMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class SimpleOrpheus {
    public static final String MOD_ID = "simpleorpheus";
    public static LibConfig<ConfigData> CONFIG;
    public static ConfigData CONFIG_VALUES;
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {

        CONFIG = new LibConfig<>(
                "simpleorpheus-config.json",
                ConfigData.class,
                SimpleOrpheus.LOGGER
        );
        CONFIG_VALUES = CONFIG.get();

        RegistriesMod.init();
    }
}
