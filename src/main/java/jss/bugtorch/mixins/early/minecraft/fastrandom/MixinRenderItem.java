package jss.bugtorch.mixins.early.minecraft.fastrandom;

import java.util.Random;

import net.minecraft.client.renderer.entity.RenderItem;

import org.spongepowered.asm.mixin.Mixin;

import jss.util.RandomXoshiro256StarStar;

@Mixin(value = RenderItem.class)
public abstract class MixinRenderItem {

    /**
     * Xoshiro256** is faster than Random.
     */
    private Random random = new RandomXoshiro256StarStar();

}
