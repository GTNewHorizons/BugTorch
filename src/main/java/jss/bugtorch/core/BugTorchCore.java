package jss.bugtorch.core;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import jss.bugtorch.modsupport.PamsTemperatePlantsSupport;
import jss.bugtorch.modsupport.ThaumcraftSupport;
import jss.bugtorch.modsupport.VillageNamesSupport;
import jss.bugtorch.modsupport.WitcherySupport;
import jss.bugtorch.util.AssetLoader;
import jss.bugtorch.util.LoadedMods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = BugTorchCore.MODID,
        name = BugTorchCore.NAME,
        version = "GRADLETOKEN_VERSION",
        dependencies =
                "required-after:gtnhmixins@[2.0.1,);after:Thaumcraft;after:temperateplants;after:VillageNames;after:witchery")
public class BugTorchCore {

    public static final String MODID = "bugtorch";
    public static final String NAME = "BugTorch";

    public static final Logger logger = LogManager.getLogger(MODID);

    @EventHandler
    public void construct(FMLConstructionEvent event) {
        if (LoadedMods.txLoaderPresent && FMLCommonHandler.instance().getSide().isClient()) {
            AssetLoader.load();
        }
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LoadedMods.detectLoadedMods();

        VanillaSupport.enableSupport();

        if (LoadedMods.pamsTemperatePlantsLoaded) {
            PamsTemperatePlantsSupport.enableSupport();
        }

        if (LoadedMods.thaumcraftLoaded) {
            ThaumcraftSupport.enableSupport();
        }

        if (LoadedMods.witcheryLoaded) {
            WitcherySupport.enableSupport();
        }

        if (LoadedMods.villageNamesLoaded) {
            VillageNamesSupport.enableSupport();
        }
    }
}
