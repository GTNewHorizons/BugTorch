package jss.bugtorch.util;

import cpw.mods.fml.common.Loader;
import net.minecraft.server.MinecraftServer;

public class LoadedMods {

    public static boolean bukkitLoaded;

    public static boolean thaumcraftLoaded;

    public static void detectBukkit() {
    	String serverModName = MinecraftServer.getServer().getServerModName();
        bukkitLoaded = (serverModName.contains("cauldron") || serverModName.contains("mcpc"));
    }

    public static void detectLoadedMods() {
        thaumcraftLoaded = Loader.isModLoaded("Thaumcraft");
    }

}
    
