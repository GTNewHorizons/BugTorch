package jss.bugtorch.mixins.early.minecraft.fastrandom;

import java.util.Random;

import net.minecraft.client.multiplayer.WorldClient;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import jss.util.RandomXoshiro256StarStar;

@Mixin(value = WorldClient.class)
public abstract class MixinWorldClient {

    /**
     * @author jss2a98aj
     * @reason Xoshiro256** is faster than Random.
     */
    @Redirect(method = "doVoidFogParticles", at = @At(value = "NEW", target = "java/util/Random", ordinal = 0))
    private Random redirectDoVoidFogParticlesRandom() {
        return new RandomXoshiro256StarStar();
    }

}
