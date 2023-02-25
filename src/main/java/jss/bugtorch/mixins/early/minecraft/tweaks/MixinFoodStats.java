package jss.bugtorch.mixins.early.minecraft.tweaks;

import jss.bugtorch.config.BugTorchConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.world.EnumDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = FoodStats.class, priority = 1010)
public abstract class MixinFoodStats {

    /**
     * @author jss2a98aj
     * @reason Makes starvation damage scale with max health.
     */
    @Redirect(
            method = "onUpdate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/EntityPlayer;attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z"
            )
    )
    private boolean bugTorch$scalingStarvationDamage(EntityPlayer player, DamageSource source, float damage) {
        float survivalThreshold = player.worldObj.difficultySetting == EnumDifficulty.HARD ? 0f : 1f;
        return player.attackEntityFrom(source, Math.min(
                BugTorchConfig.scaledStarvationDamageMaxHealthMult * player.getMaxHealth() + BugTorchConfig.scaledStarvationDamageMaxHealthFlat,
                player.getHealth() - survivalThreshold
        ));
    }

}
