package jss.bugtorch.mixins.random.client.renderer.entity;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;

import jss.util.RandomXoshiro256StarStar;
import net.minecraft.client.renderer.entity.RenderItem;

@Mixin(value = RenderItem.class)
public class MixinRenderItem {

    /**
     *Xoshiro256** is faster than Random
     */
    private Random random = new RandomXoshiro256StarStar();

}
