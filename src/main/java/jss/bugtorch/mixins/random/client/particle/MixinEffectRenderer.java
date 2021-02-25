package jss.bugtorch.mixins.random.client.particle;

import jss.bugtorch.util.RandomXoshiro256StarStar;
import net.minecraft.client.particle.EffectRenderer;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(EffectRenderer.class)
public class MixinEffectRenderer {

    public Random rand = new RandomXoshiro256StarStar();

}
