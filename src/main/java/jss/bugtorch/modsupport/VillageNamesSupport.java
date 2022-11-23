package jss.bugtorch.modsupport;

import astrotibs.villagenames.VillageNames;
import jss.bugtorch.config.BugTorchConfig;

public class VillageNamesSupport {

    public static void enableSupport() {
        // Tweaks
        if (BugTorchConfig.enableVillageNamesMetadataSensitiveTrades) {
            VillageNames.canVillagerTradesDistinguishMeta = true;
        }
    }
}
