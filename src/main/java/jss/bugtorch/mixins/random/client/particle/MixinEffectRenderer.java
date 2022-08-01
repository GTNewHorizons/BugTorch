package jss.bugtorch.mixins.random.client.particle;

import java.util.Random;
import jss.util.RandomXoshiro256StarStar;
import net.minecraft.client.particle.EffectRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = EffectRenderer.class)
public abstract class MixinEffectRenderer {

    /**
     * Xoshiro256** is faster than Random
     */
    public Random rand = new RandomXoshiro256StarStar();
}
