package jss.bugtorch.mixins.early.minecraft.fastrandom;

import java.util.Random;

import net.minecraft.item.Item;

import org.spongepowered.asm.mixin.Mixin;

import jss.util.RandomXoshiro256StarStar;

@Mixin(value = Item.class)
public abstract class MixinItem {

    /**
     * Xoshiro256** is faster than Random.
     */
    private static Random itemRand = new RandomXoshiro256StarStar();

}
