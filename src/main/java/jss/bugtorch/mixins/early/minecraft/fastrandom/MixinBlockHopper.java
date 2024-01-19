package jss.bugtorch.mixins.early.minecraft.fastrandom;

import java.util.Random;

import net.minecraft.block.BlockHopper;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

import jss.util.RandomXoshiro256StarStar;

@Mixin(value = BlockHopper.class)
public abstract class MixinBlockHopper {

    /**
     * Xoshiro256** is faster than Random.
     */
    @Final
    private Random field_149922_a = new RandomXoshiro256StarStar();

}
