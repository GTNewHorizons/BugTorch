package jss.bugtorch.core;

import jss.bugtorch.config.BugTorchConfig;
import jss.bugtorch.features.squidFix.FixSquidSound;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;

public class VanillaSupport {

    public static void enableSupport() {
        // Backports
        if (BugTorchConfig.enableFloatingTrapDoors) {
            BlockTrapDoor.disableValidation = true;
        }

        // Bugfixes
        if (BugTorchConfig.fixJackOLanternBlocksRandomlyTicking) {
            Blocks.lit_pumpkin.setTickRandomly(false);
        }

        if (BugTorchConfig.fixPumpkinBlocksRandomlyTicking) {
            Blocks.pumpkin.setTickRandomly(false);
        }

        if (BugTorchConfig.fixSnowBlocksRandomlyTicking) {
            Blocks.snow.setTickRandomly(false);
        }

        if (BugTorchConfig.fixTorchBlocksRandomlyTicking) {
            Blocks.torch.setTickRandomly(false);
        }


        //Squids
        if(BugTorchConfig.fixSquidsSounds){
            MinecraftForge.EVENT_BUS.register(new FixSquidSound());
        }



    }
}
