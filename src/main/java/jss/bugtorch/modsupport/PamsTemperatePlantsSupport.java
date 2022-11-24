package jss.bugtorch.modsupport;

import com.pam.temperateplants.temperateplants;
import jss.bugtorch.config.BugTorchConfig;
import net.minecraft.block.Block;

public class PamsTemperatePlantsSupport {

    public static void enableSupport() {
        // Bugfixes
        if (BugTorchConfig.fixPamsTemperatePlantsBlockSounds) {
            temperateplants.pamtemperatePlant.setStepSound(Block.soundTypeGrass);
        }
    }
}
