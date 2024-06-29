package jss.bugtorch.features.extraVanilla;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jss.bugtorch.config.BugTorchConfig;

public class onMobSaySilenser {

    @SubscribeEvent
    public void onMobSay(PlaySoundAtEntityEvent e) {
        // Shut up mobs
        World world = e.entity.worldObj;
        if (world.isRemote) {
            return;
        }
        if (e.entity instanceof EntityLiving) {
            EntityLiving entity = (EntityLiving) e.entity;
            if (entity.livingSoundTime == -entity.getTalkInterval()) {
                int extrShutup = -(entity.worldObj.rand.nextInt(BugTorchConfig.mobSaySoundDelay)
                        + entity.getTalkInterval());
                entity.livingSoundTime = extrShutup;
                return;
            }

        }

    }

}
