package jss.bugtorch.mixins.random.client.renderer.entity;

import java.util.Random;
import jss.util.RandomXoshiro256StarStar;
import net.minecraft.client.renderer.entity.RenderItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = RenderItem.class)
public abstract class MixinRenderItem {

    /**
     * Xoshiro256** is faster than Random
     */
    private Random random = new RandomXoshiro256StarStar();
}
