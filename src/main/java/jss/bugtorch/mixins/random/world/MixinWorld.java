package jss.bugtorch.mixins.random.world;

import java.util.Random;
import jss.util.RandomXoshiro256StarStar;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = World.class)
public abstract class MixinWorld {

    /**
     * Xoshiro256** is faster than Random
     */
    public Random rand = new RandomXoshiro256StarStar();
}
