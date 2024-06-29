package jss.bugtorch.mixins.early.minecraft.fastrandom;

import java.util.Random;

import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;

import jss.util.RandomXoshiro256StarStar;

@Mixin(value = World.class)
public abstract class MixinWorld {

    /**
     * Xoshiro256** is faster than Random.
     */
    public Random rand = new RandomXoshiro256StarStar();

}
