package jss.bugtorch.features.extraVanilla;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.item.ItemTossEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jss.bugtorch.BugTorch;
import jss.bugtorch.util.JCHDelayer;
import jss.bugtorch.util.StaticUtils;

public class onPlayerToss {

    JCHDelayer d = new JCHDelayer(100);

    EntityPlayer lastPlayer;

    @SubscribeEvent
    public void onPlayeToss(ItemTossEvent e) {
        EntityPlayer p = e.player;

        if (e.player != null && !p.worldObj.isRemote) {
            if (d.isRedy() || lastPlayer != p) {
                lastPlayer = p;
                StaticUtils.swingHand(p);
                StaticUtils.playSoundAt(BugTorch.MODID + ":PToss", p, 0.3F, p.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

        }
    }

}
