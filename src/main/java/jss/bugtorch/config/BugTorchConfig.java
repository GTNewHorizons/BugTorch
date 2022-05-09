package jss.bugtorch.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class BugTorchConfig {

    //Base backports
    public static boolean enableFloatingTrapDoors;

    //Base bugfixes
    public static boolean fixSnowBlocksRandomlyTicking;

    //Mod bugfixes
    public static boolean registerThaumcraftLeavesToTheOreDictionary;
    public static boolean registerThaumcraftThaumiumBlockToTheOreDictionary;
    public static boolean registerThaumcraftWoodStairsToTheOreDictionary;

    //Mod tweaks
    public static boolean craftThaumcraftAncientStoneSlabsAndStairs;
    public static boolean reverseCraftThaumcraftSlabs;

    //Mixin backports
    public static boolean cobwebsCanBeSheared;
    public static boolean deadBushesDropSticks;
    public static boolean fireArrowsDetonateTNTCarts;
    public static boolean throwEnderPearlsInCrativeMode;

    //Mixin bugfixes
    public static boolean fixFireChargeUseSound;
    public static boolean fixLavaHissOnAirReplace;
    public static boolean fixPumpkinPlacementCheck;
    public static boolean fixShearedBlocksDropExtraItems;
    public static boolean fixShearsNotTakingDamageFromNormalBlocks;
    public static boolean fixSignPacketChatMessages;
    public static boolean fixStoneMonsterEggDoubleSpawns;
    public static boolean fixVillagePathsHavePlantsOnTop;
    public static boolean fixVillagerTradeMetadataDetection;
    public static boolean fixVillageSieges;
    public static boolean fixVillageWellDesertMaterial;

    //Mixin performance improvements
    public static boolean brokenChestsDontSplitStacks;
    public static boolean brokenHoppersDontSplitStacks;
    public static boolean fasterDroppedItemStackingChecks;
    public static boolean fasterEntityLivingBaseIsPotionActiveAndSetAir;
    public static boolean fasterGetBlockByIdForAirBlocks;
    public static boolean fasterSnowBlockTicks;
    public static boolean moreAccurateLayeredSnowFaceCulling;
    public static boolean replaceRandomInEffectRenderer;
    public static boolean replaceRandomInEntity;
    public static boolean replaceRandomInItem;
    public static boolean replaceRandomInMinecraftServer;
    public static boolean replaceRandomInRenderItem;
    public static boolean replaceRandomInWorld;
    public static boolean replaceRandomInWorldClient;
    public static boolean skipInitialWorldChunkLoad;

    //Mixin tweaks
    public static boolean lanPortOverride;
    public static int lanPortToUseForOverride;
    public static boolean placeEndPortalsAnywhere;
    public static boolean removeEntityDuplicateExtendedPropertiesIdentifierSpam;

    //Category names
    static final String categoryBackport = "backported features";
    static final String categoryBugfixes = "bug fixes";
    static final String categoryModNames = "mod file names";
    static final String categoryOreDictionary = "ore dictionary";
    static final String categoryPerformance = "performance improvements";
    static final String categoryTweaks = "tweaks";

    public static void loadBaseConfig(File configFile) {
        Configuration config = new Configuration(configFile);

        //Backports
        enableFloatingTrapDoors = config.getBoolean("freeFloatingTrapDoors", categoryBackport, true, "Trapdoors no longer require attachment blocks.\nFrom MC 1.9");

        //Bugfixes
        fixSnowBlocksRandomlyTicking = config.getBoolean("fixSnowBlocksRandomlyTicking", categoryBugfixes, true, "Non-layered snow blocks will no longer randomly tick.\nFrom MC 1.14, fixes MC-88097");

        if(config.hasChanged()) {
            config.save();
        }
    }

    public static void loadModdedConfig(File configFile) {
        Configuration config = new Configuration(configFile);

        //Ore Dictionary
        registerThaumcraftLeavesToTheOreDictionary = config.getBoolean("registerThaumcraftLeavesToTheOreDictionary", categoryOreDictionary, true, "Register Thaumcraft Greatwood and Silverwood leaves as treeLeaves.");
        registerThaumcraftThaumiumBlockToTheOreDictionary = config.getBoolean("registerThaumcraftThaumiumBlockToTheOreDictionary", categoryOreDictionary, true, "Register Thaumcraft Thaumium Blocks as blockThaumium.");
        registerThaumcraftWoodStairsToTheOreDictionary = config.getBoolean("registerThaumcraftWoodStairsToTheOreDictionary", categoryOreDictionary, true, "Register Thaumcraft Greatwood and Silverwood stairs as stairWood.");

        //Tweaks
        craftThaumcraftAncientStoneSlabsAndStairs = config.getBoolean("craftThaumcraftAncientStoneSlabs", categoryTweaks, true, "Craft Thaumcraft Ancient Stone slabs and stairs.");
        reverseCraftThaumcraftSlabs = config.getBoolean("reverseCraftThaumcraftSlabs", categoryTweaks, true, "Craft Thaumcraft slabs back into blocks.");

        if(config.hasChanged()) {
            config.save();
        }
    }

    public static void loadBaseMixinConfig(File configFile) {
        // Adapted from FMLCommonHandler
        boolean serverSide = Thread.currentThread().getName().equals("Server thread");
        
        Configuration config = new Configuration(configFile);

        //Backports
        cobwebsCanBeSheared = config.getBoolean("cobwebsCanBeSheared", categoryBackport, true, "Cobwebs can be collected with Shears without Silk Touch.\nFrom MC 1.9, fixes MC-93001");
        deadBushesDropSticks = config.getBoolean("deadBushesDropSticks", categoryBackport, true, "Dead Bushes drop 0-2 Sticks.\nFrom MC 1.9");
        fireArrowsDetonateTNTCarts = config.getBoolean("fireArrowsDetonateTNTCarts", categoryBackport, true, "Minecarts with TNT explode when hit by fire arrows.\nFrom MC 1.8, fixes MC-8987");
        throwEnderPearlsInCrativeMode = config.getBoolean("throwEnderPearlsInCrativeMode", categoryBackport, true, "Ender Pearls can be thrown in creative mode.\nFrom MC 1.9, fixes MC-438");

        //Bugfixes
        fixFireChargeUseSound = config.getBoolean("fixFireChargeUseSound", categoryBugfixes, true, "Fire Charges have the correct use sound.\nFrom MC 1.8, fixes MC-1831");
        fixLavaHissOnAirReplace = config.getBoolean("fixLavaHissOnAirReplace", categoryBugfixes, true, "Lava will only hiss when mixing with water.\nFrom MC 1.8, fixes MC-32301");
        fixPumpkinPlacementCheck = config.getBoolean("fixPumpkinPlacementCheck", categoryBackport, true, "Pumpkins and Jack o'Lanterns can be placed without a solid block below them.\nFrom MC 1.13, fixes MC-1947");
        fixShearedBlocksDropExtraItems = config.getBoolean("fixShearedBlocksDropExtraItems", categoryBugfixes, true, "Shearing a block will not give drops in addition to itself.");
        fixShearsNotTakingDamageFromNormalBlocks = config.getBoolean("fixShearsNotTakingDamageFromNormalBlocks", categoryBugfixes, true, "Shears will take damage when used to mine any block.\nAlso stops Forge shearing logic from dropping things in creative mode.\nFrom MC 1.9, fixes MC-8180");
        fixSignPacketChatMessages = config.getBoolean("fixSignPacketChatMessages", categoryBugfixes, true, "Sign update packets for signs in unloaded chunks will not send chat messages.\nFrom MC 1.9, fixes MC-3564") && !serverSide;
        fixStoneMonsterEggDoubleSpawns = config.getBoolean("fixStoneMonsterEggDoubleSpawns", categoryBugfixes, true, "Stone Monster Eggs only spawn one Silverfish when broken.\nFrom MC 1.8, fixes MC-31081");
        fixVillagePathsHavePlantsOnTop = config.getBoolean("fixVillagePathsHavePlantsOnTop", categoryBugfixes, true, "Village paths will not have flowers or grass on top of them.\nFrom MC 1.10, fixes MC-3437");
        fixVillagerTradeMetadataDetection = config.getBoolean("fixVillagerTradeMetadataDetection", categoryBugfixes, true, "Villager trades will respect metadata.\nFrom MC 1.8");
        fixVillageSieges = config.getBoolean("fixVillageSieges", categoryBugfixes, true, "Zombies will seige villages that are large enough at night.\nFrom MC 1.8, fixes MC-7432 and MC-7488");
        fixVillageWellDesertMaterial = config.getBoolean("fixVillageWellDesertMaterial", categoryBugfixes, true, "Wells in desert villages will use the correct material.\nFrom MC 1.8, fixes MC-32514");

        //Performance
        brokenChestsDontSplitStacks = config.getBoolean("brokenChestsDontSplitStacks", categoryPerformance, false, "Broken chests don't split apart dropped item stacks.");
        brokenHoppersDontSplitStacks = config.getBoolean("brokenHoppersDontSplitStacks", categoryPerformance, false, "Broken hoppers don't split apart dropped item stacks.");
        fasterDroppedItemStackingChecks = config.getBoolean("fasterDroppedItemStackingChecks", categoryPerformance, true, "Dropped item nearby stack checks are faster for full stacks.");
        fasterEntityLivingBaseIsPotionActiveAndSetAir = config.getBoolean("fasterEntityLivingBaseIsPotionActiveAndSetAir", categoryPerformance, true, "isPotionActive returns immediately if there are no active potions.\nsetAir only updates it's datawatcher when needed.");
        fasterGetBlockByIdForAirBlocks = config.getBoolean("fasterGetBlockByIdForAirBlocks", categoryPerformance, false, "When something gets air blocks from ID it will return faster." );
        fasterSnowBlockTicks = config.getBoolean("fasterSnowBlockTicks", categoryPerformance, true, "Non-layered snow block ticking is faster.");
        moreAccurateLayeredSnowFaceCulling = config.getBoolean("moreAccurateLayeredSnowFaceCulling", categoryPerformance, true, "The faces of layered snow get culled more accurately when chunk meshes are created.");
        replaceRandomInEffectRenderer = config.getBoolean("replaceRandomInEffectRenderer", categoryPerformance, true, "Makes EffectRenderer.class use a faster implementation of random.") && !serverSide;
        replaceRandomInEntity = config.getBoolean("replaceRandomInEntity", categoryPerformance, true, "Makes Entity.class use a faster implementation of random.");
        replaceRandomInItem = config.getBoolean("replaceRandomInItem", categoryPerformance, false, "Makes Item.class use a faster implementation of random.");
        replaceRandomInMinecraftServer = config.getBoolean("replaceRandomInMinecraftServer", categoryPerformance, true, "Makes MinecraftServer.class use a faster implementation of random.");
        replaceRandomInRenderItem = config.getBoolean("replaceRandomInRenderItem", categoryPerformance, true, "Makes RenderItem.class use a faster implementation of random.");
        replaceRandomInWorld = config.getBoolean("replaceRandomInWorld", categoryPerformance, false, "Makes World.class use a faster implementation of random.\n!This impacts world generation slightly!");
        replaceRandomInWorldClient = config.getBoolean("replaceRandomInWorldClient", categoryPerformance, true, "Makes WorldClient.class use a faster implementation of random.") && !serverSide;
        skipInitialWorldChunkLoad = config.getBoolean("skipInitialWorldChunkLoad", categoryPerformance, true, "Speeds up initial world loading by not waiting for chunks to preload.") && !serverSide;

        //Tweaks
        lanPortOverride = config.getBoolean("lanPortOverride", categoryTweaks, false, "Override the port used when opening singleplayer to LAN.") && !serverSide;
        lanPortToUseForOverride = config.getInt("lanPortToUSeForOverride", categoryTweaks, 25565, 1024 , 49151, "Port to use for lanPortOverride.");
        placeEndPortalsAnywhere = config.getBoolean("placeEndPortalsAnywhere", categoryTweaks, false, "Place End Portals outside of the overworld without them getting removed.");
        removeEntityDuplicateExtendedPropertiesIdentifierSpam = config.getBoolean("removeEntityDuplicateExtendedPropertiesIdentifierSpam", categoryTweaks, true, "Removes \"An attempt was made to register exended properties using an existing key\" log spam caused by some mods.");

        if(config.hasChanged()) {
            config.save();
        }
    }

}
