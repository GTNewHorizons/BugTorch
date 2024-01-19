package jss.bugtorch.features.extraVanilla;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundCategory;
import net.minecraftforge.client.event.sound.PlaySoundEvent17;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jss.bugtorch.config.BugTorchConfig;
import jss.bugtorch.util.JCSoundWarper;
import jss.bugtorch.util.StaticUtils;

public class onThunderSound {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onThunderSound(PlaySoundEvent17 e) {
        if (e != null && e.category == SoundCategory.AMBIENT || e.category == SoundCategory.WEATHER) {

            if ("ambient.weather.thunder".equals(e.name)) {
                JCSoundWarper mutator = new JCSoundWarper(e.sound);
                mutator.attenuationType = ISound.AttenuationType.LINEAR;
                mutator.volume = StaticUtils.getFloatRnd() * BugTorchConfig.thunderSoundVolumeMultiplier;
                e.result = mutator;
            }

        }

    }
}
