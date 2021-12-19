package jss.bugtorch.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import jss.bugtorch.config.BugTorchConfig;
import net.minecraft.launchwrapper.Launch;

public class BugTorchMixinPlugin implements IMixinConfigPlugin {

    static {
        String configFolder =  "config" + File.separator + BugTorchCore.MODID + File.separator;
        BugTorchConfig.loadBaseMixinConfig(new File(Launch.minecraftHome, configFolder + "mixins.cfg"));
    }
    
    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        List<String> mixins = new ArrayList<>();

        //Backports
        if(BugTorchConfig.cobwebsCanBeSheared) mixins.add("minecraft.block.MixinBlockWeb");
        if(BugTorchConfig.deadBushesDropSticks) mixins.add("minecraft.block.MixinBlockDeadBush");
        if(BugTorchConfig.fireArrowsDetonateTNTCarts) mixins.add("minecraft.entity.item.MixinEntityMinecartTNT");
        if(BugTorchConfig.throwEnderPearlsInCrativeMode) mixins.add("minecraft.item.MixinItemEnderPearl");

        //Bugfixes
        if(BugTorchConfig.fixFireChargeUseSound) mixins.add("minecraft.item.MixinItemFireball");
        if(BugTorchConfig.fixLavaHissOnAirReplace) mixins.add("minecraft.block.MixinBlockLiquid");
        if(BugTorchConfig.fixPumpkinPlacementCheck) mixins.add("minecraft.block.MixinBlockPumpkin");
        if(BugTorchConfig.fixStoneMonsterEggDoubleSpawns) mixins.add("minecraft.block.MixinBlockSilverfish");
        if(BugTorchConfig.fixShearedBlocksDropExtraItems) {
            mixins.add("minecraft.block.MixinBlockLeaves");
            mixins.add("minecraft.block.MixinBlockTallGrass");
        }
        if(BugTorchConfig.fixShearsNotTakingDamageFromNormalBlocks) mixins.add("minecraft.item.MixinItemShears");
        if(BugTorchConfig.fixSignPacketChatMessages) mixins.add("minecraft.client.network.MixinNetHandlerPlayClient");
        if(BugTorchConfig.fixVillagePathsHavePlantsOnTop) mixins.add("minecraft.world.gen.structure.MixinStructureVillagePieces_Path");
        if(BugTorchConfig.fixVillagerTradeMetadataDetection) mixins.add("minecraft.village.MixinMerchantRecipe");
        if(BugTorchConfig.fixVillageSieges) mixins.add("minecraft.village.MixinVillageSiege");
        if(BugTorchConfig.fixVillageWellDesertMaterial) mixins.add("minecraft.world.gen.structure.MixinStructureVillagePieces_Well");

        //Performance
        if(BugTorchConfig.brokenChestsDontSplitStacks) mixins.add("minecraft.block.MixinBlockChest");
        if(BugTorchConfig.brokenHoppersDontSplitStacks) mixins.add("minecraft.block.MixinBlockHopper");
        if(BugTorchConfig.fasterDroppedItemStackingChecks) mixins.add("minecraft.entity.item.MixinEntityItem");
        if(BugTorchConfig.fasterEntityLivingBaseIsPotionActiveAndSetAir) mixins.add("minecraft.entity.MixinEntityLivingBase");
        if(BugTorchConfig.fasterGetBlockByIdForAirBlocks) mixins.add("minecraft.block.MixinBlock");
        if(BugTorchConfig.fasterSnowBlockTicks) mixins.add("minecraft.block.MixinBlockSnowBlock");
        if(BugTorchConfig.moreAccurateLayeredSnowFaceCulling) mixins.add("minecraft.block.MixinBlockSnow");
        if(BugTorchConfig.replaceRandomInEffectRenderer) mixins.add("random.client.particle.MixinEffectRenderer");
        if(BugTorchConfig.replaceRandomInEntity) mixins.add("random.entity.MixinEntity");
        if(BugTorchConfig.replaceRandomInItem) mixins.add("random.item.MixinItem");
        if(BugTorchConfig.replaceRandomInMinecraftServer) mixins.add("random.server.MixinMinecraftServer");
        if(BugTorchConfig.replaceRandomInRenderItem) mixins.add("random.client.renderer.entity.MixinRenderItem");
        if(BugTorchConfig.replaceRandomInWorld) {
            BugTorchCore.logger.info("World.class will use a faster Random implementation, this impacts world generation slightly.");
            mixins.add("random.world.MixinWorld");
        }
        if(BugTorchConfig.replaceRandomInWorldClient) mixins.add("random.client.multiplayer.MixinWorldClient");
        if(BugTorchConfig.skipInitialWorldChunkLoad) mixins.add("minecraft.server.MixinMinecraftServer");

        //Tweaks
        if(BugTorchConfig.lanPortOverride) mixins.add("minecraft.server.integrated.MixinIntegratedServer");
        if(BugTorchConfig.placeEndPortalsAnywhere)mixins.add("minecraft.block.MixinBlockEndPortal");
        if(BugTorchConfig.removeEntityDuplicateExtendedPropertiesIdentifierSpam) mixins.add("minecraft.entity.MixinEntity");

        return mixins;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

}
