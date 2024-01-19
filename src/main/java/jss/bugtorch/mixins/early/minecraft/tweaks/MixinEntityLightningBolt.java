package jss.bugtorch.mixins.early.minecraft.tweaks;

import net.minecraft.entity.effect.EntityLightningBolt;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import jss.bugtorch.config.BugTorchConfig;

@Mixin(value = EntityLightningBolt.class)
public abstract class MixinEntityLightningBolt {

    @ModifyConstant(method = "onUpdate", constant = @Constant(floatValue = 10000.0F))
    private static float reduceLightningVolume(float old) {
        return BugTorchConfig.reduceLightningVolume;
    }

}
