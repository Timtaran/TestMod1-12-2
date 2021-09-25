package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import java.io.File;
import com.example.examplemod.dev.tools.Config;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "dat";
    public static final String NAME = "DimucaTheDev and TimTarAn Test Mod";
    public static final String VERSION = "0.0.4";

    private static Logger logger;

    private static String file = "config/dat.cfg";
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }


    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        File config = new File(file);
        boolean cond1 = config.exists();
        System.out.println(cond1);
        if (cond1 == false) {
            try {
                config.getParentFile().mkdirs();
                boolean success = config.createNewFile();
Config.writeConfig("main", "invspk", true);
            }
            catch (Exception e) { System.out.println(e);}
        }
    }
}
