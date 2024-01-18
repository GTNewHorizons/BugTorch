package jss.bugtorch.util;

import glowredman.txloader.TXLoaderCore;
import jss.bugtorch.config.BugTorchConfig;

public class AssetLoader {

    public static void load() {
        addAssets("sounds/mob/ghast/fireball4.ogg");

        if (BugTorchConfig.addSquidsSounds) {
            addAssets(
                    "sounds/entity/squid/ambient1.ogg",
                    "sounds/entity/squid/ambient2.ogg",
                    "sounds/entity/squid/ambient3.ogg",
                    "sounds/entity/squid/ambient4.ogg",
                    "sounds/entity/squid/ambient5.ogg",
                    "sounds/entity/squid/death1.ogg",
                    "sounds/entity/squid/death2.ogg",
                    "sounds/entity/squid/death3.ogg",
                    "sounds/entity/squid/hurt1.ogg",
                    "sounds/entity/squid/hurt2.ogg",
                    "sounds/entity/squid/hurt3.ogg",
                    "sounds/entity/squid/hurt4.ogg",
                    "sounds/entity/squid/squirt1.ogg",
                    "sounds/entity/squid/squirt2.ogg",
                    "sounds/entity/squid/squirt3.ogg");
        }


        if(BugTorchConfig.addTossAnimation && !BugTorchConfig.addHitSound){
            //Toss sounds Only
            addAssets(
                    "sounds/entity/player/attack/weak1.ogg",
                    "sounds/entity/player/attack/weak3.ogg");

        }

        if(BugTorchConfig.addHitSound){
            addAssets(

                    //weak

                    "sounds/entity/player/attack/weak1.ogg",
                    "sounds/entity/player/attack/weak2.ogg",
                    "sounds/entity/player/attack/weak3.ogg",
                    "sounds/entity/player/attack/weak4.ogg",
                    //knockback

                    "sounds/entity/player/attack/knockback1.ogg",
                    "sounds/entity/player/attack/knockback2.ogg",
                    "sounds/entity/player/attack/knockback3.ogg",
                    "sounds/entity/player/attack/knockback4.ogg",
                    //strong

                    "sounds/entity/player/attack/strong1.ogg",
                    "sounds/entity/player/attack/strong2.ogg",
                    "sounds/entity/player/attack/strong3.ogg",
                    "sounds/entity/player/attack/strong4.ogg",
                    "sounds/entity/player/attack/strong5.ogg",
                    "sounds/entity/player/attack/strong6.ogg",
                    //crit

                    "sounds/entity/player/attack/crit1.ogg",
                    "sounds/entity/player/attack/crit2.ogg",
                    "sounds/entity/player/attack/crit3.ogg"



            );
        }

    }

    private static void addAssets(String... resourcePaths) {
        for (String path : resourcePaths) {
            TXLoaderCore.getAssetBuilder("minecraft/" + path)
                    .setOverride("bugtorch/" + path)
                    .setVersion("1.19.2")
                    .add();
        }
    }
}
