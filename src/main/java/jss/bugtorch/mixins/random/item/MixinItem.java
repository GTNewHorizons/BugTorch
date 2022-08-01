package jss.bugtorch.mixins.random.item;

import java.util.Random;
import jss.util.RandomXoshiro256StarStar;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = Item.class)
public abstract class MixinItem {

    /**
     * Xoshiro256** is faster than Random
     */
    private static Random itemRand = new RandomXoshiro256StarStar();
}
