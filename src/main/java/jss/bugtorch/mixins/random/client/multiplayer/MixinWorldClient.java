package jss.bugtorch.mixins.random.client.multiplayer;

import jss.bugtorch.util.RandomXoshiro256StarStar;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(WorldClient.class)
public abstract class MixinWorldClient {

    @Redirect(method = "doVoidFogParticles", at = @At(value = "NEW", target = "java/util/Random"))
    private Random redirectDoVoidFogParticlesRandom() {
        return new RandomXoshiro256StarStar();
    }

}
